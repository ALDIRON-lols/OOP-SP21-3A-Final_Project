
package Lab_project;
import java.io.*;
import java.util.*;



public class Staff implements Serializable{
    private ArrayList<Worker> workers = new ArrayList();
    private Worker head;

    public Staff() {
    }
    public Staff(Worker head, Worker[] workers) {
        this.head = head;
        for(int i=0; i<workers.length; i++){
            this.workers.add(workers[i]);
        }
    }

    
    
    public ArrayList<Worker> getWorkers() {
        return workers;
    }
    public Worker getHead() {
        return head;
    }
    
    
    
    public void setWorkers(ArrayList<Worker> workers) {
        this.workers = workers;
    }
    public void setHead(Worker head) {
        this.head = head;
    }
    public void addWorker(Worker w){
        workers.add(w);
    }
    public void removeWorker(int i){
        workers.remove(i);
    }
    public Worker searchWorker(String number){
        for(int i=0; i<workers.size(); i++){
            if(workers.get(i).getPhoneNumber().equals(number)){
                return workers.get(i);
            }
        }
        System.out.println("Worker not Found in the Staff.");
        return null;
    }
    
    
    
    @Override
    public String toString(){
        String s = "\n";
        for(int i=0; i<workers.size(); i++){
            s += workers.get(i).toString();
            s += "\n";
        }
        return "\n" + s + head.toString() + "\n\n\n\n";
    }
}
