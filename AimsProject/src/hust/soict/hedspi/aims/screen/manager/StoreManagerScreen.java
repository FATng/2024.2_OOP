package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Book;


import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;          
import java.awt.event.*;

public class StoreManagerScreen extends JFrame{

	private Store store;
    
	JPanel createNorth() {
	    JPanel north = new JPanel();
	    north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
	    north.add(createMenuBar());
	    north.add(createHeader());
	    return north;
	}

	JMenuBar createMenuBar() {
	    JMenu menu = new JMenu("Options");

	    menu.add(new JMenuItem("View store"));

	    JMenu smUpdateStore = new JMenu("Update Store");

	    menu.add(smUpdateStore);
	    JMenuItem addBook = new JMenuItem("Add Book");
	    addBook.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            new AddBookToStoreScreen(store);
	        }
	    });

	    JMenuItem addCD = new JMenuItem("Add CD");
	    addCD.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            new AddCompactDiscToStoreScreen(store);
	        }
	    });

	    JMenuItem addDVD = new JMenuItem("Add DVD");
	    addDVD.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            new AddDigitalVideoDiscToStoreScreen(store);
	        }
	    });

	    smUpdateStore.add(addBook);
	    smUpdateStore.add(addCD);
	    smUpdateStore.add(addDVD);


	    JMenuBar menuBar = new JMenuBar();
	    menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    menuBar.add(menu);

	    return menuBar;
	}
	
	JPanel createHeader() {
	    JPanel header = new JPanel();
	    header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

	    JLabel title = new JLabel("AIMS");
	    title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
	    title.setForeground(Color.CYAN);

	    header.add(Box.createRigidArea(new Dimension(10, 10)));
	    header.add(title);
	    header.add(Box.createHorizontalGlue());
	    header.add(Box.createRigidArea(new Dimension(10, 10)));

	    return header;
	}
	
	JPanel createCenter() {
	    JPanel center = new JPanel();
	    center.setLayout(new GridLayout(3, 3, 2, 2));

	    ArrayList<Media> mediaInStore = store.getItemsInStore();
	    
	    for (int i = 0; i < Math.min(mediaInStore.size(), 9); i++) {
	        MediaStore cell = new MediaStore(mediaInStore.get(i));
	        center.add(cell);
	    }
	    
	    return center;
	}
	

	public StoreManagerScreen(Store store) {
	    this.store = store;

	    Container cp = getContentPane();
	    cp.setLayout(new BorderLayout());
	    cp.add(createNorth(), BorderLayout.NORTH);
	    cp.add(createCenter(), BorderLayout.CENTER);

	    setTitle("Store");
	    setSize(1024, 768);
	    setLocationRelativeTo(null);
	    setVisible(true);
	}
	
	public static void main(String[] args) {
	    Store store = new Store();

	    store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", 19.95f));
	    store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f));
	    store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", 18.99f));
	    store.addMedia(new Book("Harry Potter", "Fantasy", 15.5f));
	    store.addMedia(new Book("The Hobbit", "Fantasy", 13.9f));
	    store.addMedia(new CompactDisc("Adele 21", "Pop", 14.99f));
	    store.addMedia(new CompactDisc("Beethoven Symphony No.9", "Classical", 16.8f));
	    store.addMedia(new Book("Clean Code", "Programming", 29.99f));

	    new StoreManagerScreen(store);
	}

    
	public StoreManagerScreen() {
		// TODO Auto-generated constructor stub
	}

}