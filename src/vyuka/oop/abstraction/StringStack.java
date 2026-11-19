package vyuka.oop.abstraction;

public class StringStack {
    String[] data;
    int freeIndex;

    public StringStack() {
        data = new String[5];
        freeIndex = 0;
    }

    void push(String toAdd){
        data[freeIndex] = toAdd;
        freeIndex++;
    }

    String pop(){
        String toReturn = data[freeIndex-1];
        freeIndex--;
        return toReturn;
    }

    String peak(){
    return data[freeIndex-1];
    }

    public static void main(String[] args) {
        StringStack test = new StringStack();
        test.push("Test");
        test.push("World");
        test.push("Example");
    }
}
