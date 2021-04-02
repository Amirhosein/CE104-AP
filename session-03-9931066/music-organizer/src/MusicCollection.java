package src;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael K�lling
 * @version 2011.07.31
 */
public class MusicCollection
{
    // An ArrayList for storing the file names of music files.��
     ArrayList<Track> tracks = new ArrayList<>();
    private ArrayList<Track> favoriteTracks = new ArrayList<>();
    // A player for the music files.
    private MusicPlayer player = new MusicPlayer();
        
    /**
     * Create a MusicCollection
     */
    public MusicCollection()
    {

    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename, String singer, int releaseYear)
    {
        Track track = new Track(filename, singer, releaseYear);
        this.tracks.add(track);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return this.tracks.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if (validIndex(index)) {
            Track track = this.tracks.get(index);
            System.out.println(track.filename);
            System.out.print(track.singer);
            System.out.println(" (" + track.releaseYear + ")");
        }
        else {
            System.out.println("out of index");
        }
    }
    
    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {
        int index = 1;
        for (Track track : this.tracks) {
            System.out.println("-------------");
            System.out.print(index + ") ");
            System.out.print(track.filename);
            System.out.print(" - " + track.singer);
            System.out.println(" (" + track.releaseYear + ")");
            index++;
        }
        System.out.println("-------------");
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        index -= 1;
        if (validIndex(index)) {
            this.tracks.remove(index);
        }
        else {
            System.out.println("out of index");
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        index -= 1;
        this.player.startPlaying(this.tracks.get(index));
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        this.player.stop();
    }

    public void addTrackToFavorite(int index) {
        index -= 1;
        if (validIndex(index)) {
            Track track = this.tracks.get(index);
            boolean exists = false;
            for (Track thisTrack : this.favoriteTracks) {
                if (thisTrack == track) {
                    exists = true;
                    break;
                }
            }

            if (exists) {
                System.out.println("track is already in favorite list");
                return;
            }

            this.favoriteTracks.add(track);
        } else {
            System.out.println("out of index");
        }
    }

    public void removeTrackFromFavorite(int index) {
        index -= 1;
        if (validIndex(index)) {
            Track track = this.favoriteTracks.get(index);
            boolean exists = false;
            for (Track thisTrack : this.favoriteTracks) {
                if (thisTrack == track) {
                    exists = true;
                    break;
                }
            }

            Iterator<Track> it = this.favoriteTracks.iterator();

            while (it.hasNext()) {
                Track thisTrack = it.next();
                if (thisTrack == track) {
                    it.remove();
                    break;
                }
            }
        } else {
            System.out.println("out of index");
        }
    }

    public void allFavoriteTracks()
    {
        for (Track track : this.favoriteTracks) {
            System.out.println("-------------");
            System.out.print((this.tracks.lastIndexOf(track)+1) + ") ");
            System.out.print(track.filename);
            System.out.print(" - " + track.singer);
            System.out.println(" (" + track.releaseYear + ")");
        }
        System.out.println("-------------");
    }

    public void search(String query) {
        for (Track track : this.tracks) {
            if (track.filename.contains(query) || track.singer.contains(query)) {
                System.out.println("-------------");
                System.out.print(this.tracks.lastIndexOf(track) + ") ");
                System.out.print(track.filename);
                System.out.print(" - " + track.singer);
                System.out.println(" (" + track.releaseYear + ")");
            }
        }
        System.out.println("-------------");
    }


    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        return ((index >= 0) && (index < this.tracks.size()));
    }
}