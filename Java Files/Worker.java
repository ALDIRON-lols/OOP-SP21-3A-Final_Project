
package Lab_project;
import java.io.*;



public class Worker extends Person implements Serializable{
    private long pay;
    private String rank;

    public Worker() {
    }
    public Worker(long pay, String rank) {
        this.pay = pay;
        this.rank = rank;
    }
    public Worker(String name, char gender, int age, String phoneNumber, long pay, String rank) {
        super(name, gender, age, phoneNumber);
        this.pay = pay;
        this.rank = rank;
    }

    
        
    public long getPay() {
        return pay;
    }
    public String getRank() {
        return rank;
    }

    
    
    public void setPay(long pay) {
        this.pay = pay;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }
    
    
    
    @Override
    public String toString(){
        return super.toString() + "\nPay:\t" + pay + "\nRank:\t" + rank;
    }
}
