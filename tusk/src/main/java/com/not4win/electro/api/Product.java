package com.not4win.electro.api;
import com.google.gson.annotations.Expose;

import java.util.List;

public class Product {
    @Expose
    private String brand;

    @Expose
    private String id;

    @Expose
    private String model;

    @Expose
    private String section;

    @Expose
    private String sharelink;

    @Expose
    private List<Store> stores;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSharelink() {
        return sharelink;
    }

    public void setSharelink(String sharelink) {
        this.sharelink = sharelink;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    @Override
    public String toString() {
        return "Product{" +
                "brand='" + brand + '\'' +
                ", id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", section='" + section + '\'' +
                ", sharelink='" + sharelink + '\'' +
                ", stores=" + stores +
                '}';
    }
}
