
package propiectpoo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class PropiectPOO {

    
    public static void main(String[] args) throws IOException {
        List<Masina> m = MasinaReader.citesteMasini("Masini.txt");
        for(int i = 0;i < m.size();i++)
            System.out.println(m.get(i).getMarca() + " " + m.get(i).getModel() + " " + m.get(i).getAn() + " " + m.get(i).getMotorizare() + " " + m.get(i).getCC() + " " + m.get(i).getPret() + " " + m.get(i).getIndice_risc() + " " + m.get(i).getIndice_emisie());
        List<Client> c = ClientReader.citesteClienti("Clienti.txt");
        for(int i = 0;i < c.size();i++){
            System.out.println(c.get(i).getNume() + " " + c.get(i).getPrenume() + " " + c.get(i).getCnp() + " ");
        }
        List<Asigurare> a = new ArrayList<>();
        Asigurare as = new Asigurare(c.get(1),m.get(2),6); as.CalculeazaPret();
        a.add(as);
        as = new Asigurare(c.get(0),m.get(1),12); as.CalculeazaPret();
        a.add(as);
        as = new Asigurare(c.get(2),m.get(3),24); as.CalculeazaPret();
        a.add(as);
        for(int i = 0;i < a.size();i++){
            AsigurareWriter.scrieAsigurare("Asigurari.txt", a.get(i));
        } 
        List<Factura> f = new ArrayList<>();
        for(int i = 0;i < a.size();i++){
            f.add(new Factura(a.get(i),i));
        }
        for(int i = 0;i < f.size();i++){
            FacturaWriter.scrieFactura("Facturi.txt", f.get(i));
        }
    }
    
}
