import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Voting {
    private int type;
    private String question;
    private ArrayList<Person> voters = new ArrayList<>();
    private HashMap<String, HashSet<Vote>> polls = new HashMap<>();

    public Voting(int type, String question) {
        this.type = type;
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void createPoll(String string) {
        HashSet<Vote> votes = new HashSet<>();
        polls.put(string, votes);
    }

    public void vote (Person person, ArrayList<String> chooses){
        voters.add(person);
        Vote vote = new Vote(person,)
    }
}
