package vyuka.oop.inheritance.hunters;

public class Witcher extends Soldier{

    void slayMonster() {
        System.out.println(name + " is hunting for a monster");
        gold+=250;
    }
    @Override
    public void hunt(){
        System.out.println(name + " is hunting a beast... and hes very good at it");
        gold+= 50;
    }
    public Witcher(String name){
        super(name);
        gold += 50;
    }

    @Override
    public String toString() {
        return "Witcher{" +
                "gold=" + gold +
                ", name='" + name + '\'' +
                '}';
    }
}