package oop;

import fileworks.DataImport;

import java.util.ArrayList;

class Product{
    private String name;
    private String category;
    private int inStock;
    private double price;

    public Product(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Product(String name, String category, int inStock) {
        this(name,category);
        this.inStock = inStock;
    }

    public Product(String name, String category, int inStock, double price) {
        this(name, category, inStock);
        this.price = price;
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

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        if (inStock>0){
            this.inStock = inStock;
        } else {
            this.inStock = 0;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price>0){
            this.price = price;
        } else {
            this.price = 0;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", inStock=" + inStock +
                ", price=" + price +
                '}';
    }
}

public class Products {
    public static void main(String[] args) {
        ArrayList<Product> list = new ArrayList<>();
        int allInStock = 0;
        DataImport di = new DataImport("data/products.txt");
        while(di.hasNext()){
            String line = di.readLine();
            String[] tokens = line.split(";");
            if (tokens.length==2){
                Product product = new Product(tokens[0],
                        tokens[1]);
                list.add(product);
            }
            if (tokens.length==3){
                Product product = new Product(tokens[0],
                        tokens[1],
                        Integer.parseInt(tokens[2]));
                list.add(product);
            }
            if (tokens.length==4){
                Product product = new Product(tokens[0],
                        tokens[1],
                        Integer.parseInt(tokens[2]),
                        Double.parseDouble(tokens[3]));
                list.add(product);
            }
        }
        for(Product p : list){
            if (p.getInStock()>0){
                allInStock+=p.getInStock();
            }
        }
        System.out.println(allInStock);
        double allPrice = 0;
        int numberOfProducts = list.size();
        for(Product p : list){
            if (p.getPrice()>0){
                allPrice+= p.getPrice();
            }
        }
        System.out.println("Average price is "+(allPrice/numberOfProducts));
        di.finishImport();
    }
}