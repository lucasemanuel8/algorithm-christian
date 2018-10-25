/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.christian;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

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
                System.out.println("Addr client: " + client.getInetAddress().getHostAddress());
                ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
                out.flush();
                out.writeObject(new Date());
                out.close();
                client.close();
            }
        }catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
