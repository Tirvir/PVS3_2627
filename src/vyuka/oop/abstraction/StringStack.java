package vyuka.oop.abstraction;

public class StringStack implements MyStack {
    String[] data;
    int freeIndex;
    private static final int BASE_SIZE = 16;

    public StringStack() {
        data = new String[BASE_SIZE];
        freeIndex = 0;
    }
  @Override
  public void push(String toAdd){
        if (freeIndex==data.length){
            expandArray();

        }
        data[freeIndex] = toAdd;
        freeIndex++;
    }
    @Override
    public String pop(){
        if(freeIndex > 0) {
            String toReturn = data[freeIndex - 1];
            freeIndex--;
            return toReturn;
        }
        else return null;
    }
    @Override
   public String peek(){
        if (isEmpty()){
            return null;
        }
        return data[freeIndex-1];
    }

    @Override
    public boolean isEmpty() {
        return (freeIndex == 0);
    }

    private void expandArray(){
        String[] larger_data = new String[(int)(data.length*2)];
        for (int i = 0; i < data.length; i++) {
            larger_data[i] = data[i];
        }
        data = larger_data;
    }
    public static void main(String[] args) {
        StringStack test = new StringStack();
        test.push("Test");
        test.push("World");
        test.push("Example");
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
    }
}
