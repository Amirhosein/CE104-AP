/**
 * A class definition for Run
 *
 * @author Amirhossein
 */
public class Run {
    public static void main(String[] args) {

        /*
         * Creating sample student objects
         */
        Student std1 = new Student("Ehsan", "Edalat", "9031066");
        Student std2 = new Student("Amirparsa", "Salmankhah", "9831034");
        Student std3 = new Student("Amirhossein", "Iravanimanesh", "9931066");

        /*
         * first printing raw student objects.
         * then set a Student's variable manually.
         * printing it again to see methods works correctly or not.
         */
        std1.print();
        std1.setGrade(15);
        std1.print();

        std2.print();
        std2.setGrade(11);
        std2.print();

        std3.print();
        std3.setFirstName("HamidReza");
        std3.print();
    }
}
