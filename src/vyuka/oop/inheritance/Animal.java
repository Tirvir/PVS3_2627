package vyuka.oop.inheritance;

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String name;
    protected double energy;

    public void eat() {
        energy += Math.exp(-energy);
    }

    public void makeNoise() {
        System.out.println("Make some noise");
    }

    public Animal(String name, double energy) {
        this.name = name;
        this.energy = energy;
    }
}

class Dog extends Animal {
    public String breed;

    public Dog(String name, double energy) {
        super(name, energy);
    }

    public Dog(String name, double energy, String breed) {
        this(name,energy);
        this.breed = breed;
    }

    @Override
    public void makeNoise() {
        System.out.println("Haf");
    }
}

class Cat extends Animal {

    public Cat(String name, double energy) {
        super(name, energy);
    }

    @Override
    public void makeNoise() {
        System.out.println("Moew");
    }

}

class Pig extends Animal{
    int mudLevel;

    public Pig(String name, double energy) {
        super(name, energy);
    }

    public Pig(String name, double energy, int mudLevel){
        this(name,energy);
        this.mudLevel=mudLevel;
    }

    @Override
    public void makeNoise() {
        System.out.println("Oink");
    }
    void playInMud(){
        mudLevel=Math.min(100, mudLevel+10);
    }
}

class Main {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/animals.txt");
        di.readLine();
        List<Animal> animals = new ArrayList<>();
        while(di.hasNext()){
            String line = di.readLine();
            String[] tokens = line.trim().split(";");
            switch (tokens[0]){
                case "Dog":
                    animals.add(new Dog(tokens[2],Double.parseDouble(tokens[1]),tokens[3]));
                    break;
                case "Cat":
                    animals.add(new Cat (tokens[2],Double.parseDouble(tokens[1])));
                    break;
                case "Pig":
                    animals.add(new Pig(tokens[2],Double.parseDouble(tokens[1]),Integer.parseInt(tokens[4])));
                    break;
            }
            for (Animal a : animals){
                if (a instanceof Dog) {
                    System.out.println(((Dog) a).breed);
                }
            }
        }
    }
}