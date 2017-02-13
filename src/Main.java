import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static HashMap<String, ArrayList<Person>> hashmap = new HashMap<>();
    //static ArrayList<Person> list = new ArrayList<>();

    static void scanIntoHashMap(String filename) throws FileNotFoundException {
        File f = new File(filename);
        Scanner fileScanner = new Scanner(f);

        while(fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\,");

            Person person = new Person(columns[0], columns[1], columns[2], columns[3], columns[4], columns[5]);

            if(hashmap.containsKey(person.country)){
                ArrayList<Person> temp = hashmap.get(person.country);
                temp.add(person);
                hashmap.put(person.country, temp);
            }
            if(! hashmap.containsKey(person.country)){
                ArrayList<Person> temp2 = new ArrayList<>();
                temp2.add(person);
                hashmap.put(person.country, temp2);
            }
        }
        fileScanner.close();
    }

    public static void main(String[] args) throws FileNotFoundException {

        scanIntoHashMap("people.csv");




    }
}
