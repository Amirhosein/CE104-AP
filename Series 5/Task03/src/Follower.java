/**
 * The type Follower.
 */
public class Follower implements Update {
    private String name;

    /**
     * Instantiates a new Follower.
     *
     * @param name the name
     */
    public Follower(String name) {
        this.name = name;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public void update(String announcementType, String title, String content) {
        System.out.println("User: " + name + "\t\t Type: " +
                announcementType + "\n" + content + "\n---End" +
                " of announcement---");
    }
}
