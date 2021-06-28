
package Lab_project;
import java.io.*;
import java.util.*;



public class BookStore implements Serializable{
    private Person owner;
    private ArrayList<Book> books = new ArrayList();
    private ArrayList<Rack> racks = new ArrayList();
    private Staff staff;
    private String storeName;
    private String storeAddress;
    private ArrayList<Customer> customers = new ArrayList();
    private int rackCount = 0;
    private int count = 0;

    public BookStore() {
    }
    public BookStore(Person owner, Staff staff, String storeName, String storeAddress, Book[] books, Rack[] racks, Customer[] customer) {
        this.owner = owner;
        this.staff = staff;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        for(int i=0; i<books.length; i++){
            this.books.add(books[i]);
        }
        for(int i=0; i<racks.length; i++){
            this.racks.add(racks[i]);
        }
        for(int i=0; i<customer.length; i++){
            this.customers.add(customer[i]);
        }
    }
    public BookStore(Person owner, Staff staff, String storeName, String storeAddress, Book[] books, Rack[] racks) {
        this.owner = owner;
        this.staff = staff;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        for(int i=0; i<books.length; i++){
            this.books.add(books[i]);
        }
        for(int i=0; i<racks.length; i++){
            this.racks.add(racks[i]);
        }
    }
    
    
    public Person getOwner() {
        return owner;
    }
    public ArrayList<Book> getBooks() {
        return books;
    }
    public ArrayList<Rack> getRacks() {
        return racks;
    }
    public Staff getStaff() {
        return staff;
    }
    public String getStoreName() {
        return storeName;
    }
    public String getStoreAddress() {
        return storeAddress;
    }
    public ArrayList<Customer> getCustomer() {
        return customers;
    }
    
    
    
    
    
    public void setCustomer(Customer[] customer) {
        for(int i=0; i<customer.length; i++){
            this.customers.add(customer[i]);
        }
        updater();
    }
    public void setOwner(Person owner) {
        this.owner = owner;
        updater();
    }
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        updater();
    }
    public void setRacks(Rack[] racks) {
        for(int i=0; i<racks.length; i++){
            this.racks.add(racks[i]);
        }
        updater();
    }
    public void setStaff(Staff staff) {
        this.staff = staff;
        updater();
    }
    public void setStoreName(String storeName) {
        this.storeName = storeName;
        updater();
    }
    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
        updater();
    }
    
    
    
    
    
    
    
    
    public void addBook(Book e){
        if(count == 0){
            Rack r = new Rack();
            racks.add(r);
            r.addBook(e);
            books.add(e);
            count++;
            updater();
            return;
        }
        if(racks.get(rackCount).spaceChecker()){
            racks.get(rackCount).addBook(e);
            System.out.println("Yes.");
        }
        else{
            if(racks.size()<4){
                racks.add(new Rack());rackCount++;
                racks.get(rackCount).addBook(e);
            }
            else{
                System.out.println("All Racks are full. No more space available.");
                return;
            }
        }
        books.add(e);
        int index = books.indexOf(e);
        books.get(index).getAuthor().addBook(e);
        updater();
    }
    public void addWorker(Worker e){
        staff.addWorker(e);
        updater();
    }
    public void removeBook(Book e){
        books.remove(e);
        removeRackBook(e);
        updater();
    }
    public Book searchByID(long id){
        for(int i=0; i<books.size(); i++){
            if(books.get(i).getBookID() == id){
                return books.get(i);
            }
        }
        System.out.println("Book not Found.");
        return null;
    }

    public void addCustomer(Customer c){
        customers.add(c);
        updater();
    }
    public Customer findCustomer(String number){
        for(int i=0; i<customers.size(); i++){
            if(customers.get(i).getPhoneNumber().equals(number)){
                System.out.println("Customer Found.");
                return customers.get(i);
            }
        }
        return null;
    }
    public void removeRackBook(Book e){
        if(e.getBookID()>=19000 && e.getBookID()<19210)   
            racks.get(0).removeBook(racks.get(0).getBooks().indexOf(e));
        else if(e.getBookID()>=19210 && e.getBookID()<19409)
            racks.get(1).removeBook(racks.get(1).getBooks().indexOf(e));
        else if(e.getBookID()>=19409 && e.getBookID()<19610)
            racks.get(2).removeBook(racks.get(2).getBooks().indexOf(e));
        else if(e.getBookID()>=19610 && e.getBookID()<19810)
            racks.get(3).removeBook(racks.get(3).getBooks().indexOf(e));
        updater();
    }
    public void purchaseBook(Book e){
        Scanner input = new Scanner(System.in);
        Customer b_c = new Customer();
        System.out.println("Please enter the details.\nAre you already verified? 1 means yes and 0 means no.");
        if(input.nextInt()==1){
            System.out.println("Just Enter your Phone Number.");
            String number = input.next();
            b_c = findCustomer(number);
            if(b_c == null){
                System.out.println("You are not a verified Customer.");
                b_c = customerMaker(b_c);
            }
        }
        else{
            customerMaker(b_c);
        }
        purchaseEffects(b_c, e);
        System.out.println("Purchase Successfull.");
        updater();
    }
    private Customer customerMaker(Customer b_c){
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter your name.");
        String user_name = input.next();
        System.out.println("Your Age.");
        int user_age = input.nextInt();
        System.out.println("Your Gender.");
        char user_gender = input.next().charAt(0);
        System.out.println("Your Phone Number.");
        String user_phoneNumber = input.next();
        System.out.println("Your payment method.");
        String user_payment = input.next();
        b_c =new Customer(user_payment, user_name, user_gender, user_age, user_phoneNumber);
        customers.add(b_c);
        return b_c;
    }
    private void purchaseEffects(Customer b_c, Book e){
        b_c.addBook(e);
        removeBook(e); 
    }
    public void showRacks(){
        for(int i=0; i<racks.size(); i++){
            String s = "\nRack " + (i+1) + ":";
            s += racks.get(i).toString();
            System.out.println(s);
        }
    }
    public ArrayList<Book> showAuhtorBook(String number){
        for(int i=0; i<books.size(); i++){
            if(books.get(i).getAuthor().getPhoneNumber().equals(number)){
                System.out.println("Author " + books.get(i).getAuthor().getName() + " Books:\n");
                return books.get(i).getAuthor().getBooksWritten();
            }
        }
        System.out.println("Author not Found.");
        return null;
    }
    
    
    
    
    
    
    
    
    public void bookArrayPrinter(){
        String s = "\n";
        for(int i=0; i<books.size(); i++){
            System.out.println(books.get(i).toString() + "\n");
        }
    }
    @Override
    public String toString(){
        String s = "\n";
        String e = "\n";
        for(int i=0; i<books.size(); i++){
            s += books.get(i).toString();
            s += "\n";
        }
        for(int i=0; i<racks.size(); i++){
            e += racks.get(i).toString();
            e += "\n";
        }
        return "\nOwner of Book Store:\t" + owner.getName() + "\n\nRacks:\t" + racks.size() + "\n\n\nBooks in the Store:" + s + "\n\n" + "\nStaff:\t\nStaff Head:\t" + staff.getHead().getName() + "\nStaff Strength:\t" + staff.getWorkers().size() + "\n\n\nStore Address:\t" + storeAddress + "\n\n\nStore Name:\t" + storeName;
    }
    
    
    
    
    
    public void updater(){
        BookStore storeObject = new BookStore();
        storeObject.owner = owner;
        storeObject.staff = staff;
        storeObject.storeName = storeName;
        storeObject.storeAddress = storeAddress;
        for(int i=0; i<books.size(); i++){
            storeObject.books.add(books.get(i));
        }
        for(int i=0; i<racks.size(); i++){
            storeObject.racks.add(racks.get(i));
        }
        for(int i=0; i<customers.size(); i++){
            storeObject.customers.add(customers.get(i));
        }
        writter(storeObject);
    }
    public void writter(BookStore bs){
        try{
            final String FILENAME = "BookStore.txt";
            File f = new File(FILENAME);
            FileOutputStream fos = new FileOutputStream(FILENAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(bs);
        }
        catch(Exception e){System.out.println("Error :{");}
    }    
    public BookStore reader(){
        final String FILENAME = "BookStore.txt";
        try{
            File f = new File(FILENAME);
            FileInputStream fis = new FileInputStream(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);

            BookStore bs = (BookStore)ois.readObject();
            ois.close();
            return bs;
            }   
        catch(Exception e){System.out.println("File does not exists.");
        return null;}
    }
}
