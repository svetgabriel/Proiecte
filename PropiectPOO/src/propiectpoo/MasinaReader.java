
package propiectpoo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MasinaReader {
    public static List<Masina> citesteMasini(String numefis){
        List <Masina> m = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(numefis))){
            String linie;
            while((linie = br.readLine()) != null){
                String[] caracteristici = linie.split(" ");
                String marca = caracteristici[0];
                String model = caracteristici[1];
                int an = Integer.parseInt(caracteristici[2]);
                String motorizare = caracteristici[3];
                double cc = Double.parseDouble(caracteristici[4]);
                double pret = Double.parseDouble(caracteristici[5]);
                Masina masina = new Masina(marca,model,an,motorizare,cc,pret);
                if(cc < 1.9) masina.setIndice_risc("mic");
                else if(cc >= 1.9 && cc <= 2.4) masina.setIndice_risc("mediu");
                else masina.setIndice_risc("mare");
                if(2023 - an < 5 && cc <= 2.0) masina.setIndice_emisie("euro5");
                else if(2023 - an >=5 && 2023 - an <10 && cc <= 2.0) masina.setIndice_emisie("euro4");
                else if(2023 - an >= 5 && cc >= 3.0) masina.setIndice_emisie("euro2");
                else masina.setIndice_emisie("euro3");
                m.add(masina);
            }
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return m;
    }
}
