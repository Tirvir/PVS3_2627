package oop.inheritance.hunters;

import fileworks.DataExport;

import java.util.ArrayList;
import java.util.Random;

public class HuntingSeason {
    static void randomJob(Hunter hunter){
        Random rng = new Random();
        int random = rng.nextInt(1, 4);
        switch (random){
            case 1:
                hunter.hunt();
                break;
            case 2:
                if (hunter instanceof Soldier){
                    ((Soldier) hunter).killBandit();
                    } else{
                    System.out.println("Not qualified");
                    hunter.gold-=10;
                }
                break;
            case 3:
                if (hunter instanceof Witcher){
                    ((Witcher) hunter).slayMonster();
                    } else {
                    System.out.println("Not qualified");
                    hunter.gold-=10;
                }
                break;
        }
    }

    public static void main(String[] args) {
        ArrayList<Hunter> hunters = new ArrayList<>();
        hunters.add(new Hunter("Theodore Roosevelt"));
        hunters.add(new Soldier("Jack Carter"));
        hunters.add(new Soldier("Ondřej Wislocki"));
        hunters.add(new Witcher("Gerald"));
        hunters.add(new Witcher("Vesemír"));

        for (int i = 0; i<100;i++){
            Random rng = new Random();
            int randomHunter = rng.nextInt(0, hunters.size());
            HuntingSeason.randomJob(hunters.get(randomHunter));

        }
        Hunter richestHunter = hunters.getFirst();
        for(Hunter hunter : hunters){
            if (hunter.gold > richestHunter.gold)
            {
                richestHunter=hunter;
            }
        }
        System.out.println("The richest hunter is " +richestHunter.name + " with "+ richestHunter.gold +" gold.");
    }
}