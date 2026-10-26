package oop.inheritance.hunters;

public class Soldier extends Hunter{
    void killBandit(){
     gold+=100;
        System.out.println(name + " is going against bandits");
    }
    public Soldier(String name){
        super(name);
        gold += 40;
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "name='" + name + '\'' +
                ", gold=" + gold +
                '}';
    }
}
