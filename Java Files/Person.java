
package Lab_project;
import java.io.*;



public class Person implements Serializable{
    private String name;
    private char gender;
    private int age;
    private String phoneNumber;
    
    
    
    Person(){   
    }
    public Person(String name, char gender, int age, String phoneNumber) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    
    
    public int getAge() {
        return age;
    }
    public char getGender() {
        return gender;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    
    
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
    
    @Override
    public String toString(){
        return "\nName:\t" + name + "\nGender:\t" + gender + "\nAge:\t" + age + "\nPhone Number:\t" + phoneNumber;
    }
}
