package epsi.ws_gestion_stock.controllers;

import epsi.ws_gestion_stock.controllers.Exceptions.ArticleNotFoundException;
import epsi.ws_gestion_stock.models.Article;
import epsi.ws_gestion_stock.repository.ArticleRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "articles",produces = APPLICATION_JSON_VALUE)
public class ArticleController {

    private final ArticleRepository articleRepository;

    ArticleController(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    @GetMapping("")
    List<Article> all() {
        return articleRepository.findAll();
    }

    @PostMapping("")
    Article newArticle(@RequestBody Article article){
        return articleRepository.save(article);
    }

    @GetMapping("/{id}")
    Article one(@PathVariable Long id){
        return articleRepository.findById(id).orElseThrow(() -> new ArticleNotFoundException(id));
    }

    @PutMapping("/{id}")
    Article replaceArticle(@RequestBody Article newArticle, @PathVariable Long id){
        return articleRepository.findById(id).map(article -> {
                    article.setName(newArticle.getName());
                    article.setQuantity(newArticle.getQuantity());
                    article.setPrice(newArticle.getPrice());
                    return articleRepository.save(article);
                    }).orElseGet(() -> {
                        newArticle.setId(id);
                        return articleRepository.save(newArticle);
                    });
    }

    @DeleteMapping("/{id}")
    void deleteArticle(@PathVariable Long id){
        articleRepository.deleteById(id);
    }

}
