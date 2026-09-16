package oop;
import Basics.Country;
import fileworks.DataImport;

public class CountyExamples {

    public static void main(String[] args) {
        DataImport di = new DataImport("data/countries.txt");

        while(di.hasNext()){
            String line = di.readLine();
            String[] data = line.split(";");

            String name = data[0];
            String continent= data[1];
            long population= Long.parseLong(data[2]);
            double avgAge= Double.parseDouble(data[3]);

            Country zeme = new Country(name,continent,population,avgAge);
        }
        di.finishImport();
    }
}
