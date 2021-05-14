import java.util.ArrayList;

public class Channel {
    private ArrayList<Follower> followers = new ArrayList<>();

    public void addFollower(Follower follower){
        followers.add(follower);
    }

    public void removeFollower(Follower follower){
        followers.remove(follower);
    }

    public void notifyFollowers(String announcementType , Announcement announcement){
        for ( Follower thisFollower : followers){
            thisFollower.update(announcementType , announcement);
        }
    }
}
