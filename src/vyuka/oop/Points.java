package vyuka.oop;

import fileworks.DataImport;

import java.util.ArrayList;

public class Points {

    public static void main(String[] args) {
        ArrayList<Point> list = new ArrayList<>();
        DataImport di = new DataImport("data/points.txt");
        while(di.hasNext()){
         String line = di.readLine();
         String[] tokens = line.split(",");
         switch (tokens.length){
             case 4:
                 list.add(new Point(tokens[0],Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3])));
                 break;
             case 3:
                 list.add(new Point(tokens[0],Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2])));
                 break;
             case 2:
                 list.add(new Point(Double.parseDouble(tokens[0]),Double.parseDouble(tokens[1])));
                 break;

         }
        }
        di.finishImport();

        for (Point point: list){
            System.out.println(point);
        }
    }
}
class Point {
    private String name;
    private double x, y, z;
    private final double Z_DEFAULT = 0;
    private static int pointsCreated = 1;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        z = Z_DEFAULT;
        name = "Point" + pointsCreated;
        pointsCreated++;

    }

    public Point(String name, double x, double y) {
        this(x, y);
        this.name = name;
        z = Z_DEFAULT;
    }

    public Point(String name, double x, double y, double z) {
        this(name, x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "( name = " + name + " x: " + x + " y: " + y + " z: " + z + " )";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public static int getPointsCreated() {
        return pointsCreated;
    }
}