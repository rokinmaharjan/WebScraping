/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upwork.humboldtssecretscrapper;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author rokin
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            URL url = new URL("http://humboldtssecret.com/store_locator");
            URLConnection urlConnection = url.openConnection();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line ="";
            StringBuilder builder = new StringBuilder();
            
            while((line=reader.readLine())!= null)
            {
                builder.append(line);
            }
            
            //System.out.println(builder.toString());
            
            String regex = "<div\\sclass=\"loca-main-heading\">(.*?)</div>(.*?)>(.*?)</div>(.*?)>(.*?)</div>";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(builder.toString());
            FileWriter writer = new FileWriter("/home/rokin/Desktop/upwork1.csv");
            while(matcher.find())
            {
                
                System.out.println(matcher.group(1).trim());
                System.out.println(matcher.group(3).trim());
                System.out.println(matcher.group(5).trim());
                writer.write(matcher.group(1).trim() + "," + matcher.group(3).trim().replace(",", ";") + "," +matcher.group(5).trim() + "\n");
                
            }
        
            
            writer.close();
            
                
        } catch (IOException ex) {
            System.out.println("Exception: " + ex.getMessage());;
        }
        
    }
    
}
