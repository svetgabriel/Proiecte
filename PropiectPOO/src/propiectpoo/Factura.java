
package propiectpoo;

import java.util.Date;


public class Factura {
    private Asigurare a;
    private int id;
    private Date data_emitere;
    
    public Factura(Asigurare a,int id){
        this.a = a;
        this.id = id;
        data_emitere = new Date();
    }
    
    public int getIDFactura(){
        return id;
    }
    
    public String getIDAsigurare(){
        return a.getIdAsigurare();
    }
    
    public String getNumeClient(){
        String s = a.getNume();
        s = s.concat(" ");
        s = s.concat(a.getPrenume());
        return s;
    }
    
    public String getCnpClient(){
        return a.getCnp();
    }
    
    public String getMasina(){
        String s = a.getMarca();
        s = s.concat(" ");
        s = s.concat(a.getModel());
        return s;
    }
    
    public Date getDataEmiterii(){
        return this.data_emitere;
    }
    
    public Date getDataAsigurare_Incheiere(){
        return a.getDataIncheiere();
    }
    
    public Date getDataAsigurare_Expirare(){
        return a.getDataExpirare();
    }
    
    public double getPret(){
        return a.getPret();
    }
    
    public double getPretMasina(){
        return a.getPretMasina();
    }
}
