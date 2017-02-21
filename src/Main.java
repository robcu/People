import jodd.json.JsonSerializer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        scanIntoDirectory("people.csv");
        sortDirectory();
        printDirectory();
        writeJSONFile("people.json");
    }

    static HashMap<String, ArrayList<Person>> directory = new HashMap<>();

    static void scanIntoDirectory(String filename) throws FileNotFoundException {

        File f = new File(filename);
        Scanner fileScanner = new Scanner(f);

        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\,");

            Person person = new Person(columns[0], columns[1], columns[2], columns[3], columns[4], columns[5]);

//            ArrayList<Person> tempArray;
//
//            if (directory.containsKey(person.country)) {
//                tempArray = directory.get(person.country);
//            }
//            else {
//                tempArray = new ArrayList<>();
//                directory.put(person.country, tempArray);
//            }
//            tempArray.add(person);

            directory.putIfAbsent(person.country, new ArrayList<Person>());  // Replaces above commented code
            directory.get(person.country).add(person);

        }
        fileScanner.close();
    }

    static void sortDirectory() {

        for (Map.Entry<String, ArrayList<Person>> entry : directory.entrySet()) {
            Collections.sort(entry.getValue());
        }
    }

    static void printDirectory() {

        for (Map.Entry<String, ArrayList<Person>> entry : directory.entrySet()) {
            System.out.println(entry.getKey());
            for (Person person : entry.getValue()) {
                System.out.println(person);
            }
        }
    }

    static void writeJSONFile(String filename) throws IOException {

        File f = new File(filename);
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer
                .include("*")
                .serialize(directory);
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
    }
}