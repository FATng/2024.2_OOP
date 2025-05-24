package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Book;

import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store) {
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

        JLabel lblCost = new JLabel("Cost:");
        JTextField txtCost = new JTextField();

        JLabel lblAuthor = new JLabel("Author(s):");
        JTextField txtAuthor = new JTextField();

        JButton btnAdd = new JButton("Add Book");
        btnAdd.addActionListener(e -> {
            String title = txtTitle.getText();
            String category = txtCategory.getText();
            float cost = Float.parseFloat(txtCost.getText());
            String author = txtAuthor.getText();

            Book book = new Book(title, category, cost);
            book.addAuthor(author);
            store.addMedia(book);

            JOptionPane.showMessageDialog(this, "Book added to store!");
        });

        panel.add(lblTitle); panel.add(txtTitle);
        panel.add(lblCategory); panel.add(txtCategory);
        panel.add(lblCost); panel.add(txtCost);
        panel.add(lblAuthor); panel.add(txtAuthor);
        panel.add(new JLabel()); panel.add(btnAdd);

        return panel;
    }
}
