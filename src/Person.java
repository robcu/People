
public class Person implements Comparable{
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    String country;
    private String iP;

    public Person(String id, String firstName, String lastName, String email, String country, String iP) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.iP = iP;
    }

    @Override
    public String toString(){
        return String.format("%s %s from %s", this.firstName, this.lastName, this.country);
    }

    @Override
    public int compareTo(Object o){
        Person otherPerson = (Person) o;
        if((this.lastName.compareTo(otherPerson.lastName)) == 0){
            return this.firstName.compareTo(otherPerson.firstName);
        }
        else return this.lastName.compareTo(otherPerson.lastName);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getiP() {
        return iP;
    }

    public void setiP(String iP) {
        this.iP = iP;
    }
}
