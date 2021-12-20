package com.usecase.orderdetail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.usecase.orderdetail.services.OrderDetailService;
import com.usecase.productdetail.model.ProductDetail;
import com.usecase.response.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "OrderDetailController", description = "Rest apis that places order details")
@RestController
public class OrderDetailController {

        @Autowired
        private OrderDetailService orderDetailService;


        @ApiOperation(value = "Get Product by Product Id", response = ProductDetail.class)
        @RequestMapping(value = "/postOrderById/{id}" ,method = RequestMethod.POST)
        public Response postOrderById(@PathVariable(value = "id") String id) {
        
            if( id == null ) {
                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "empty product id provided");
            }
            
            return orderDetailService.postOrderById(id);
        }


}
