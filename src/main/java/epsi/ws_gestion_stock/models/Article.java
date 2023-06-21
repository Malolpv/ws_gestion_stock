package epsi.ws_gestion_stock.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Article {

    //Attributes
    private @Id @GeneratedValue Long id;
    @Column(unique = true)
    private String name;
    private Integer quantity;
    private Double price;

    //Constructors
    public Article() {}

    public Article(String name, Integer quantity, Double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    //Accessors
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    //Methods

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Article article))
            return false;
        return Objects.equals(this.id, article.id) && Objects.equals(this.name, article.name)
                && Objects.equals(this.quantity, article.quantity) && Objects.equals(this.price, article.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.quantity, this.price);
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + this.id + ", name='" + this.name + '\'' + ", quantity='" + this.quantity + '\'' + ", price=" + this.price +'}';
    }
}
