/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.christian;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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
            
            String hora = "16:00:00";
            String msg = "Qual é o tempo?";
            long t0 = System.currentTimeMillis();
            System.out.println("Requisitando");
            out.writeUTF(msg);
            long serverTime = in.readLong();
            Random rand= new Random();
            Thread.sleep(rand.nextInt(4000));
            long t1 = System.currentTimeMillis();
            System.out.println("Respondido");
            long diff = t1 - t0;
            long time = serverTime + (diff/2);
           
            DateFormat formatHora = new SimpleDateFormat("HH:mm:ss:SSS Z");
            String send = formatHora.format(new Date(t0));
            String servidor = formatHora.format(new Date(serverTime));
            String recive = formatHora.format(new Date(t1));
            String nova = formatHora.format(new Date(time));
            
            DateFormat formatMin = new SimpleDateFormat("mm:ss:SSS Z");
            System.out.println("Hora de requisiçãp: "+ send);
            System.out.println("Hora de resposta: " + recive);
            System.out.println("Hora do servidor: "+ servidor);
            System.out.println("Hora do algoritmo: " + nova);
            System.out.println("Diferença de tempo: " + formatMin.format(new Date(diff)));

            in.close();
            System.out.println("Connect finally!");
        }catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
