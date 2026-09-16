package vyuka.oop;

import fileworks.DataImport;

import java.util.ArrayList;

public class Track {
    String name;
    int year;
    double rating;
    int duration;

    public Track(String name, int year, double rating, int duration) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if (rating < 0 || rating > 10) System.out.println("Neplatné hodnocení");
        else this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
       if(duration<0) System.out.println("Neplatná délka");
       else this.duration = duration;
    }

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", duration=" + duration +
                '}';
    }

    static void main() {
        DataImport di = new DataImport("data/tracks.txt");
        ArrayList<Track> tokens = new ArrayList<>();

        while(di.hasNext()){
            String line = di.readLine();
            String[] segments = line.split(";");
            Track song = new Track(segments[0],
                    Integer.parseInt(segments[1]),
                    Double.parseDouble(segments[2]),
                    Integer.parseInt(segments[3]));
            tokens.add(song);
        }
        System.out.println(tokens);
        di.finishImport();
    }
}
