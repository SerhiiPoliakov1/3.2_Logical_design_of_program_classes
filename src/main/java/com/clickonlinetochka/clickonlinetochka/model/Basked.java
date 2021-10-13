package com.clickonlinetochka.clickonlinetochka.model;

import java.util.HashMap;
import java.util.Map;

public class Basked {
    private Map<Product,Long> productInBasked = new HashMap();

    public void addProductInbasked(Product product, Long count ){
        productInBasked.put(product,count);
    }
    public void deleteProductFromBasked(Product product){
        productInBasked.remove(product);
    }
    public void changeCountProduct(Product product ,Long newCount){
        productInBasked.replace(product,newCount);
    }
    public void clearBasked(){
        productInBasked.clear();
    }

    public Map<Product, Long> getProductInBasked() {
        return productInBasked;
    }
}
