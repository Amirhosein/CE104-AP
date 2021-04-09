import ir.huri.jcal.JalaliCalendar;

import java.util.ArrayList;


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
        VotingSystem votingSystem = new VotingSystem();
        ArrayList<String> choices = new ArrayList<>();
        choices.add("Abbas");
        choices.add("Akbar");
        choices.add("Asghar");
        votingSystem.createVoting("test1", 1, choices);
        votingSystem.createVoting("test2", 0, choices);
        votingSystem.getVotingList();
        System.out.println("\n/////////////////////////////\n");
        votingSystem.getVoting(0);
        System.out.println("\n/////////////////////////////");
        Person person = new Person("Amirhossein", "Iravanimanesh");
        choices.clear();
        choices.add("Abbas");
        choices.add("Asghar");
        votingSystem.vote(0, person, choices);
        votingSystem.getResult(0);
        System.out.println("\n/////////////////////////////");
        votingSystem.vote(1, person, choices);
        System.out.println("\n/////////////////////////////");
        votingSystem.vote(1, person);
        votingSystem.getResult(1);
        System.out.println("\n/////////////////////////////");
        votingSystem.vote(0,person);
    }
}
