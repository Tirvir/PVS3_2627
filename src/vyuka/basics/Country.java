package vyuka.basics;

import java.util.Comparator;

public class Country implements Comparable<Country>{
   public String name, continent;
   public long population;
   public double avgAge;

    public Country(String name, String continent, long population, double avgAge) {
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.avgAge = avgAge;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", population=" + population +
                ", avgAge=" + avgAge +
                '}';
    }
    public static final Comparator<Country> BY_AVG_AGE = new Comparator<Country>() {
        @Override
        public int compare(Country o1, Country o2) {
            return Double.compare(o1.avgAge,o2.avgAge);
        }
    } ;
    @Override
    public int compareTo(Country o) {
        if (this.name.length()>o.name.length()) return 1;
        else if (this.name.length()<o.name.length()) return -1;
        return 0;
    }
}
