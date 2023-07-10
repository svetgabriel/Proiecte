
package propiectpoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AsigurareWriter {
    public static void scrieAsigurare(String numefis,Asigurare a) throws IOException {
        try{
            File fisier = new File(numefis); 
            BufferedWriter out = new BufferedWriter(new FileWriter(fisier,true));
            if(existaAsigurare(fisier,a.getCnp())){
                System.out.println("Asigurarea cu id-ul " + a.getIdAsigurare() + " exista deja.");
                return;
            }
           
            out.write(a.getIdAsigurare() + " " + a.getNume() + " " + a.getPrenume() + " " + a.getCnp() + " " + a.getMarca() + " " + a.getModel() + " " + a.getDataIncheiere() + " " + a.getDataExpirare());
            out.newLine();
            out.close();
            Client c = new Client(a.getNume(),a.getPrenume(),a.getCnp());
            c.setIdAsigurare(a.getIdAsigurare());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static boolean existaAsigurare(File fisier,String id)throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fisier));
        String linie;
        while((linie = br.readLine()) != null){
            String[] info = linie.split(" ");
            if(info[3].equals(id))
                return true;
        }
        return false;
        
    }
    
}
