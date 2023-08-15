package spring.news.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ParserArticles {
    public String parserTextArticles(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        return doc.body().text();
    }
}