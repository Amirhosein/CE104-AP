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
        Club barcelona = new Club("FC Barcelona");
        Club persepolis = new Club("Persepolis");

        Follower follower1 = new Follower("Follower 1");
        Follower follower2 = new Follower("Follower 2");
        Follower follower3 = new Follower("Follower 3");
        Follower follower4 = new Follower("Follower 4");

        barcelona.subscribe(follower1, "Match News");
        barcelona.subscribe(follower2, "Club News");
        persepolis.subscribe(follower3, "Player News");
        persepolis.subscribe(follower4, "Match News");

        Player player = new Player(28, "Abbas Bouazar", "4052060912");
        persepolis.addPlayer(player);

        Match match1 = new Match("1/1/2000","Esteghlal");
        Match match2 = new Match("1/2/2000","Atletico Madrid");

        persepolis.addMatch(match1);
        barcelona.addMatch(match2);

        barcelona.publishClubNews();

    }
}
