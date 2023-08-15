package spring.news.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import spring.news.entity.Articles;
import spring.news.model.News;
import spring.news.parser.ParserNews;
import spring.news.repository.NewsRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.*;

@Service
public class NewsDownloadService {

    private final NewsRepository newsRepository;
    private final ConverterByArticles converterByArticles;
    private final ParserNews parserNews;

    public NewsDownloadService(NewsRepository newsRepository, ConverterByArticles converterByArticles, ParserNews parserNews) {
        this.newsRepository = newsRepository;
        this.converterByArticles = converterByArticles;
        this.parserNews = parserNews;
    }

    @Value("#{'${blackList}'.split(';')}")
    private List<String> blackList;

    @Value("${limitRecords}")
    private Integer limitRecords;

    @Value("${countThread}")
    private Integer countThread;


    public void startPoolThreads() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(countThread);
        List<Articles> buffer = new ArrayList<>();
        List<News> infoByNews = sortedBuffer(filterNews(getInformationByNews(), limitRecords));
        for (News news : infoByNews) {
            Future<Articles> future = pool.submit(new CallableImpl(news));
            buffer.add(future.get());
        }
        excessLimit(buffer);
        pool.shutdown();
        buffer.clear();
    }

    private List<News> getInformationByNews() {
        return parserNews.getNewsFromSite();
    }
    private List<News> filterNews(List<News> arr, Integer limit) {
        List<News> arrSelect = new ArrayList<>();
        for (News n : arr) {
            if (filterByWords(n) && arrSelect.size() < limit) {
                arrSelect.add(n);
            }
        }
        return arrSelect;
    }

    private boolean filterByWords(News news) {
        String nameTitle = news.getTitle();
        for (String s : blackList) {
            if (nameTitle.toLowerCase().contains(s.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    private List<News> sortedBuffer(List<News> buffer) {
        return buffer.stream().sorted(Comparator.comparing(News::getPublishedAt)
                .thenComparing(News::getNewsSite).thenComparing(News::getTitle)).toList();
    }
    class CallableImpl implements Callable<Articles> {
        private News news;
        public CallableImpl(News news) {
            this.news = news;
        }
        @Override
        public Articles call() throws Exception {
            return converterByArticles.converterByArticles(news, news.getUrl());
        }
    }
    private void excessLimit(List<Articles> buffer) {
        newsRepository.saveAll(buffer);
    }
}