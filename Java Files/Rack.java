
package Lab_project;
import java.io.*;
import java.util.*;



public class Rack implements Serializable{
    private ArrayList<Book> books = new ArrayList();
    private int count;

    public Rack() {
        count = 0;
    }
    public Rack(Book[] books){
        for(int i=0; i<books.length; i++){
            this.books.add(books[i]);
            count = i;
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    
    
    
    
    
    
    
    public void addBook(Book book){
            books.add(book);
            count++;
            System.out.println("Book Successfully Added.");
    }
    public void removeBook(String name){
        for(int i=0; i<count; i++){
            if(books.get(i).getBookTitle() == name){
                books.remove(i);
                return;
            }
        }
        System.out.println("Book Not Found");
    }
    public void removeBook(int index){
        books.remove(index);   
    }
    public boolean spaceChecker(){
        if(books.size()<200)
            return true;
        else
            return false;
    }
    
    
    
    @Override
    public String toString(){
        String s = "\n";
        for(int i=0; i<books.size(); i++){
            s += books.get(i).toString();
            s += "\n";
        }
        s += "\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
        return s;
    }
}
