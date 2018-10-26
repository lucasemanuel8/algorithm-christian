/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.christian;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 *
 * @author lucasemanuel8
 */
public class Server {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server Lister a port 12345");

            while(true){
                Socket client = server.accept();    
//                System.out.println("Addr client: " + client.getInetAddress().getHostAddress());
                DataInputStream in = new DataInputStream(client.getInputStream());
                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                out.writeLong(System.currentTimeMillis());
                Random rand= new Random();
                Thread.sleep(rand.nextInt(1000));
//                DataInputStream dis = new DataInputStream(client.getInputStream()); 
//                String aff = dis.readUTF();
                out.flush();
                out.writeInt((int)System.currentTimeMillis());
                out.close();
                client.close();
            }
        }catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
