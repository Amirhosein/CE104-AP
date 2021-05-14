/**
 * The type Follower.
 */
public class Follower {
    private final String name;

    /**
     * Instantiates a new Follower.
     *
     * @param name the name
     */
    public Follower(String name) {
        this.name = name;
    }


    /**
     * Update.
     *
     * @param announcementType the announcement type
     * @param announcement     the announcement
     */
    public void update(String announcementType, Announcement announcement) {
        System.out.println("User: " + name + "\t\t Type: " +
                announcementType + "\nTitle: " + announcement.getTitle() + '\n' + announcement.getContent() + "\n---End" +
                " of announcement---\n");
    }
}
