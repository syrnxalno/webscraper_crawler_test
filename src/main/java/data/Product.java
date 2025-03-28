package data;

public class Product { 
    private String url; 
    private String image; 
    private String name; 
    private String price; 

    // Constructor (optional but useful)
    public Product() {}

    public Product(String url, String image, String name, String price) {
        this.url = url;
        this.image = image;
        this.name = name;
        this.price = price;
    }

    // Getters (optional, useful for retrieving values)
    public String getUrl() {
        return url;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    // Setters (properly implemented)
    public void setUrl(String url) {
        this.url = url;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override 
    public String toString() { 
        return "{ \"url\":\"" + url + "\", " 
                + " \"image\": \"" + image + "\", " 
                + "\"name\":\"" + name + "\", " 
                + "\"price\": \"" + price + "\" }"; 
    }
}
