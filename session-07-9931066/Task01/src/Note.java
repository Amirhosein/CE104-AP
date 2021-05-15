import java.io.*;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * The type Note.
 */
public class Note {


    /**
     * Add note.
     */
    public void addNote() {
        String name;
        System.out.println("\nEnter name of txt:");
        Scanner input = new Scanner(System.in);
        name = input.nextLine();

        System.out.println("Enter content:");
        String text = input.nextLine();
        String fileAddress = "C:\\Task01\\" + name + ".txt";

/*
This section is about FileOutputStream Usage:
 */
        try {
            FileOutputStream fout = new FileOutputStream(fileAddress);
            byte binaryArray[] = text.getBytes();//converting string into byte array
            fout.write(binaryArray);
            fout.close();
            System.out.println("Note has been successfully created.");
        } catch (Exception e) {
            System.out.println(e);
        }

/*
This Section is for BufferedWriter
 */
//        try {
//            FileWriter writer = new FileWriter(fileAddress);
//            BufferedWriter buffer = new BufferedWriter(writer);
//            buffer.write(text);
//            buffer.close();
//            System.out.println("\"Note has been successfully created.\"");
//        } catch (Exception e) {
//            System.out.println(e);
//        }


    }


    /**
     * Remove note.
     */
    public void removeNote() {
        listofNotes();
        String name;
        String fileAddress;
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter name of file to delete:");
        name = input.nextLine();
        fileAddress = "C:\\Task01\\" + name + ".txt";
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
     * Read a note.
     */
    public void ReadANote() {
        listofNotes();
        String name;
        String fileAddress;
        Scanner input = new Scanner(System.in);
        System.out.println("enter the  name of file you want to read:");
        name = input.nextLine();
        fileAddress = "C:\\Task01\\" + name + ".txt";

/*
This section is about FileOutputStream Usage:
 */
        try {
            FileInputStream fin = new FileInputStream(fileAddress);
            int i = 0;
            while ((i = fin.read()) != -1) {
                System.out.print((char) i);
            }
            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        }

/*
This Section is for BufferedWriter
 */
//        try {
//            FileReader fr = new FileReader(fileAddress);
//            BufferedReader br = new BufferedReader(fr);
//
//            int i;
//            while ((i = br.read()) != -1) {
//                System.out.print((char) i);
//            }
//            br.close();
//            fr.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }


    /**
     * Show notes name.
     */
    public void listofNotes() {

        File folder = new File("C:\\Task01");
        File[] listOfFiles = folder.listFiles();

        for (
                int i = 0;
                i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile() && listOfFiles[i].getName().contains(".txt")) {
                System.out.println("\nFile " + listOfFiles[i].getName());
            }
        }
    }
}

