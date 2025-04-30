package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected JPanel createCenter() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel lblTitle = new JLabel("Title:");
        JTextField txtTitle = new JTextField();

        JLabel lblCategory = new JLabel("Category:");
        JTextField txtCategory = new JTextField();

        JLabel lblDirector = new JLabel("Director:");
        JTextField txtDirector = new JTextField();

        JLabel lblLength = new JLabel("Length:");
        JTextField txtLength = new JTextField();

        JLabel lblCost = new JLabel("Cost:");
        JTextField txtCost = new JTextField();

        JButton btnAdd = new JButton("Add DVD");
        btnAdd.addActionListener(e -> {
            String title = txtTitle.getText();
            String category = txtCategory.getText();
            String director = txtDirector.getText();
            int length = Integer.parseInt(txtLength.getText());
            float cost = Float.parseFloat(txtCost.getText());

            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
            store.addMedia(dvd);

            JOptionPane.showMessageDialog(this, "DVD added to store!");
        });

        panel.add(lblTitle); panel.add(txtTitle);
        panel.add(lblCategory); panel.add(txtCategory);
        panel.add(lblDirector); panel.add(txtDirector);
        panel.add(lblLength); panel.add(txtLength);
        panel.add(lblCost); panel.add(txtCost);
        panel.add(new JLabel()); panel.add(btnAdd);

        return panel;
    }
}
