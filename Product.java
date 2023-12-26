import java.util.Map;

abstract public class Product {
    private int price;
    private int id;
    private String name;
    private int stock_availibility;
    private String brand_name;
    private String color;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    private String owner_id;

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", stock_availibility=" + stock_availibility +
                ", brand_name='" + brand_name + '\'' +
                ", color='" + color + '\'' +
                ", owner_id='" + owner_id + '\'' +
                '}';
    }

    /*public Product(String product_id, String product_name, int product_stock, String product_brand, String product_color){
            id = product_id;
            name = product_name;
            brand_name = product_brand;
            color = product_color;
            stock_availibility = product_stock;
        }*/
    public abstract void update_product();

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStock_availibility(int stock_availibility) {
        this.stock_availibility = stock_availibility;
    }

    public String getName() {
        return name;
    }

    public int getStock_availibility() {
        return stock_availibility;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public String getColor() {
        return color;
    }

    public void setId(int id) {
        this.id = id;
    }
}
