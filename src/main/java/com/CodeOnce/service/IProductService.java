package com.CodeOnce.service;


import com.CodeOnce.entity.Category;
import com.CodeOnce.entity.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAllProducts();

    void AddProduct(Product p);

    void DeleteProduct(Long id);


    void UpdateProduct(Long id, Product p);

    List<Product> findByCategoryNameAndQuantityGreaterThan(Category category);



}
