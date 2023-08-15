package spring.news.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.news.entity.Articles;
import spring.news.repository.NewsRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NewsFindService {

    private final NewsRepository newsRepository;

    public List<Articles> findAll() {
        return newsRepository.findAll();
    }

    public Optional<Articles> findById(Integer id) {
        return newsRepository.findById(id);
    }

    public List<Articles> findByNewsSite(String newsSite){
        return newsRepository.findAllByNewsSite(newsSite);
    }
}