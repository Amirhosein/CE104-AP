/**
 * The type Match.
 */
public class Match {
    private final String date;
    private final String opponentName;


    /**
     * Instantiates a new Match.
     *
     * @param date         the date
     * @param opponentName the opponent name
     */
    public Match(String date, String opponentName) {
        this.date = date;
        this.opponentName = opponentName;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Gets opponent name.
     *
     * @return the opponent name
     */
    public String getOpponentName() {
        return opponentName;
    }
}
