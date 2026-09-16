package Basics;

import fileworks.DataExport;
import fileworks.DataImport;

import java.io.IOException;

public class ParseFile {
    public static void main(String[] args) throws IOException {
        String path = "data/countries.txt";
        DataImport di = new DataImport(path);
    //di.printFile(); vypíše celý soubor
        //di.readLine(); vypíše řádek
        //di.hasNext(); kontroluje, jestli je na konci souboru, pokud je true tak resetujeme na začátek pomocí di.reinitializeRead()

        String radek = di.readLine();
        String[] data = radek.split(";");
        String name = data[0];
        String continent= data[1];
        long population= Long.parseLong(data[2]);
        double avgAge= Double.parseDouble(data[3]);

        System.out.println(name);
        System.out.println(continent);
        System.out.println(population);
        System.out.println(avgAge);

        di.reinitializeRead();
        while(di.hasNext()){
            radek = di.readLine();
            data = radek.split(";");
            name = data[0];
            continent= data[1];
            population = Long.parseLong(data[2]);
            avgAge = Double.parseDouble(data[3]);

            System.out.println(name);
            System.out.println(continent);
            System.out.println(population);
            System.out.println(avgAge);
        }

        di.reinitializeRead();
        DataExport de = new DataExport("output.txt");
        while(di.hasNext()){
            radek = di.readLine();
            data = radek.split(";");
            Country oneCountry = new Country(data[0],data[1],Long.parseLong(data[2]),Double.parseDouble(data[3]));
            System.out.println(oneCountry);
            if (oneCountry.continent.equalsIgnoreCase("europe")){
              de.writeLine(oneCountry.toString());
            }
        }
        de.finishExport();
        di.finishImport();

    }
    static boolean isInAfrica(){

        return false;
    }
}