import java.util.Scanner;

/**
 * The type Main.
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        NoteList noteList = new NoteList();
        while (true) {
            System.out.println("1) Add a note\n2) Read a note\n3) Delete a note\n4) Exit");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 1) {
                noteList.addNote();
            } else if (choice == 2) {
                noteList.ReadANote();
            } else if (choice == 3) {
                noteList.removeNote();
            } else break;
        }
    }
}
