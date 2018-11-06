package com.not4win.electro.api;
import com.google.gson.annotations.Expose;

import java.util.List;

public class ProductResponse {
    @Expose
    private List<Product> product;

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

}
