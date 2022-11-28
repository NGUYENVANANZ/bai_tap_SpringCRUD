package Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5, max = 20, message = "min = 5 and max 20")
    private String name;

    private String img;
    @NotNull(message = "Nhập vàoooo")
    @Min(value = 1, message = "Min 1")
    @Max(value = 99, message = "Max 99")
    private Double price;

    public Product() {
    }

    public Product(Long id, String name, String img, Double price) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
    }

    public Product(String name, String img, Double price) {
        this.name = name;
        this.img = img;
        this.price = price;
    }

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
