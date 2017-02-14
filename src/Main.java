import jodd.json.JsonSerializer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    static HashMap<String, ArrayList<Person>> directory = new HashMap<>();

    static void scanIntoHashMap(String filename) throws FileNotFoundException {

        File f = new File(filename);
        Scanner fileScanner = new Scanner(f);

        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\,");

            Person person = new Person(columns[0], columns[1], columns[2], columns[3], columns[4], columns[5]);

            if (directory.containsKey(person.country)) {
                ArrayList<Person> tempArray = directory.get(person.country);
                tempArray.add(person);
                directory.put(person.country, tempArray);
            }
            if (!directory.containsKey(person.country)) {
                ArrayList<Person> tempArray2 = new ArrayList<>();
                tempArray2.add(person);
                directory.put(person.country, tempArray2);
            }
        }
        fileScanner.close();
    }

    static void sortHashMap() {

        for (Map.Entry<String, ArrayList<Person>> entry : directory.entrySet()) {
            Collections.sort(entry.getValue());
        }
    }

    static void printHashMap() {

        for (Map.Entry<String, ArrayList<Person>> entry : directory.entrySet()) {
            System.out.println(entry.getKey());
            for (Person person : entry.getValue()) {
                System.out.println(person);
            }
        }
    }

    static void writeJSONFile() throws IOException {

        File f = new File("people.json");
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer
                .include("*")
                .serialize(directory);
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
    }

    public static void main(String[] args) throws IOException {

        scanIntoHashMap("people.csv");
        sortHashMap();
        printHashMap();
        writeJSONFile();
    }
}




