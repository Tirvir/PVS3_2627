package vyuka.basics;

import fileworks.DataExport;
import fileworks.DataImport;

public class ParseFile {
    static void main() {
        DataImport di = new DataImport("data/countries.txt");
        DataExport de = new DataExport("output.txt");
        Country minPopulace = new Country("x","x",Long.MAX_VALUE,21);
        Country maxAvgAge = new Country("x","x", 12, Double.MIN_VALUE);
        while(di.hasNext()){
            String radek = di.readLine();
            String[] tokens = radek.split(";");
            Country zeme = new Country(tokens[0],
                    tokens[1],
                    Long.parseLong(tokens[2]),
                    Double.parseDouble(tokens[3]));

            if(zeme.continet.equalsIgnoreCase("europe")) de.writeLine(zeme.toString());
            if (minPopulace.population>zeme.population) minPopulace =zeme;
            if (maxAvgAge.avgAge< zeme.avgAge) maxAvgAge = zeme;

        }
        System.out.println(minPopulace);
        System.out.println(maxAvgAge);
        de.finishExport();
        di.finishImport();
    }
}
