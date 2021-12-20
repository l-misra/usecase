package com.usecase.globalcache;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.usecase.Constants;
import com.usecase.productdetail.model.ProductDetail;

// instead of this global cahce we can use something like elastic search or apache cachendra.
@Component
public class GlobalCache {

    private static ConcurrentHashMap<String, ProductDetail> cache = new ConcurrentHashMap();

    static {
        System.out.println("Initializing cache.");
        ProductDetail product1 = new ProductDetail("aa", "a1", "11", Constants.AVAILABLE);
        ProductDetail product2 = new ProductDetail("bb", "b1", "21", Constants.NOT_AVAILABLE);
        put(product1);
        put(product2);
    }

    public static void put(ProductDetail productDetail) {
        System.out.println("Adding cache.");
        if (null != productDetail) {
            System.out.println("Adding cache.");
            System.out.println(productDetail);
            cache.put(productDetail.getProductId(), productDetail);
        }

    }

    public static ProductDetail getProduct(String id) {
        return cache.get(id);
    }

    public static void remove(String id) {
        System.out.println("Removing entry from cache for product id" + id);
        cache.remove(id);
        
    }

}
