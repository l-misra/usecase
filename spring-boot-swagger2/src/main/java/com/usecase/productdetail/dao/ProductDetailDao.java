package com.usecase.productdetail.dao;

import org.springframework.stereotype.Component;

import com.usecase.Constants;
import com.usecase.db.ProductDetailDb;
import com.usecase.globalcache.GlobalCache;
import com.usecase.productdetail.model.ProductDetail;

@Component
public class ProductDetailDao {

    public ProductDetail getProductById(String id) {
        ProductDetail productDetailFromCache = GlobalCache.getProduct(id);
        if (null == productDetailFromCache || productDetailFromCache.getAvailaibility() == Constants.NOT_AVAILABLE) {
            ProductDetail productDetailFromDb = ProductDetailDb.getProduct(id);
            if (productDetailFromDb != null) {
                if (productDetailFromCache == null
                        || !productDetailFromDb.getAvailaibility().equals(productDetailFromCache.getAvailaibility())) {
                    System.out.println("updating cache for product " + productDetailFromCache);
                    GlobalCache.put(productDetailFromDb);
                    System.out.println("updated cache with product " + productDetailFromDb);

                }
                return productDetailFromDb;
            } else {
                System.out.println("Removing cache entry for product id " + id);
                GlobalCache.remove(id);
                return null;
            }
        }
        return productDetailFromCache;
    }


}
