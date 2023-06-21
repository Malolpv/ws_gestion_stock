package epsi.ws_gestion_stock.controllers.Exceptions;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(final Long id){
        super("Could not find order : " + id);
    }
}
