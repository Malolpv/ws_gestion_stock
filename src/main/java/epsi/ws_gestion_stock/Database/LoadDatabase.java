package epsi.ws_gestion_stock.Database;

import epsi.ws_gestion_stock.models.Article;
import epsi.ws_gestion_stock.repository.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);


    @Bean
    CommandLineRunner initDatabase(ArticleRepository articleRepository){
        return args -> {
            log.info("Preloading " + articleRepository.save(new Article("Planches",10,14.99)));
            log.info("Preloading " + articleRepository.save(new Article("Boîtes de clous",125,12.0)));
        };
    }
}
