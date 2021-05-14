import java.util.ArrayList;

/**
 * The type Channel.
 */
public class Channel {
    private ArrayList<Follower> followers = new ArrayList<>();

    /**
     * Add follower.
     *
     * @param follower the follower
     */
    public void addFollower(Follower follower){
        followers.add(follower);
    }

    /**
     * Remove follower.
     *
     * @param follower the follower
     */
    public void removeFollower(Follower follower){
        followers.remove(follower);
    }

    /**
     * Notify followers.
     *
     * @param announcementType the announcement type
     * @param announcement     the announcement
     */
    public void notifyFollowers(String announcementType , Announcement announcement){
        for ( Follower thisFollower : followers){
            thisFollower.update(announcementType , announcement);
        }
    }
}
