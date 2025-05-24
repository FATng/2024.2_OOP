package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

import javax.swing.*;

public class DigitalVideoDisc extends Disc implements Playable{

    public DigitalVideoDisc(String director, int length) {
        super(director, length);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc() {
        super();
    }


    public void play() throws PlayerException {
        // TODO Auto-generated method stub
        if (this.getLength() > 0) {
            JDialog dialog = new JDialog();
            dialog.setSize(300, 200);

            JLabel text = new JLabel("DVD - Title : " + this.getTitle() + " Length : " + this.getLength());
            dialog.add(text);
            dialog.setTitle("Play DVD");
            dialog.setVisible(true);
        } else
            throw new PlayerException("ERROR : DVD length is non-positive");
    }
}