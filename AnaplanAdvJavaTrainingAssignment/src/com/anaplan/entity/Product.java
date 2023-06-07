package com.anaplan.entity;

public class Product {
    private Integer id;
    private String name;
    private String category;
    private Double price;
    private Double applyDiscount;

    public Product(Integer id, String name, String category, Double price, Double applyDiscount) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.applyDiscount = applyDiscount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getApplyDiscount() {
        return applyDiscount;
    }

    public void setApplyDiscount(Double applyDiscount) {
        this.applyDiscount = applyDiscount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", applyDiscount=" + applyDiscount +
                '}';
    }
}
