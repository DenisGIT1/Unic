package spring.news.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.news.entity.Articles;
import spring.news.model.News;
import spring.news.parser.ParserArticles;

import java.io.IOException;

@Service
@AllArgsConstructor
public class ConverterByArticles {

    private final ParserArticles parserArticles;
    public Articles converterByArticles(News news, String url) throws IOException {
        Articles art = new Articles();
        art.setId(news.getId());
        art.setTitle(news.getTitle());
        art.setNewsSite(news.getNewsSite());
        art.setPublishedDate(news.getPublishedAt());
        art.setArticle(textArticles(url));
        return art;
    }
    private String textArticles(String url) throws IOException {
        return parserArticles.parserTextArticles(url);
    }
}