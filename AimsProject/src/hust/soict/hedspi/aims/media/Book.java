package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{

    private List<String> authors = new ArrayList<String>();
	    
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author \"" + authorName + "\" has been added.");
        } else {
            System.out.println("Author \"" + authorName + "\" is already in the list.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author \"" + authorName + "\" has been removed.");
        } else {
            System.out.println("Author \"" + authorName + "\" is not in the list.");
        }
    }

}
