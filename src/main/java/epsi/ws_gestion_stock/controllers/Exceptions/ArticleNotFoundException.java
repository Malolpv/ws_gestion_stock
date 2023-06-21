package epsi.ws_gestion_stock.controllers.Exceptions;

public class ArticleNotFoundException extends RuntimeException{

    public ArticleNotFoundException(final Long id){
        super("Could not find article : " + id);
    }
}
