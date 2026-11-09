package vyuka.oop.interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ComparingBasics {
    static void printList(ArrayList<Item> items){
        for (Item i : items){
            System.out.println(i);

        }
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Potato",100, 0.5));
        items.add(new Item("White monster",1000000, 1.65));
        items.add(new Item("Mango Monster",500000, 1.65));
        items.add(new Item("Beef steak",100000, 11.5));
        Collections.shuffle(items);
        printList(items);
        items.sort(Item.BY_TOTAL_PRICE.reversed());
        //lze Colletions.sort()
        printList(items);

    }
}

class Item implements Comparable<Item>{
    String name;
    int quantity;
    double price;

    public static Comparator<Item> BY_PRICE = new Comparator<Item>(){
        @Override
        public int compare(Item o1, Item o2){
            return Double.compare(o1.price, o2.price);
        }
    };

    public static final Comparator<Item> BY_TOTAL_PRICE = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            double o1Total = o1.price*o1.quantity;
            double o2Total = o2.price*o2.quantity;
            return Double.compare(o1Total,o2Total);
        }
    } ;



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