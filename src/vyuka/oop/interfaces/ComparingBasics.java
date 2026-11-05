package vyuka.oop.interfaces;

import java.util.ArrayList;
import java.util.Collections;

public class ComparingBasics {
    static void printList(ArrayList<Item> items){
        for (Item i : items){
            System.out.println(i);

        }
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("potato",100, 0.5));
        items.add(new Item("White monster",1000000, 1.65));
        items.add(new Item("Mango Monster",500000, 1.65));
        items.add(new Item("Beef steak",100000, 11.5));
        printList(items);
        Collections.sort(items);
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
        return this.name.compareTo(o.name);
    }

    //@Override
    //public int compareTo(Item o) {
    //    return this.quantity - o.quantity;
    //}


   //@Override
   //public int compareTo(Item o) {
   //    return Double.compare(this.price,o.price);
   //}
}