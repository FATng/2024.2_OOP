package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks;

    public String getArtist() {
        return artist;
    }
    public ArrayList<Track> getTrack() {
        return tracks;
    }

    public CompactDisc() {
        // TODO Auto-generated constructor stub
        super();
    }

    public CompactDisc(String artist) {
        super();
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    public CompactDisc(String title, String category, float cost, String artist, ArrayList<Track> tracks) {
        super(title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track added successfully.");
        } else {
            System.out.println("Track already exists in the CD.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed successfully.");
        } else {
            System.out.println("Track does not exist in the CD.");
        }
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() throws PlayerException {
        int size = tracks.size();
        JPanel layout = new JPanel(new GridLayout(size, 1));
        if (this.getLength() < 0) {
            throw new PlayerException("ERROR : CD length is non-positive");
        }
        for (Track track : tracks) {
            if (track.getLength() > 0) {
                JLabel text = new JLabel("CD - Title : " + track.getTitle() + " Length : " + track.getLength());

                layout.add(text);
            } else
                throw new PlayerException("ERROR : Disc length is non-positive");
        }
        JDialog dialog = new JDialog();
        dialog.setSize(300, 200);
        dialog.add(layout);
        dialog.setTitle("Play CD");
        dialog.setVisible(true);
    }

}
