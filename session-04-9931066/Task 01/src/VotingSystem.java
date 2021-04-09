import java.util.ArrayList;

/**
 * The type Voting system.
 */
public class VotingSystem {
    private ArrayList<Voting> votingList = new ArrayList<>();

    /**
     * Instantiates a new Voting system.
     */
    public VotingSystem() {
    }

    /**
     * Create voting.
     *
     * @param string  the string
     * @param mode    the mode
     * @param choices the choices
     */
    public void createVoting(String string, int mode, ArrayList<String> choices) {
        Voting voting = new Voting(mode, string);
        for (String choice : choices) {
            voting.createPoll(choice);
        }
        votingList.add(voting);
    }

    /**
     * Gets voting list.
     */
    public void getVotingList() {
        int index = 0;
        for (Voting voting : votingList){
            System.out.print(index + ".");
            System.out.println(voting.getQuestion());
            index++;
        }
    }

    /**
     * Gets voting.
     *
     * @param index the index
     */
    public void getVoting(int index) {
        Voting voting = votingList.get(index);
        System.out.println(voting.getQuestion());
        ArrayList<String> polls = voting.getPolls();
        int inc = 1;
        for (String poll : polls) {
            System.out.println(inc + "." + poll);
            inc++;
        }
    }

    /**
     * Vote.
     *
     * @param index   the index
     * @param person  the person
     * @param choices the choices
     */
    public void vote(int index, Person person, ArrayList<String> choices) {
        Voting voting = votingList.get(index);
        if (voting.getType() == 0 && choices.size() > 1){
            System.out.println("You must only choose one poll.");
            return;
        }
        voting.vote(person, choices);
    }

    /**
     * Gets result.
     *
     * @param index the index
     */
    public void getResult(int index) {
        Voting voting = votingList.get(index);
        voting.printVotes();
    }
}
