/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rokin.toolazytoclicknextscrapper;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author rokin
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            for(int i =1; i<10;i++)
            {

                    URL url = new URL("http://brainberries.co/interesting/16-hollywood-celebrities-and-their-historical-doppelgangers/" + i + "/");
                    URLConnection urlConn = url.openConnection();
                    
                    BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                    String line ="";
                    StringBuilder builder = new StringBuilder();
                    
                    while((line = reader.readLine()) != null)
                    {
                        builder.append(line).append("\n");
                    }
                    
                    FileWriter writer = new FileWriter("/home/rokin/Desktop/CelebDopelgangers/" + i +".html");
                    writer.write(builder.toString());
                    

            }
        } catch (IOException ex) {
                System.out.println("Exception: " + ex.getMessage());
        }
            
    
    }
}

