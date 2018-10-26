/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.christian;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author lucasemanuel8
 */
public class Client {
    public static void main(String[] args) { 
        try{
            Socket client = new Socket("localhost", 12345);
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            String msg = "Qual é o tempo?";
            
            long t1 = System.currentTimeMillis();
            out.writeUTF(msg);
//            long t2 = in.readInt();
            long serverTime = in.readLong();
//            long t3 = serverTime;
            Random rand= new Random();
            Thread.sleep(rand.nextInt(10000));
            long t4 = System.currentTimeMillis();
            
            long time = serverTime + (t4 - t1)/2;
            DateFormat simDate = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS");
            Date result = new Date(time); 
            System.out.println(new Date(t1) + "\n" + new Date(t4) + "\n" + simDate.format(result) + "\n");
//            System.out.println("Date of server: " + currentDate.toString());
            in.close();
            System.out.println("Connect finally!");
        }catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
