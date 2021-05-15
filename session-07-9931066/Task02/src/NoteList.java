import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 * The type Note list.
 */
public class NoteList {

    /**
     * Add note.
     */
    public void addNote() {
        String name;
        String title;
        String content;
        String date;
        System.out.println("Enter name of txt:");
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
        System.out.println("Enter title:");
        title = input.nextLine();
        System.out.println("Enter content:");
        content = input.nextLine();
        System.out.println("Enter date:");
        date = input.nextLine();

        String fileAddress = "C:\\Task02\\" + name + ".txt";
        try (FileOutputStream fout = new FileOutputStream(fileAddress); ObjectOutputStream os = new ObjectOutputStream(fout)) {
            Note note = new Note(title, content, date);

            os.writeObject(note);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read a note.
     */
    public void ReadANote() {
        listNotes();
        String name;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the  name of file you want to read:");
        name = input.nextLine();
        String fileAddress = "C:\\Task02\\" + name + ".txt";
        try (FileInputStream fi = new FileInputStream(fileAddress); ObjectInputStream os = new ObjectInputStream(fi)) {

            Note note = (Note) os.readObject();

            System.out.println(note);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Remove note.
     */
    public void removeNote() {
        listNotes();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the  name of file you want to delete:");
        String name = input.nextLine();
        String fileAddress = "C:\\Task02\\" + name + ".txt";
        try {
            File f = new File(fileAddress);
            if (f.delete()) {
                System.out.println(f.getName() + " deleted");
            } else {
                System.out.println("failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Show notes name.
     */
    public void listNotes() {

        File folder = new File("C:\\Task02");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile() && listOfFiles[i].getName().contains(".txt")) {
                System.out.println("File " + listOfFiles[i].getName());
            }
        }
    }
}
