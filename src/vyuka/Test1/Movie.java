package vyuka.Test1;

import fileworks.DataExport;
import fileworks.DataImport;

public class Movie {
    String name;
    int year;
    String type;
    double rating;

    public Movie(String name, int year, String type, double rating) {
        this.name = name;
        this.year = year;
        this.type = type;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", type='" + type + '\'' +
                ", rating=" + rating +
                '}';
    }

    public static void main(String[] args) {
        DataImport di = new DataImport("data/movieList.txt");
        DataExport de = new DataExport("horrors.txt");
        Movie bestRated = new Movie("x",0,"x",Double.MIN_VALUE);

        int postMilenium = 0;
        while(di.hasNext()){
            String line = di.readLine();
            String[] tokens = line.split(";");
            Movie film = new Movie(tokens[0],
                    Integer.parseInt(tokens[1]),
                    tokens[2],
                    Double.parseDouble(tokens[3]));

            if (bestRated.rating< film.rating){
                bestRated = film;
            }

            if (film.year>2000){
                postMilenium++;
            }

            if (film.type.equalsIgnoreCase("horror")){
                de.writeLine(film.toString());
            }
        }
        System.out.println("The best rated movie is " + bestRated);
        System.out.println("The number of movies post 2000 is " + postMilenium);
        de.finishExport();
        di.finishImport();
    }
}