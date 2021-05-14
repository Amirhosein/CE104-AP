public class Match {
    private final String date;
    private final String opponentName;


    public Match(String date, String opponentName) {
        this.date = date;
        this.opponentName = opponentName;
    }

    public String getDate() {
        return date;
    }

    public String getOpponentName() {
        return opponentName;
    }
}
