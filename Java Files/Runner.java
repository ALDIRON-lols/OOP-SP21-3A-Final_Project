
package Lab_project;
import java.util.*;



public class Runner {
    
    public static void main(String[] args) {
        BookStore bs1 = new BookStore();
        bs1 = bs1.reader();


        //System.out.println(bs1);
        
        
        
        
        System.out.println("The size of books array "+bs1.getBooks().size());
        
        
        
        
        
        
        
        Scanner input = new Scanner(System.in);
        int choice;
        do{
            System.out.println("Enter the code to go the authorities section or any other digit you will be directed to the customer section and 0 to exit the program.");
            choice = input.nextInt();
        
        
            if(choice == 1199){
                System.out.println("\n-Press 1 to see the details about the staff and about the Book Store(Keeping in mind that you should have the key)."
                    + "\n-Press 2 to see the list of customers.");
                int choice1 = input.nextInt();
                switch(choice1){
                    case 1:
                        System.out.println(bs1.getStaff());
                        break;
                    case 2:
                        ArrayList<Customer> array = bs1.getCustomer();
                        for(int i=0; i<array.size(); i++){
                            System.out.println(array.get(i));
                        }
                }
            }
            else if(choice == 0)
                break;
        
            else{
        
                System.out.println("Hello! Hope you are doing well. Please choose your option from the following menu"
                + "\n-Press 1 to see the entire library of books."
                + "\n-Press 2 to search for a book by its ID."
                        + "\n-Press 3 to Show Racks."
                        + "\n-Press 4 Show an Author Books."
                + "\n-Press 0 to exit the Program.");
        
        
                int choice1 = input.nextInt();
                Book purchase_book;
        
                switch(choice1){
                    case 1:
                        bs1.bookArrayPrinter();
                        System.out.println("Would you like to Purchase any of these. if so please enter 1 to go to purchase menu or enter 0 to go back to the main menu.");
                        choice1 = input.nextInt();
                        if(choice1==1){
                            System.out.println("Please select the search option"
                            + "\n-1 to search by Book ID(5 digit number, if u havent looked at the ID then kindly go and note the ID)."
                            + "\n-0 to go back to main menu.");
                            choice1 = input.nextInt();
                            switch(choice1){
                                case 1:
                                    searchID(bs1);
                                    break;
                                case 0:
                                    break;         
                            }
                        }
                        else
                            break;
                        break;
                    case 2:
                        System.out.println("Please select the search option"
                            + "\n-1 to search by Book ID(5 digit number, if u havent looked at the ID then kindly go and note the ID)."
                            + "\n-0 to go back to main menu.");
                        choice1 = input.nextInt();
                        switch(choice1){
                            case 1:
                                searchID(bs1);
                                break;
                            case 0:
                                break;         
                        }
                        break;
                    case 3:
                        bs1.showRacks();
                        System.out.println("Please select the search option"
                            + "\n-1 to search by Book ID(5 digit number, if u havent looked at the ID then kindly go and note the ID)."
                            + "\n-0 to go back to main menu.");
                        choice1 = input.nextInt();
                        switch(choice1){
                            case 1:
                                searchID(bs1);
                                break;
                            case 0:
                                break;         
                        }
                        break;
                    case 4:
                        System.out.println("Just Enter the Phone Number of the Author.");
                        String number = input.next();
                        System.out.println(bs1.showAuhtorBook(number));
                        System.out.println("Would you like to Purchase any of these. if so please enter 1 to go to purchase menu or enter 0 to go back to the main menu.");
                        choice1 = input.nextInt();
                        if(choice1==1){
                            System.out.println("Please select the search option"
                            + "\n-1 to search by Book ID(5 digit number, if u havent looked at the ID then kindly go and note the ID)."
                            + "\n-0 to go back to main menu.");
                            choice1 = input.nextInt();
                            switch(choice1){
                                case 1:
                                    searchID(bs1);
                                    break;
                                case 0:
                                    break;         
                            }
                        break;
                        }
                        else
                            break;
                    case 0:
                    //same as case 1
                        break;
                }
            
            }
        }
        while(choice!=0);
    }
    
    
    
    
    
    
    
    
    
    
    
    public static void searchID(BookStore bs1){
        Scanner input = new Scanner(System.in);
        Book purchase_book;
        System.out.println("Enter the ID.");
        long id = input.nextLong();
        purchase_book = bs1.searchByID(id);
        if(purchase_book == null)
            return;
        System.out.println(purchase_book);
        System.out.println("Would you like to purchase the Book? 1 means yes and 0 means no.");
        int choice111 = input.nextInt();
        if(choice111 == 1)
            bs1.purchaseBook(purchase_book);
        else
            return;
    }
}
