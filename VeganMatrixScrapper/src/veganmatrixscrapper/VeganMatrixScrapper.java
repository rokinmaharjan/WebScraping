/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veganmatrixscrapper;

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
public class VeganMatrixScrapper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
//            URL url = new URL("http://purelifeveganix.com/store-locator/");
//            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            
          

        
        BufferedReader reader = new BufferedReader(new FileReader("/home/rokin/Desktop/script.txt"));
        StringBuilder content = new StringBuilder();
        String line ="";
        while((line = reader.readLine())!= null)
        {
            content.append(line);
        }
        
        
        String regex = "<div class=\"mpfy-mll-l-title\">(.*?)</div>(.*?)<strong>(.*?)</strong>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
            FileWriter writer = new FileWriter("/home/rokin/Desktop/results.csv");
     
        while (matcher.find()) {
           
                writer.append(matcher.group(1).replace(",", ":").trim() + "," + matcher.group(3).replace(",", ":").trim() +"\n");
           
        }
        
        } catch (IOException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        
    }
    
}
