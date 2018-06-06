package com.ecommerce.db.ecommerce_db.service.base;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.db.ecommerce_db.entity.Product;

//IMPORT RELATIONS
import com.ecommerce.db.ecommerce_db.entity.Product;

@Service
public class ProductBaseService {

	
	@Autowired
	private Datastore datastore;


    //CRUD METHODS
    
    //CRUD - CREATE
    	
	public Product insert(Product obj) {
		datastore.save(obj);
		return obj;
	}
	
    	
    //CRUD - REMOVE
    
	public void delete(String id) {
		Query<Product> query = datastore.createQuery(Product.class).field("_id").equal(new ObjectId(id));
		datastore.delete(query);
	}

    	
    //CRUD - GET ONE
    	
	public Product get(String id) {
		return datastore.find(Product.class).field("_id").equal(new ObjectId(id)).get();
	}

    	
        	
    //CRUD - GET LIST
    	
	public List<Product> getList() {
		return (ArrayList<Product>) datastore.find(Product.class).asList();
	}

    	
    //CRUD - EDIT
    	
	public Product update(Product obj) {
		datastore.save(obj);
		return obj;
	}
	
    	
    
    

    
    /*
     * CUSTOM SERVICES
     * 
     *	These services will be overwritten and implemented in productService.java
     */
    


}
