package com.example.PMS_SPRING_MVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServices {

    @Autowired
    ProductDB db;

    //ADD PRODUCT
    public void addProduct(Product product){
        System.out.println("ADDING PRODUCT");
        db.save(product);
    }


    //ALL PRODUCTS
    public List<Product> getAllProducts() {
        System.out.println("GET ALL PRODUCTS:");
        List<Product> ps=db.findAll();
        return ps;
    }

    //GET PRODUCT BY NAME
    public List<Product> getProductByName(String name) {
        System.out.println("GET PRODUCTS BY NAME");
        List<Product> ps=db.findByName(name);//DSL(DOMAIN SPECIFIC LANGUAGE)
        return ps;
    }



    // GET PRODUCT BY PLACE
    public List<Product> getProductByPlace(String place) {
        System.out.println("GET PRODUCTS BY PLACE");
        List<Product> ps = db.findByPlace(place); // DSL
        return ps;
    }



    // DELETE PRODUCT BY NAME
    public String deleteProductByName(String name){
    	System.out.println("DELETE PRODUCT BY NAME");
    	List<Product> ps=db.findByName(name);

    	if(!ps.isEmpty()) {
    		db.deleteByName(name);
    		return name + " Product is deleted!";
    	}
    	else {
    		return "Product not found with this name: "+ name;
    	}
    }



    // DELETE ALL PRODUCTS
    public String deleteAllProducts(){
        System.out.println("DELETE All PRODUCTS");
        List<Product> list=db.findAll();
        if(!list.isEmpty()){
            db.deleteAll();
            return "All products are deleted!";
        }
        else{
            return "List is Empty!";
        }
    }



    //OUT OF WARRENTY
    public List<Product> outOfWarrenty(int year) {
        System.out.println("OUT OF WARRENTY");
        List<Product> list = db.findAll();
        List<Product> out = new ArrayList<>();

        for (Product p : list) {
            if (p.getWarrenty() < year) {
                out.add(p);
            }
        }
        return out;
    }


    //FIND BY SUBSTRING
    public List<Product> findBySubString(String text){
        System.out.println("FIND BY SUBSTRING");
        text=text.toLowerCase();

        List<Product> list=db.findAll();
        List<Product> filtered=new ArrayList<>();

        for(Product p: list){
            String year=String.valueOf(p.getWarrenty());
            if(p.getName().toLowerCase().contains(text) || p.getType().toLowerCase().contains(text) ||
                    p.getPlace().toLowerCase().contains(text) || year.contains(text)){
                filtered.add(p);
            }
        }
        return filtered;
    }

    // Update product by name
    public String updateProductByName(String name, Product product) {
        name = name.toLowerCase();
        List<Product> p = db.findByName(name);

        if (!p.isEmpty()) {
            for (Product pro : p) {
                if (pro.getName().toLowerCase().equals(name)) {
                    pro.setPlace(product.getPlace());
                    pro.setType(product.getType());
                    pro.setWarrenty(product.getWarrenty());
                    db.save(pro);
                }
            }
            return "Product is updated!";
        }

        return "No product found with this name: " + name;
    }


}
