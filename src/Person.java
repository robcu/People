/**
 * Created by robculclasure on 2/13/17.
 */
public class Person {
    String id;
    String firstName;
    String lastName;
    String email;
    String country;
    String iP;

    public Person(String id, String firstName, String lastName, String email, String country, String iP) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.iP = iP;
    }

    void Person() {}

    @Override
    public String toString(){
        return this.firstName;
    }
}
