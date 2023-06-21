package epsi.ws_gestion_stock.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class OrderDTO {


    //Attributes
    private @Id
    @GeneratedValue Long id;

    @Column(unique = true)
    private String label;

    //Constructors
    public OrderDTO() {}

    public OrderDTO(Long id, String label){
        this.id = id;
        this.label = label;
    }

    //Accessors

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
