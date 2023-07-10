
package propiectpoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FacturaWriter {
    public static void scrieFactura(String numefis,Factura f)throws IOException{
        try{
            File fisier = new File(numefis);
            BufferedWriter out = new BufferedWriter(new FileWriter(fisier,true));
            out.write("Factura: " + f.getIDFactura());
            out.newLine();
            out.write("Data emiterii: " + f.getDataEmiterii());
            out.newLine();
            out.write("Client: " + f.getNumeClient() + " " + "Cnp: " + f.getCnpClient());
            out.newLine();
            out.newLine();
            out.write("--------------------------------------------------------------------------------------");
            out.newLine();
            out.write("Masina: " + f.getMasina());
            out.newLine();
            out.write("Valabil de la: " + f.getDataAsigurare_Incheiere() + " pana la: " + f.getDataAsigurare_Expirare());
            out.newLine();
            out.write("Valoare asigurata: " + f.getPretMasina() * 0.65);
            out.newLine();
            out.write("--------------------------------------------------------------------------------------");
            out.newLine();
            out.write("Total                       " + f.getPret());
            out.newLine();
            out.newLine();
            out.close();
            
        }catch(IOException e){
            e.printStackTrace();
         }
    }
}
