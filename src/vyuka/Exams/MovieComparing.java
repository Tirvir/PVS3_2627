package vyuka.Exams;

//Doplnte atributy pro Film
//
//Jsou jimi:
//Název filmu,
//Rok vydani,
//rating (4.5, 7.8... vyssi = lepsi)
//doba trvani ve vterinach
//
//Vypis do konzole:
//Vypsano serazene dle data vydani od nejstarsich
//Vypsano serazeno dle jmena
//TOP 10 filmu dle ratingu

import fileworks.DataImport;
import java.util.ArrayList;
import java.util.Comparator;

//Link na odevzdani GIST:
//https://forms.cloud.microsoft/Pages/ResponsePage.aspx?id=f_BDFfkwekCetYp67EGP_1pSNPXTVBFPg7PGychWGEdUM040WFhKVFpJQ1RBUVZYVUU2MUYxS0hETCQlQCNjPTEu
public class MovieComparing {
    static ArrayList<Movie> loadData(String path){
        DataImport di = new DataImport(path);
        ArrayList<Movie> movies = new ArrayList<>();
        String line;
        String[] params;
        while(di.hasNext()){
            line = di.readLine();
            params = line.split(";");
            movies.add(new Movie(params[0]
                    ,Integer.parseInt(params[1])
                    ,Double.parseDouble(params[2])
                    ,Integer.parseInt(params[3])));
        }
        di.finishImport();
        return movies;

    }
    static void printList(ArrayList<Movie> m){
        for (Movie movie :m){
            System.out.println(movie);
        }
        System.out.println();
    }
    static void printListAmount(ArrayList<Movie> m, int amount){
        for (int i = 0; i<amount ; i++){
            System.out.println(m.get(i));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayList<Movie> movies = loadData("data/Movies.txt");
        movies.sort(Movie.BY_YEAR);
        printList(movies);
        movies.sort(Movie.BY_NAME);
        printList(movies);
        movies.sort(Movie.BY_RATING.reversed());
        printListAmount(movies,10);
    }
}
class Movie implements Comparable<Movie>{
    String name;
    int year, duration;
    double rating;

    public static final Comparator<Movie> BY_YEAR = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return Integer.compare(o1.year,o2.year);
        }
    };

    public static final Comparator<Movie> BY_NAME = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.name.compareTo(o2.name);
        }
    };
    public static final Comparator<Movie> BY_RATING = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return Double.compare(o1.rating,o2.rating);
        }
    };

    public Movie(String name, int year,double rating, int duration ) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.duration = duration;

    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", duration=" + duration +
                ", rating=" + rating +
                '}';
    }

    @Override
    public int compareTo(Movie o) {
        return this.name.compareTo(o.name);
    }
}