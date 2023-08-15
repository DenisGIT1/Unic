package spring.news;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import spring.news.parser.ParserNews;
import spring.news.repository.NewsRepository;
import spring.news.service.ConverterByArticles;
import spring.news.service.NewsDownloadService;


@SpringBootApplication
@AllArgsConstructor
public class NewsApplication  {


	private final NewsRepository newsRepository;
	private final ConverterByArticles converterByArticles;
	private final ParserNews parserNews;


	public static void main(String[] args) {
		SpringApplication.run(NewsApplication.class, args);
	}

	@Bean(initMethod="startPoolThreads")
	public NewsDownloadService getBean() {
		return new NewsDownloadService(newsRepository, converterByArticles, parserNews);
	}
}