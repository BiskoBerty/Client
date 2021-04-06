/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Riccardo
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Connecting...");
        try {
            Socket server = new Socket("socket", 5500);

            PrintWriter out = new PrintWriter(server.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
            Scanner tastiera = new Scanner(System.in);
            String s = "";
            while (!s.equals("exit")) {
                System.out.println("Inserire frase da inviare al server:");
                s = tastiera.nextLine();
                System.out.println("frase: " + s);
                out.println(s);
                String risposta = in.readLine();
                System.out.println("Server: " + risposta);
                String a[] = risposta.split(" ");
                System.out.println(a[a.length-1]);
            }

            in.close();
            server.close();
            System.out.println("connessione interrotta");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
