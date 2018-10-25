/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.christian;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author lucasemanuel8
 */
public class Client {
    public static void main(String[] args) { 
        try{
            Socket client = new Socket("localhost", 12345);
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            Date currentDate = (Date)in.readObject();
            System.out.println("Date of server: " + currentDate.toString());
            in.close();
            System.out.println("Connect finally!");
        }catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
