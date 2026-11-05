package vyuka.basics;

public class ParseSimple {
    public static void main(String[] args) {
        String data = "This is a number:3";
        String[] tokens = data.split(":");
        int parsedNumber = Integer.parseInt(tokens[1]);
        System.out.println(parsedNumber);
    }
}
