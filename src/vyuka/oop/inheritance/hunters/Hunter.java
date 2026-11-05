package vyuka.oop.inheritance.hunters;

public class Hunter {
    String name;
    int gold = 10;
    public void hunt(){
        gold += 10;
        System.out.println(name + " is hunting a beast.");
    }

    public Hunter(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hunter{" +
                "name='" + name + '\'' +
                ", gold=" + gold +
                '}';
    }
}
