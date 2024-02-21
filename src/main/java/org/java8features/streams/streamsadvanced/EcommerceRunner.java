package org.java8features.streams.streamsadvanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EcommerceRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();
        while(true){
            System.out.println("Press 1: Insert Dummy Products and categories\nPress 2: Insert product along with categories" +
                    "\nPress 3: Get all products\nPress 4: Get all categories\nPress 5: Get all sub categories");
            int option = scanner.nextInt();
            if (option == 1) {
                addDummyProducts(productList);
            } else if (option == 2) {
                insertProduct(productList, scanner);
            } else if (option == 3) {
                getAllProducts(productList);
            } else if (option == 4) {
                getAllCategories(productList);
            } else if (option == 5) {
                getAllSubCategories(productList);
            } else if (option == 6) {
                updateCategory(productList);
            } else {
                break;
            }
        }
    }

    private static void updateCategory(List<Product> productList) {
        System.out.println("Please insert the category you want to change");
        productList.stream().flatMap(product -> product.getCategories().stream().peek(category -> {
//            if(category.getName() ==
        }));
    }

    private static void getAllSubCategories(List<Product> productList) {
        productList.stream()
                .flatMap(product -> product.getCategories()
                        .stream()
                        .peek(category -> {
                            System.out.println();
                            System.out.println("***" + category.getName() + "***");
                        })
                        .flatMap(category -> category.getSubCategoryList()
                                .stream()))
                .forEach(subCategory -> {
                    System.out.println(subCategory.getName());
                });

        List<List<Category>> collect = productList.stream().map(product -> product.getCategories().stream().collect(Collectors.toList())).collect(Collectors.toList());

    }

    private static void getAllCategories(List<Product> productList) {
        List<Category> categoryList = productList.stream()
                .flatMap(product -> product.getCategories()
                        .stream())
                .collect(Collectors.toList());
        categoryList.forEach(category -> System.out.println(category.getName()));
    }

    private static void getAllProducts(List<Product> productList) {
        productList.stream().forEach(product -> System.out.println(product.getName()));
    }

    private static void insertProduct(List<Product> productList, Scanner scanner) {
        System.out.print("Product Name");
        String productName = scanner.nextLine();
        System.out.println("Insert Category names, type exit when you are done");
        List<Category> categoryList = new ArrayList<>();
        String categoryName = "";
        while (!(categoryName = scanner.nextLine()).equalsIgnoreCase("exit")) {
            System.out.println("Insert sub categories, type exit when you are done");
            List<SubCategory> subCategoryList = new ArrayList<>();
            String subCategoryName = "";
            while (!(subCategoryName = scanner.nextLine()).equalsIgnoreCase("Exit")) {
                subCategoryList.add(new SubCategory(subCategoryName));
            }
            categoryList.add(new Category(categoryName, subCategoryList));
        }
        productList.add(new Product(productName, categoryList));
    }

    private static void addDummyProducts(List<Product> productList) {
        productList.add(new Product("H&M Shirt",
                Arrays.asList(new Category("Shirt",
                        Arrays.asList(
                                new SubCategory("Flannel"),
                                new SubCategory("Mandarin"),
                                new SubCategory("Checked Shirt"),
                                new SubCategory("Striped"))))));
        productList.add(new Product("H&M Pant",
                Arrays.asList(new Category("Pants",
                        Arrays.asList(
                                new SubCategory("Joggers"),
                                new SubCategory("Waist-Fit"))))));
        productList.add(new Product("Nike Shoes",
                Arrays.asList(new Category("Shoes",
                        Arrays.asList(
                                new SubCategory("Dream Cushion"),
                                new SubCategory("Sports"))))));
        productList.add(new Product("Samsung Refrigerator",
                Arrays.asList(new Category("Refrigerator",
                        Arrays.asList(
                                new SubCategory("Double-Door"),
                                new SubCategory("Max-Cooling"))))));
        productList.add(new Product("RayBan Sunglass",
                Arrays.asList(new Category("Spectacles",
                        Arrays.asList(
                                new SubCategory("Aviator"),
                                new SubCategory("Sunglass"))))));
        productList.add(new Product("Logitech Keyboard",
                Arrays.asList(new Category("Keyboard",
                        Arrays.asList(
                                new SubCategory("Mechanical"),
                                new SubCategory("RGB"))))));

    }
}
