
package Lab_project;
import java.io.*;
import java.util.*;



public class Author extends Person implements Serializable{
    private ArrayList<Book> booksWritten = new ArrayList();

    public Author() {
    }
    public Author(Book[] booksWritten) {
        for(int i=0; i<booksWritten.length; i++){
            this.booksWritten.add(booksWritten[i]);
        }
    }
    public Author(String name, char gender, int age, String phoneNumber, Book[] booksWritten) {
        super(name, gender, age, phoneNumber);
        for(int i=0; i<booksWritten.length; i++){
            this.booksWritten.add(booksWritten[i]);
        }
    }
    public Author(String name, char gender, int age, String phoneNumber) {
        super(name, gender, age, phoneNumber);
    }

    
    
    public ArrayList<Book> getBooksWritten() {
        return booksWritten;
    }
    public void setBooksWritten(ArrayList<Book> booksWritten) {
        this.booksWritten = booksWritten;
    }
    public void addBook(Book e){
        booksWritten.add(e);
    }
    public void removeBook(Book e){
        booksWritten.remove(e);
    }
    
    
    
    @Override
    public String toString(){
        String s = "\n";
        for(int i=0; i<booksWritten.size(); i++){
            s += booksWritten.get(i).toString();
            s += "\n";
        }
        return super.toString() + s;
    }
}
