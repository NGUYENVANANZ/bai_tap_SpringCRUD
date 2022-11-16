package Model;

public class Product {
    private int id;
    private String name;
    private String img;
    private Double price;

    public Product() {
    }

    public Product(int id, String name, String img, Double price) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
