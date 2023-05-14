package com.CodeOnce.service.Impl;

import com.CodeOnce.entity.Category;
import com.CodeOnce.entity.Product;
import com.CodeOnce.repository.CategoryRepository;
import com.CodeOnce.repository.ProductRepository;
import com.CodeOnce.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {


    private  final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();   }

    @Override
    public void AddProduct(Product p) {

    }

    @Override
    public void DeleteProduct(Long id) {

    }

    @Override
    public void UpdateProduct(Long id, Product p) {

    }

    @Override
    public List<Product> findByCategoryNameAndQuantityGreaterThan(Category category) {
        return productRepository.findByCategoryAndQuantityGreaterThan(category, 0);
    }


}
