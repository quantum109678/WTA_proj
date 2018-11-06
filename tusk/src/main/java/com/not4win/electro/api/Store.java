package com.not4win.electro.api;
import com.google.gson.annotations.Expose;

public class Store {
    @Expose
    private String image;

    @Expose
    private String offer;

    @Expose
    private String price;

    @Expose
    private String stock;

    @Expose
    private String url;

    @Expose
    private String website;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "Store{" +
                "image='" + image + '\'' +
                ", offer='" + offer + '\'' +
                ", price='" + price + '\'' +
                ", stock='" + stock + '\'' +
                ", url='" + url + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
