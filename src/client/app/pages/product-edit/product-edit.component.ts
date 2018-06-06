// Import Libraries
import { ActivatedRoute, Params } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';

// Import Services
import { ProductService } from '../../services/product.service';
import { UserService } from '../../services/user.service';

// Import Models
import { Product } from '../../domain/ecommerce_db/product';

import { User } from '../../domain/ecommerce_db/user';

// START - USED SERVICES
/*
 *	productService.create
 *		PARAMS: 
 *		
 *
 *	UserService.findByuserProd
 *		PARAMS: 
 *					Objectid key - Id della risorsa userProd da cercare
 *		
 *
 *	productService.get
 *		PARAMS: 
 *					ObjectId id - Id 
 *		
 *
 *	productService.update
 *		PARAMS: 
 *					ObjectId id - Id
 *		
 *
 */
// END - USED SERVICES

// START - REQUIRED RESOURCES
/*
 * UserService  
 * productService  
 */
// END - REQUIRED RESOURCES

/**
 * Edit component for productEdit
 */
@Component({
    selector: 'product-edit',
    templateUrl : './product-edit.component.html',
    styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {

    item: Product;
    listUserProd: Product[];
	externalUser: User[];
    model: Product;
    
    constructor(
        private productService: ProductService,
        private userService: UserService,
        private route: ActivatedRoute,
        private location: Location) {
        // Init item
        this.item = new Product();
	   this.externalUser = [];
    }

    ngOnInit(): void {
            this.route.params.subscribe(param => {
                let id: string = param['id'];
                if (id !== 'new') {
                    // Get item from server 
                    this.productService.get(id).subscribe(item => this.item = item);
                    
                    
                    this.userService.findByUserProd(id).subscribe(list => this.externalUser = list);
                    
                }
            });
    }

    /**
     * Save Item
     */
    save (formValid:boolean, item: Product): void{
        if (formValid) {
            if(item._id){
                this.productService.update(item).subscribe(data => this.goBack());
            } else {
                this.productService.create(item).subscribe(data => this.goBack());
            }  
        }
    }

    /**
     * Go Back
     */
    goBack(): void {
        this.location.back();
    }
    

}