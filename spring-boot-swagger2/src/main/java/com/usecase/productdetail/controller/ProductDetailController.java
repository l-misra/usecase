package com.usecase.productdetail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.usecase.productdetail.model.ProductDetail;
import com.usecase.productdetail.services.ProductDetailService;
import com.usecase.response.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "ProductDetailController", description = "Rest apis that gives product details")
@RestController
public class ProductDetailController {

        @Autowired
        private ProductDetailService productDetailService;


	@ApiOperation(value = "Get Product by Product Id", response = ProductDetail.class)
	@RequestMapping(value = "/getProductById/{id}" ,method = RequestMethod.GET)
	public Response getProductById(@PathVariable(value = "id") String id) {
	
	    if( id == null ) {
	        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "empty product id provided");
	    }
	    
	    return productDetailService.getProductById(id);
	}


}
