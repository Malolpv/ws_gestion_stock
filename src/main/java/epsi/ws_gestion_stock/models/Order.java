package epsi.ws_gestion_stock.models;

import epsi.ws_gestion_stock.Dto.ArticleDTO;
import epsi.ws_gestion_stock.Dto.OrderDTO;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity(name = "order_tbl")
public class Order {

    //Attributes
    private @Id
    @GeneratedValue Long id;

    @Column(unique = true)
    private String label;

    @ManyToMany
    @JoinTable(
            name = "order_article",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "article_id")}
    )
    private List<Article> articles;

    //Constructors
    public Order() {}

    public Order(String label, List<Article> aticles) {
        this.label = label;
        this.articles = aticles;
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

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }


    //Methods


    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.label, this.articles);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Order order))
            return false;
        return Objects.equals(this.id, order.id) && Objects.equals(this.label, order.getLabel())
                && Objects.equals(this.articles, order.getArticles());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", articles=" + articles +
                '}';
    }

    public static List<OrderDTO> mapToDTO(List<Order> list){
        return list
                .stream()
                .map(Order::mapToDTO)
                .toList();
    }

    public static OrderDTO mapToDTO(Order order){
        return new OrderDTO(
                order.getId(),
                order.getLabel()
        );
    }
}
