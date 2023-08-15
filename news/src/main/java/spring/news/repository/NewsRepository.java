package spring.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.news.entity.Articles;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<Articles, Integer> {
    List<Articles> findAllByNewsSite(String newsSite);

}