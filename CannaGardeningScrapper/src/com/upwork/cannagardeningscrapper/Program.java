/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upwork.cannagardeningscrapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
//            URL url = new URL("http://www.cannagardening.com/dealer/shop/dealermarkers");
//            URLConnection urlConnection = url.openConnection();
            
            //BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            
            BufferedReader reader = new BufferedReader(new FileReader("/home/rokin/Desktop/json.txt"));
            
            String line ="";
            StringBuilder builder = new StringBuilder();
            
            while((line = reader.readLine())!=null)
            {
                builder.append(line);
            }
            
            //System.out.println(builder.toString());
            
            String regex = "\"name\":\"(.*?)\",\"street\":\"(.*?)\",\"number\":\"(.*?)\",\"city\":\"(.*?)\",\"postcode\":\"(.*?)\",\"state\":\"(.*?)\",\"country\":\"(.*?)\",\"phone\":\"(.*?)\",\"fax\":\"(.*?)\",.*?\"website\":\"(.*?)\"";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(builder.toString());
            FileWriter writer = new FileWriter("/home/rokin/Desktop/upwork3.csv");
            while(matcher.find())
            {
                writer.write('"' + matcher.group(1) + '"' + "," + '"' + matcher.group(2) + '"' + "," + '"' + matcher.group(3) + '"' + "," + matcher.group(4) + "," + '"' + matcher.group(5) + '"' + "," + '"' + matcher.group(6) + '"' + "," + '"' + matcher.group(7) + '"' + "," + '"' + matcher.group(8) + '"' + "," + '"' + matcher.group(9) + '"' + "," + '"' + matcher.group(10) + '"' + "\n");
            }
            writer.close();
    
        } catch (IOException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        
    }
    
}
