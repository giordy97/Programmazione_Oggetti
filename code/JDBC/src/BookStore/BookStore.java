package BookStore;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Utils.DBManager;

public class BookStore {
	DBManager db; 
	HashMap<Integer, Book> byID;
	HashMap<String, List<Book>> byAuthor;

	public BookStore() {
		byID = new HashMap<Integer, Book>();
		byAuthor = new HashMap<String, List<Book>>();
	}
	
	public void open() {
		try {
			db = new DBManager();
			db.open();
			db.verify();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		}
	}
	
	public void close() {
		try {
			db.close();
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		}
	}

	public void load() {
		try {
			db = new DBManager();
			db.open();
			db.verify();
			ResultSet rs = db.executeQuery("SELECT * FROM book LIMIT 100 OFFSET 0");

			Book b;
			while (rs.next()) {
				b = new Book(rs.getInt("id"),
						rs.getString("title"),
						rs.getString("author"),
						rs.getInt("pages"));
				byID.put(b.getId(), b);
				if (!byAuthor.containsKey(b.getAuthor()))
					byAuthor.put(b.getAuthor(), new ArrayList<Book>());
				byAuthor.get(b.getAuthor()).add(b);
			}
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		}
	}

	public void save() {
		for (Book b : byID.values()) {
			try {
				db.executeUpdate(
						String.format("UPDATE book SET title='%s', author='%s', pages='%d' WHERE id='%d'",
								b.getTitle(),
								b.getAuthor(),
								b.getPages(),
								b.getId()));
			} catch (SQLException e) {
				System.out.println("Something went wrong... " + e.getMessage());
			}
		}
	}

	public Book searchByID(Integer ID) {
		return byID.get(ID);
	}

	public List<Book> searchByAuthor(String author) {
		return byAuthor.get(author);
	}

	public static void main(String[] args) {
		BookStore bs = new BookStore();
		bs.load();
		
		Book b1 = bs.searchByID(2);
		List<Book> b2 = bs.searchByAuthor("Tolkien");
		
		System.out.println(b1);
		System.out.println(b2);
		
		b1.setPages(300);
		
		bs.save();
		bs.close();
	}
}
