package fr.gantoin.controller;

import java.io.IOException;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gantoin.service.ArticleService;

@RestController
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/refresh-gists")
    // Every hour
    @Scheduled(cron = "0 0 * * * *")
    public void refreshGists() {
        try {
            articleService.downloadArticles();
        } catch (IOException e) {
            throw new RuntimeException("Error while downloading articles", e);
        }
    }
}
