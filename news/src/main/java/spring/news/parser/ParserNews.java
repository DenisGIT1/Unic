package spring.news.parser;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import spring.news.model.News;

import java.util.List;

@Component
public class ParserNews {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${articles_limit}")
    private String articles_limit;

    @Value("${skipped_articles}")
    private String skipped_articles;

    public List<News> getNewsFromSite() {

        String url = "https://api.spaceflightnewsapi.net/v3/articles?_limit=" + articles_limit + "&_start=" + skipped_articles;
        ResponseEntity<List<News>> response = restTemplate.exchange(url, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<News>>() {});
        return response.getBody();
    }
}