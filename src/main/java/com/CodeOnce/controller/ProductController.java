package com.CodeOnce.controller;
import com.CodeOnce.constants.SwaggerApiMessageConstant;
import com.CodeOnce.entity.Category;
import com.CodeOnce.entity.Product;
import com.CodeOnce.repository.CategoryRepository;
import com.CodeOnce.service.Impl.ProductServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class ProductController {

    private final ProductServiceImpl productService;
    private final CategoryRepository categoryRepository;

    public ProductController(ProductServiceImpl productService, CategoryRepository categoryRepository) {
        this.productService = productService;
        this.categoryRepository = categoryRepository;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "An array of products was returned successfully"),
            @ApiResponse(code = 404, message = SwaggerApiMessageConstant.NOT_FOUND),
            @ApiResponse(code = 500, message = SwaggerApiMessageConstant.ERROR_OCCURRED)})
    @ApiOperation(value = "Get all products in a category with quantity greater than 0", response = ProductController.class, httpMethod = "GET")
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProductsByCategory(@RequestParam String categoryName) {
        // Find the category by name
        Category category = categoryRepository.findCategoryByName(categoryName);
        if (category == null) {
            return ResponseEntity.notFound().build();
        }

        // Find the products in the category with quantity > 0
        List<Product> products = productService.findByCategoryNameAndQuantityGreaterThan(category);
        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(products);
    }
}
