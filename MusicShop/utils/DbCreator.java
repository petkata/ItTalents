package utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DbCreator {

	private static File dbFolder = new File("." + File.separator + "src" + File.separator + "db" );
	private static File db = new File("." + File.separator + "src" + File.separator + "db" + File.separator + "database.db");
	
	public static Object createDb(Object obj){
		
		if (dbFolder.exists() && db.exists()) {
			if (db.length() > 0) { // returns the file size in bytes
				try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(db))){
					
					return obj = ois.readObject(); // here should be the cast
					
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (IOException e) {
					System.out.println(e.getMessage());
				} catch (ClassNotFoundException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			dbFolder.mkdir();
			try {
				db.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(db))){
				oos.writeObject(obj);
				System.out.println("\nDB created\n");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return obj;
	}

	public static void saveToDb(Object shop){
		if (dbFolder.exists() && db.exists()) {
			if (db.length() > 0) { // returns the file size in bytes
				try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(db))){
					oos.writeObject(shop);
					System.out.println("\nDb UPDATED\n");
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
			else {
				System.out.println("Database is empty !");
				return;
			}
		}
		else {
			System.out.println("Cannot connect to db");
			return;
		}
	}
	
	public static void deleteDb(Object obj){
		db.delete();
		System.err.println("DB was flushed");
	}
}
