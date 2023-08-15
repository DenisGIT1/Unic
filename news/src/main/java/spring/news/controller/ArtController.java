package spring.news.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.news.entity.Articles;
import spring.news.service.NewsFindService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class ArtController {

    private final NewsFindService newsFindService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Articles> getAllArticles(){
        return newsFindService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Articles findById(@PathVariable Integer id) {
        return newsFindService.findById(id).orElse(null);
    }

    @RequestMapping(value = "/newsSite/{newsSite}", method = RequestMethod.GET)
    public List<Articles> findByNewsSite(@PathVariable String newsSite) {
        return newsFindService.findByNewsSite(newsSite);
    }
}