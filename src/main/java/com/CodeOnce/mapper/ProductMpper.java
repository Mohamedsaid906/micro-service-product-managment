package com.CodeOnce.mapper;

import com.CodeOnce.Dto.ProductDto;
import com.CodeOnce.entity.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductMpper {
    public static ProductDto modelToDto(Product product) {
        return new ProductDto(product.getId(), product.getName(), product.getDescription(), product.getQuantity(), product.getCreationDate());
    }

    public static List<ProductDto> modelsToDtos(Collection<Product> products) {
        if (products.isEmpty()) {
            return new ArrayList<>();
        }
        return products.stream().filter(Objects::nonNull).map(ProductMpper::modelToDto).collect(Collectors.toList());
    }

    public static Product dtoToModel(ProductDto productDto) {
        Product Product = com.CodeOnce.entity.Product.builder().id(productDto.getId()).name(productDto.getName()).creationDate(productDto.getCreationDate()).quantity(productDto.getQuantity()).description(productDto.getDescription()).build();
        return Product;
    }
}
