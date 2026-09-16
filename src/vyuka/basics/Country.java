package vyuka.basics;

public class Country {
    String name;
    String continet;
    long population;
    double avgAge;

    public Country(String name, String continet, long population, double avgAge) {
        this.name = name;
        this.continet = continet;
        this.population = population;
        this.avgAge = avgAge;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", continet='" + continet + '\'' +
                ", population=" + population +
                ", avgAge=" + avgAge +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinet() {
        return continet;
    }

    public void setContinet(String continet) {
        this.continet = continet;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public double getAvgAge() {
        return avgAge;
    }

    public void setAvgAge(double avgAge) {
        this.avgAge = avgAge;
    }
}
