
package Lab_project;
import java.util.*;
import java.io.*;



public class Customer extends Person implements Serializable{
    private String payment_method;
    private ArrayList<Book> booksInPosession =  new ArrayList();

    public Customer(){
       
    }
    
    public Customer(String payment_method, ArrayList<Book> booksInPosession) {
        this.payment_method = payment_method;
        this.booksInPosession = booksInPosession;
    }

    public Customer(String payment_method, ArrayList<Book> booksInPosession, String name, char gender, int age, String phoneNumber) {
        super(name, gender, age, phoneNumber);
        this.payment_method = payment_method;
        this.booksInPosession = booksInPosession;
    }
    public Customer(String payment_method, String name, char gender, int age, String phoneNumber) {
        super(name, gender, age, phoneNumber);
        this.payment_method = payment_method;
    }
    
    

    public String getPayment_method() {
        return payment_method;
    }

    public ArrayList<Book> getBooksInPosession() {
        return booksInPosession;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public void setBooksInPosession(ArrayList<Book> booksInPosession) {
        this.booksInPosession = booksInPosession;
    }
    
    public void addBook(Book b){
        booksInPosession.add(b);
    }
 
    
    @Override
    public String toString(){
        String s = "\n";
        for(int i=0; i<booksInPosession.size(); i++){
            s += booksInPosession.get(i).getBookTitle() + "\t\tBook ID: " + booksInPosession.get(i).getBookID();
            s += "\n";
        }
        return super.toString() + "\nPayment Method\t" + payment_method + "\nBooks in Bought from here.\t" + s;
    }
}
