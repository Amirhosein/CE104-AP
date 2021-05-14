/**
 * The type Announcement.
 */
public class Announcement {
    private final String title;
    private final String content;

    /**
     * Instantiates a new Announcement.
     *
     * @param title   the title
     * @param content the content
     */
    public Announcement(String title, String content) {
        this.title = title;
        this.content = content;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }
}
