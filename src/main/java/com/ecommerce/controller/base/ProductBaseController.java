package com.ecommerce.controller.base;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.bson.types.ObjectId;
import org.springframework.security.access.annotation.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import com.ecommerce.db.ecommerce_db.service.ProductService;
import com.ecommerce.db.ecommerce_db.entity.Product;

//IMPORT RELATIONS
import com.ecommerce.db.ecommerce_db.entity.Product;

public class ProductBaseController {
    
    @Autowired
	ProductService productService;



//CRUD METHODS


    //CRUD - CREATE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/products",method = RequestMethod.POST, headers = "Accept=application/json")
	public Product insert(@RequestBody Product obj) {
		 return productService.insert(obj);
	}

	
    //CRUD - REMOVE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void delete(@PathVariable("id") String id) {
		productService.delete(id);
	}
	
	
    //CRUD - GET ONE
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Product get(@PathVariable String id) {
		return productService.get(id);
	}
	
	
    //CRUD - GET LIST
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/products", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Product> getList() {
		return productService.getList();
	}
	
	

    //CRUD - EDIT
    @Secured({ "ROLE_PRIVATE_USER" })
	@RequestMapping(value = "/products/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
	public Product update(@RequestBody Product obj) {
		return productService.update(obj);
	}
	


/*
 * CUSTOM SERVICES
 * 
 *	These services will be overwritten and implemented in  Custom.js
 */


	
}
