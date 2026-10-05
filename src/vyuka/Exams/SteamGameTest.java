package vyuka.Exams;

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.List;

// Soubor má 4 sloupečky oddělené znakem "\t" - tabulátor
// name	price	num_reviews_total	short_description
// Některé řádky nemusí obsahovat krátký popisek

// Naimplementujte třídu reprezentující 1 hru/řádek
// Načtěte soubor
// Naimplementujte jednotlivé metody

public class SteamGameTest {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/steam_games.txt");

        List<Game> games = new ArrayList<>();

        // TODO: načíst soubor do arraylistu

        while (di.hasNext()) {
            String line = di.readLine();
            String[] tokens = line.split("\t");
            switch (tokens.length) {
                case 3:
                    games.add(new Game(tokens[0], Double.parseDouble(tokens[1]), Integer.parseInt(tokens[2])));
                    break;
                case 4:
                    games.add(new Game(tokens[0], Double.parseDouble(tokens[1]), Integer.parseInt(tokens[2]), tokens[3]));
                    break;
            }
        }

        System.out.println("Games total loaded: " + games.size());
        System.out.println("Number of free games: " + totalFreeGames(games));
        System.out.println("Average number of reviews per game: " + avgReviewPerGame(games));
        System.out.println("The most expensive game is: " + mostExpansive(games));
        System.out.println("The most reviewed free game is "+ mostReviewFree(games));

        System.out.println(games.get(0));                   // zdarma
        System.out.println(games.get(games.size() / 2));    // placené
        di.finishImport();
    }

    private static Game mostExpansive(List<Game> games) {
        // TODO: vrátit nejdražší hru
        Game mostExpensive = new Game("x", Integer.MIN_VALUE, 54, "x");
        for (Game g : games) {
            if (mostExpensive.getPrice() < g.getPrice()) {
                mostExpensive = g;
            }
        }
        return mostExpensive;
    }

    private static long totalFreeGames(List<Game> games) {
        // TODO: vrátit počet her, které jsou zdarma

        long freeGames = 0;
        for (Game g : games) {
            if (g.getPrice() == 0.0) {
                freeGames++;
            }
        }
        return freeGames;
    }

    private static double avgReviewPerGame(List<Game> games) {
        // TODO: vrátit průměrný počet hodnocení
        int numberOfReviews = 0;
        for (Game g : games) {
            numberOfReviews += g.getTotalReviews();
        }
        return (double) numberOfReviews / games.size();
    }

    private static Game mostReviewFree(List<Game> games) {
        Game g = games.getFirst();
        for (Game hra : games) {
            if (hra.getPrice() == 0 && hra.getTotalReviews() > g.getTotalReviews()) {
                g = hra;
            }
        }
        return g;
    }
}
class Game {
    // TODO: attributy, konstruktor(y), gettery/settery + minimálně toString()
    // TODO: getter pro krátký popisek bude vracet "Not released yet" pokud není popisek uveden hra je "zdarma"

    private String name,shortDesc;
    private double price;
    private int totalReviews;

    public Game(String name,double price, int totalReviews) {
        this.price = price;
        this.totalReviews = totalReviews;
        this.name = name;
        shortDesc = "None";
    }

    public Game(String name, double price, int totalReviews, String shortDesc) {
        this(name, price, totalReviews);
        this.shortDesc = shortDesc;
    }

    @Override
    public String toString() {
        return "Game{" + "name='" + name + ", price=" + price +", totalReviews=" + totalReviews +", shortDesc='" + getShortDesc() +'}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDesc() {
        if (shortDesc.equalsIgnoreCase("none")&&getPrice()==0){
            return "Not released yet";
        } else return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(int totalReviews) {
        this.totalReviews = totalReviews;
    }
}