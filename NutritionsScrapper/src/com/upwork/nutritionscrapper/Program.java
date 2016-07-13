/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upwork.nutritionscrapper;

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
            StringBuilder builder = new StringBuilder();
            FileWriter writer = new FileWriter("/home/rokin/Desktop/upwork2.csv");
            for (int i = 1; i < 55; i++) {
                URL url = new URL("http://www.advancednutrients.com/sabai/directory?p=" + i + "&category=0&zoom=10&is_mile=1&directory_radius=25&view=list&hide_searchbox=0&hide_nav=0&hide_nav_views=0&hide_pager=0&featured_only=0&feature=1&perpage=25&map_height=500&__ajax=%23sabai-embed-wordpress-shortcode-1%20.sabai-directory-listings-container&_=1468300716160");
                URLConnection urlConnection = url.openConnection();
                
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line = "";
                
                builder.delete(0, builder.length());
                
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                
                
                String regex = "<a\\shref=\".*?target=\"_blank\"\\srel=\".*?\">(.*?)</a>";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(builder.toString());
                
                while(matcher.find())
                {
                    writer.write(matcher.group(1) + "\n");
                }      
                
                
            }
            
            writer.close();
            
        } catch (IOException ex) {
            System.out.println("Exception:" + ex.getMessage());;
        }
    }
}
