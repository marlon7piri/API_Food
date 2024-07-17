package com.apiFood.entities.product;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductRequest {

    private String name;
    private Double price;
    private Long categoryId;
    private Long quantity;


    public ProductRequest(String name, Double price, Long categoryId, Long quantity) {
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.quantity = quantity;
    }

    // Getters and setters
    public String getName() {
        return name;
    }


    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}