import ir.huri.jcal.JalaliCalendar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.stream.Collectors;

/**
 * The type Voting.
 */
public class Voting {
    private int type;
    private String question;
    private ArrayList<Person> voters = new ArrayList<>();
    private HashMap<String, HashSet<Vote>> polls = new HashMap<>();

    /**
     * Instantiates a new Voting.
     *
     * @param type     the type
     * @param question the question
     */
    public Voting(int type, String question) {
        this.type = type;
        this.question = question;
    }

    /**
     * Gets question.
     *
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Create poll.
     *
     * @param string the string
     */
    public void createPoll(String string) {
        HashSet<Vote> votes = new HashSet<>();
        polls.put(string, votes);
    }

    /**
     * Vote.
     *
     * @param person  the person
     * @param chooses the chooses
     */
    public void vote(Person person, ArrayList<String> chooses) {
        voters.add(person);

        for (String string : chooses) {
            JalaliCalendar date = new JalaliCalendar();
            Vote vote = new Vote(person, date.toString());
            HashSet<Vote> votes = polls.get(string);
            votes.add(vote);
        }
    }

    /**
     * Get voters.
     */
    public void getVoters(){

        for (Person thisPerson : voters)
            System.out.println(thisPerson.toString());

    }

    /**
     * Print votes.
     */
    public void printVotes(){
        for (String poll : polls.keySet()){
            System.out.println(poll + "| Count: " + polls.get(poll).size() + " | List:");
            for (Vote vote : polls.get(poll))
                System.out.println(vote.getPerson() + " | " + vote.getDate());

        }
    }

    /**
     * Gets polls.
     *
     * @return the polls
     */
    public ArrayList<String> getPolls() {
        ArrayList<String> allPolls = new ArrayList<>();
        for (String key : polls.keySet()) {
            allPolls.add(key);
        }
        return allPolls;
    }

    public int getType() {
        return type;
    }
}
