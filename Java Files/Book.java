
package Lab_project;
import java.util.*;
import java.io.*;



public class Book implements Serializable{
    private String bookTitle;
    private Author  author;
    private long pages;
    private String publisher;
    private int yearOfPublish;
    private boolean bookedStatus;
    private long bookID;
    private int price;

    public Book() {
    }
    public Book(String bookTitle, Author author, long pages, String publisher, int yearOfPublish, boolean bookedStatus, long bookID, int price) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.pages = pages;
        this.publisher = publisher;
        this.yearOfPublish = yearOfPublish;
        this.bookedStatus = bookedStatus;
        this.bookID = bookID;
        this.price = price;
    }

    
    
    public String getBookTitle() {
        return bookTitle;
    }
    public Author getAuthor() {
        return author;
    }
    public long getPages() {
        return pages;
    }
    public String getPublisher() {
        return publisher;
    }
    public int getYearOfPublish() {
        return yearOfPublish;
    }
    public boolean isBookedStatus() {
        return bookedStatus;
    }
    public long getBookID() {
        return bookID;
    }
    public int getPrice() {
        return price;
    }

    
    
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public void setPages(long pages) {
        this.pages = pages;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }
    public void setBookedStatus(boolean bookedStatus) {
        this.bookedStatus = bookedStatus;
    }
    public void setBookID(long bookID) {
        this.bookID = bookID;
    }
    public void setPrice() {
        this.price = price;
    }
    
    
    
    @Override
    public String toString(){
        String a = "\nAuthor:\t\t";
        a += author.getName() + "\nAuthor Phone Number:\t" + author.getPhoneNumber();
        return "\nBook Name:\t" + bookTitle + a +  "\nBook ID:\t" + bookID + "\nPages:\t\t" + pages + "\nPublisher:\t" + publisher + "\nYear of Publish:\t" + yearOfPublish + "\nBooked Status:\t" + bookedStatus + "\nPrice:\t\t" + price;
    }
}
