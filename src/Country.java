import java.util.ArrayList;

/**
 * Created by robculclasure on 2/13/17.
 */
public class Country {

    String country;
    ArrayList<Person> population = new ArrayList<>();

    public Country(ArrayList<Person> population) {
        this.population = population;
    }

    public Country() {
    }
}
