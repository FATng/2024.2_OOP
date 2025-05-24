package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.CompactDisc;

import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    public AddCompactDiscToStoreScreen(Store store) {
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

        JLabel lblArtist = new JLabel("Artist:");
        JTextField txtArtist = new JTextField();

        JLabel lblCost = new JLabel("Cost:");
        JTextField txtCost = new JTextField();

        JButton btnAdd = new JButton("Add CD");
        btnAdd.addActionListener(e -> {
            String title = txtTitle.getText();
            String category = txtCategory.getText();
            String artist = txtArtist.getText();
            float cost = Float.parseFloat(txtCost.getText());

            CompactDisc cd = new CompactDisc(title, category, cost, artist);
            store.addMedia(cd);

            JOptionPane.showMessageDialog(this, "CD added to store!");
        });

        panel.add(lblTitle); panel.add(txtTitle);
        panel.add(lblCategory); panel.add(txtCategory);
        panel.add(lblArtist); panel.add(txtArtist);
        panel.add(lblCost); panel.add(txtCost);
        panel.add(new JLabel()); panel.add(btnAdd);

        return panel;
    }
}
