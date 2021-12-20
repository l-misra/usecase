package com.usecase.db;

import java.util.concurrent.ConcurrentHashMap;

import com.usecase.Constants;
import com.usecase.productdetail.model.ProductDetail;

public class ProductDetailDb {
    private static ConcurrentHashMap<String, ProductDetail> db = new ConcurrentHashMap();

    static {
        System.out.println("Initializing db.");
        ProductDetail product1 = new ProductDetail("aa", "a1", "11", Constants.AVAILABLE);
        ProductDetail product2 = new ProductDetail("bb", "b1", "21", Constants.NOT_AVAILABLE);

        ProductDetail product3 = new ProductDetail("cc", "c1", "31", Constants.AVAILABLE);
        ProductDetail product4 = new ProductDetail("dd", "d1", "41", Constants.NOT_AVAILABLE);

        put(product1);
        put(product2);
        put(product3);
        put(product4);
    }

    public static void put(ProductDetail productDetail) {
        if (null != productDetail) {
            System.out.println("Adding to db. product " + productDetail);
            db.put(productDetail.getProductId(), productDetail);
        }

    }

    public static ProductDetail getProduct(String id) {
        ProductDetail detail = db.get(id);
        System.out.println("Fetched from db " + detail);
        return detail;
    }
}
