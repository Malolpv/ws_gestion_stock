package epsi.ws_gestion_stock.repository;

import epsi.ws_gestion_stock.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
