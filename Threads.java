/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *()
 * @author Suyash
 */
public class Threads extends Thread{
    public void run(){
//        int i=0;
//         while(i<10){
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        System.out.println(Thread.currentThread().getName());
//        }}
        if (Thread.currentThread().isDaemon()) {
            System.out.println("daemon thread start "+Thread.currentThread().getName());
        }
        else{
            System.out.println("User thread start "+Thread.currentThread().getName());
        }}
    public static void main(String[] args) throws InterruptedException {
        Threads t = new Threads();
        Threads t1 = new Threads();
        t.setName("Ab");
        t1.setName("Yz");
        t1.setPriority(2);
        t.setPriority(1);
        t.setDaemon(true);
        t.start();
//        t.join();
        t1.start();
        
//        while(i<10)
//        {
//            System.out.println(Thread.t().getName());
//             System.out.println(t1.getName());
//             i++;
//        }
        
    }
}
