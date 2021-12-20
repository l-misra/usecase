package com.usecase.productdetail.model;

public class ProductDetail {
    private String name;
    private String productId;
    private String price;
    private String availaibility;

    public ProductDetail(String name, String productId, String price, String availaibility) {
        super();
        this.name = name;
        this.productId = productId;
        this.price = price;
        this.availaibility = availaibility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAvailaibility() {
        return availaibility;
    }

    public void setAvailaibility(String availaibility) {
        this.availaibility = availaibility;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ProductDetail [name=" + name + ", productId=" + productId + ", price=" + price + ", availaibility="
                + availaibility + "]";
    }

}
