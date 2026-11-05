package vyuka.oop.interfaces;

import java.util.ArrayList;

public class ComparingBasics {
    static void printList(ArrayList<Item> items){
        for (Item i : items){
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("potato",100, 0.5));
        items.add(new Item("White monster",1000000, 1.65));
        items.add(new Item("Mango Monster",500000, 1.65));
        items.add(new Item("Beef steak",100000, 11.5));
        printList(items);
    }
}

class Item implements Comparable<Item>{
    String name;
    int quantity;
    double price;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Item o) {
        return 0;
    }
}