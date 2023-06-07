package com.anaplan.main;

import com.anaplan.entity.Customer;
import com.anaplan.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainTestDemo {
    public static void main(String[] args) {

        Customer cust1 = new Customer(1, "Stefan Walker", 1);
        Customer cust2 = new Customer(2, "Daija Von", 1);
        Customer cust3 = new Customer(3, "Ariane Rodriguez", 1);
        Customer cust4 = new Customer(4, "Marques Nikolaus", 2);
        Customer cust5 = new Customer(5, "Rachelle Greenfelder", 0);
        Customer cust6 = new Customer(6, "Larissa White", 2);
        Customer cust7 = new Customer(7, "Fae Heidenreich", 1);
        Customer cust8 = new Customer(8, "Dino Will", 2);
        Customer cust9 = new Customer(9, "Eloy Stroman", 1);
        Customer cust10 = new Customer(10, "Brisa O Connell", 1);

        List<Customer> customers = new ArrayList<Customer>();
        customers.add(cust1);
        customers.add(cust2);
        customers.add(cust3);
        customers.add(cust4);
        customers.add(cust5);
        customers.add(cust6);
        customers.add(cust7);
        customers.add(cust8);
        customers.add(cust9);
        customers.add(cust10);

        Product prod1 = new Product(1, "omnis quod consequatur", "Games", 184.83,12.0);
        Product prod2 = new Product(2, "vel libero suscipit", "Toys", 12.66,20.0);
        Product prod3 = new Product(3, "non nemo iure", "Grocery", 498.02,09.1);
        Product prod4 = new Product(4, "voluptatem voluptas aspernatur", "Toys", 536.80,50.0);
        Product prod5 = new Product(5, "animi cum rem", "Games", 458.20,30.0);
        Product prod6 = new Product(6, "dolorem porro debitis", "Toys", 146.52,30.0);
        Product prod7 = new Product(7, "aspernatur rerum qui", "Books", 656.42,12.0);
        Product prod8 = new Product(8, "deleniti earum et", "Baby", 41.46,12.0);
        Product prod9 = new Product(9, "voluptas ut quidem", "Books", 697.57,30.0);
        Product prod10 = new Product(10, "eos sed debitis", "Baby", 366.90,10.0);
        Product prod11 = new Product(11, "laudantium sit nihil", "Toys", 95.50,30.20);
        Product prod12 = new Product(12, "ut perferendis corporis", "Grocery", 302.19,09.0);
        Product prod13 = new Product(13, "sint voluptatem ut", "Toys", 295.37,0.0);
        Product prod14 = new Product(14, "quos sunt ipsam", "Grocery", 534.64,0.0);
        Product prod15 = new Product(15, "qui illo error", "Baby", 623.58,1.0);
        Product prod16 = new Product(16, "aut ex ducimus", "Books", 551.39,0.1);
        Product prod17 = new Product(17, "accusamus repellendus minus", "Books", 240.58,1.0);
        Product prod18 = new Product(18, "aut accusamus quia", "Baby", 881.38,10.0);
        Product prod19 = new Product(19, "doloremque incidunt sed", "Games", 988.49,30.2);
        Product prod20 = new Product(20, "libero omnis velit", "Baby", 177.61,02.0);
        Product prod21 = new Product(21, "consectetur cupiditate sunt", "Toys", 95.46,02.0);
        Product prod22 = new Product(22, "itaque ea qui", "Baby", 677.78,09.2);
        Product prod23 = new Product(23, "non et nulla", "Grocery", 70.49,0.0);
        Product prod24 = new Product(24, "veniam consequatur et", "Books", 893.44,09.2);
        Product prod25 = new Product(25, "magnam adipisci voluptate", "Grocery", 366.13,09.3);
        Product prod26 = new Product(26, "reiciendis consequuntur placeat", "Toys", 359.27,4.0);
        Product prod27 = new Product(27, "dolores ipsum sit", "Toys", 786.99,1.0);
        Product prod28 = new Product(28, "ut hic tempore", "Toys", 316.09,0.4);
        Product prod29 = new Product(29, "quas quis deserunt", "Toys", 772.78,10.0);
        Product prod30 = new Product(30, "excepturi nesciunt accusantium", "Toys", 911.46,10.4);

        List<Product> products = new ArrayList<>();
        products.add(prod1);
        products.add(prod2);
        products.add(prod3);
        products.add(prod4);
        products.add(prod5);
        products.add(prod6);
        products.add(prod7);
        products.add(prod8);
        products.add(prod9);
        products.add(prod10);

        // products.stream().filter(p -> p.getCategory()=="Books" && p.getPrice()>100).collect(Collectors.toList());

        // products.stream().filter(p -> p.getCategory().equalsIgnoreCase("Books")&& p.getPrice()>100).collect(Collectors.toList());

        // products.stream().filter(p -> p.getCategory().contentEquals("Books")&& p.getPrice()<=100).collect(Collectors.toList());

        List<Product> filteredProducts = products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Books") && p.getPrice()< 1000)
                .collect(Collectors.toList());
        filteredProducts.forEach(System.out::println);

        //  Category Baby

        List<Product> filteredProduct = products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Baby"))
                .collect(Collectors.toList());
        filteredProduct.forEach(System.out::println);


        // Apply 10% Discount on Toys

        List<Product> filteredProducts2 = products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
                .collect(Collectors.toList());
        filteredProducts.forEach(p -> p.setApplyDiscount(10.0));
        System.out.println("Filtered products with discount:");
        filteredProducts2.forEach(System.out::println);

// get the cheapest book

        List<Product> filteredProducts1 = products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Books") && p.getPrice()>=700)
                .collect(Collectors.toList());
        filteredProducts1.forEach(System.out::println);

    }
}
