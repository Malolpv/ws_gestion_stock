package epsi.ws_gestion_stock.controllers.Advices;

import epsi.ws_gestion_stock.controllers.Exceptions.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class OrderNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(OrderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String articleNotFoundHandler(OrderNotFoundException ex){
        return ex.getMessage();
    }
}
