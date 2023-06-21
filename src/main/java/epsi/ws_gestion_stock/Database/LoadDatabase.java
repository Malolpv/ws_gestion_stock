package epsi.ws_gestion_stock.Database;

import epsi.ws_gestion_stock.models.Article;
import epsi.ws_gestion_stock.models.Order;
import epsi.ws_gestion_stock.repository.ArticleRepository;
import epsi.ws_gestion_stock.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);


    @Bean
    CommandLineRunner initDatabase(ArticleRepository articleRepository, OrderRepository orderRepository){

        Article a1 = new Article("Planche",300,14.99);
        Article a2 = new Article("Boîte de clou",853,12.0);
        Article a3 = new Article("Marteau",50,29.99);
        Article a4 = new Article("Hache",40,44.99);


        Order o1 = new Order("Oder_1", new ArrayList<Article>(Arrays.asList(a1,a2)));
        //Order o2 = new Order("Oder_2", new ArrayList<Article>(Arrays.asList(a3,a4)));
        return args -> {
            log.info("Preloading " + articleRepository.save(a1));
            log.info("Preloading " + articleRepository.save(a2));
            log.info("Preloading " + articleRepository.save(a3));
            log.info("Preloading " + articleRepository.save(a4));
            log.info("Preloading " + orderRepository.save(o1));
        //    log.info("Preloading " + orderRepository.save(o2));

        };

    }
}
