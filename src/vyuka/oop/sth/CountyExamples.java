package vyuka.oop.sth;
import vyuka.basics.Country;
import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Collections;

public class CountyExamples {

    public static void printList(ArrayList<Country> countries){
        for(Country c : countries){
            System.out.println(c);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        DataImport di = new DataImport("data/countries.txt");
        ArrayList<Country> countries = new ArrayList<>();
        while(di.hasNext()){
            String line = di.readLine();
            String[] data = line.split(";");

            String name = data[0];
            String continent= data[1];
            long population= Long.parseLong(data[2]);
            double avgAge= Double.parseDouble(data[3]);
            Country zeme = new Country(name,continent,population,avgAge);
            countries.add(zeme);
        }
        di.finishImport();
        printList(countries);
        //tridi prirozene - Comparable
        Collections.sort(countries);
        printList(countries);
        countries.sort(Country.BY_AVG_AGE.reversed());
        printList(countries);
    }
}
