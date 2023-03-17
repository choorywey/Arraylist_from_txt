import java.io.*;
import java.util.ArrayList;

public class Person {
    String name;
    String lastname;

    public Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }



    public static void main(String[] args) {
        ArrayList<Person> personas = new ArrayList<Person>();

        try {
            BufferedReader in = new BufferedReader(new FileReader("nomi.txt"));
            FileWriter outputt = new FileWriter("output.txt");
            String line;
            while ((line = in.readLine()) != null) {
                String[] strings = line.split(",");
//                outputt.write(line);
//                outputt.write("\n");
                String name = strings[0];
                String lastname = strings[1];
                personas.add(new Person(name, lastname));
            }
            for (int i = 0; i < personas.size(); i++) {
                outputt.write(i + "- Name: " + personas.get(i).getName() + " \n");
                outputt.write("Last Name: " + personas.get(i).getLastname() + "\n");

            }

            outputt.flush();                                                    // svuota il buffer e scrive effettivamente i dati nel file
            outputt.close();                                                    // chiude il file

            for (int i = 0; i < personas.size(); i++) {
                System.out.print(personas.get(i).getName() + " ");
                System.out.print(personas.get(i).getLastname() + "\n");

            }
        }

        catch (IOException e) {
            System.out.println("File not found!");
        }

    }
}