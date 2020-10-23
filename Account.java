/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;  
import java.util.Date;  
/**
 *()
 * @author Suyash
 */
 class Account1 {
    public int balance;
    public int accountNo;
    void displayBalance(){
        System.out.println("Acc no. "+accountNo+" Bal: "+balance);
    }
    
     void deposit(int amount) throws FileNotFoundException, IOException {
       String s = Integer.toString(amount)+" is deposited";
         balance=balance+amount;
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    Date date = new Date(); 
        String s1 = Integer.toString(balance)+" is current account balance ";
        String s2="\n DEPOSIT "+formatter.format(date)+"--------------------\n"+ s+"\n"+s1+"\n";
          
    
//        System.out.println(s);
        try (FileOutputStream fout = new FileOutputStream("output.txt",true)) {
           
             byte b1[]=s2.getBytes();
              fout.write(b1);
          fout.close();
        }
        catch(Exception e){
            System.out.println("error");
        }
        
//        displayBalance();
    }
    synchronized void withdraw(int amount){
//        balance=balance-amount;
//        System.out.println(amount+" is withdrawn");
//        displayBalance();
        String s = Integer.toString(amount)+" is withdrawn";
         balance=balance-amount;
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    Date date = new Date(); 
        String s1 = Integer.toString(balance)+" is current account balance";
        String s2= "\n WITHDRAWAL "+formatter.format(date)+"-----------------\n"+s+"\n"+s1+"\n";
//        System.out.println(s);
        try (FileOutputStream fout = new FileOutputStream("output.txt",true)) {
           
             byte b1[]=s2.getBytes();
              fout.write(b1);
          fout.close();
        }
        catch(Exception e){
            System.out.println("error");
        }
    }
}
class Deposit implements Runnable{
    int amount;
    Account1 acc;
    public Deposit(Account1 acc,int amount){
       this.acc= acc;
        this.amount=amount;
        new Thread(this).start();
    }
    @Override
    public void run(){
        try {
            acc.deposit(amount);
        } catch (IOException ex) {
            Logger.getLogger(Deposit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class Withdraw implements Runnable{
    int amount;
    Account1 acc;
    public Withdraw(Account1 acc,int amount){
       this.acc=acc;
        this.amount=amount;
        new Thread(this).start();
    }
    public void run(){
        acc.withdraw(amount);
    }
}

public class Account{
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Scanner s = new Scanner(System.in);
        Account1 abc = new Account1();
        abc.balance = 1000;
        abc.accountNo=11;
        int d1=0;
        int d2=0;
        int i=0;
        
        while(i<100){
            System.out.println("To deposit amount press 1,\n For withdrawal press 2,\n To exit press 3");
        int o= s.nextInt();
        if(o==3){
        break;}
                switch (o) {
          case 1:
            System.out.println("Enter amount to be deposited");
             d1=s.nextInt();
              Deposit d = new Deposit(abc,d1);
              i++;
            break;
          case 2:
            System.out.println("Enter amount to be withdrawn");
             d2=s.nextInt();
             Withdraw w= new Withdraw(abc,d2);
             i++;
            break;
         
            
        }
                
        }
        
        
       
        
//        try (FileOutputStream fout = new FileOutputStream("output.txt")) {
//            int a=0;
//            while(a<3){
////            int b=30;  
//            String s1="\n";
////             byte b[]=s.getBytes();
//             byte b1[]=s1.getBytes();
//              fout.write(20);
//              fout.write(b1);
//              fout.flush();
//              a++;
//          }
//        }   
            
          
    }
    }
