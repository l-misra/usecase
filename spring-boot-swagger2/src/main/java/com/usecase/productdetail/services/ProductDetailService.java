package com.usecase.productdetail.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.errorcode.ErrorCode;
import com.usecase.productdetail.dao.ProductDetailDao;
import com.usecase.productdetail.model.ProductDetail;
import com.usecase.response.ErrorResponse;
import com.usecase.response.Response;
import com.usecase.response.SuccessResponse;

@Service
public class ProductDetailService {

    @Autowired
    private ProductDetailDao productDetailDao;

    public Response getProductById(String id) {

        try {
            ProductDetail productDetail = productDetailDao.getProductById(id);
            String message = null;
            if (null == productDetail) {
                message = "No records found for product id " + id;
                System.out.println(message);
            }

            return new SuccessResponse(message, true, productDetail);

        } catch (Exception e) {
            System.err.println("Error occured");
            e.printStackTrace();
            return new ErrorResponse(e.getLocalizedMessage(), ErrorCode.UNKNOWN_ERROR, false);
        }

    }

}
