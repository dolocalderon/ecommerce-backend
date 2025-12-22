package ecommerce.controller;

import ecommerce.config.Constants;
import ecommerce.dto.ArticleDTO;
import ecommerce.model.Article;
import ecommerce.service.interfaces.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(Constants.APP_NAME + "/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/get-all-article")
    public ResponseEntity<List<ArticleDTO>> getAllArticle() {
        return ResponseEntity.ok(articleService.getAllArticle());
    }

    @PostMapping("/save-article")
    public ResponseEntity<Article> saveArticle(@RequestBody Article article) {
        return ResponseEntity.ok(articleService.saveArticle(article));
    }
}


