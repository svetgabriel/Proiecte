
package propiectpoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ClientWriter {
    public static void scrieClient(String numefis,Client c)throws IOException{
        try{
            File fisier = new File(numefis);
            BufferedWriter out = new BufferedWriter(new FileWriter(fisier,true));
            if(existaClient(fisier,c.getCnp())){
                System.out.println("Clientul cu cnp-ul " + c.getCnp() + " exista deja.");
                return;
            }
            out.newLine();
            out.write(c.getNume() + " " + c.getPrenume() + " " + c.getCnp() + " " + c.getIdAsigurare());
            out.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private static boolean existaClient(File fisier,String cnp)throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fisier));
        String linie;
        while((linie = br.readLine()) != null){
            String[] info = linie.split(" ");
            if(info[2].equals(cnp))
                return true;
        }
        return false;
        
    }
}

