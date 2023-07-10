
package propiectpoo;

import java.util.*;

public class Asigurare {
    private String id;
    private Client c_info;
    private Masina m_info;
    private int valoare;
    private double pret;
    private int perioada;
    private Date data_incheiere;
    private Date data_expirare;
    
    public Asigurare(Client c,Masina m,int perioada){
        c_info = c; m_info = m;
        this.id = UUID.randomUUID().toString();
        this.data_incheiere = new Date();
        this.data_expirare = new Date();
        this.data_expirare.setMonth(perioada);
        this.perioada = perioada;
        
    }
    
    public String getIdAsigurare(){
        return id;
    }
    
    public void setIdAsigurare(){
        this.id = UUID.randomUUID().toString();
    }
    
    public String getNume(){
        return c_info.getNume();
    }
    
    public String getPrenume(){
        return c_info.getPrenume();
    }
    
    public String getCnp(){
        return c_info.getCnp();
    }
    
    public String getMarca(){
        return m_info.getMarca();
    }
    
    public String getModel(){
        return m_info.getModel();
    }
    
    public double getPretMasina(){
        return m_info.getPret();
    }
    
    public Date getDataIncheiere(){
        return data_incheiere;
    }
    
    public void setDataIncheiere(){
        this.data_incheiere = new Date();
    }
    
    public Date getDataExpirare(){
        return data_expirare;
    }
    
    public void setDataExpirare(int perioada){
        this.data_expirare.setMonth(perioada);
    }
    
    public double getPret(){
        return this.pret;
    }
    
    public void setPret(double pret){
        this.pret = pret;
    }
    
    public void CalculeazaPret(){
        double suma = 100;
        suma = suma * perioada;
        if(m_info.getIndice_risc().equals("mediu"))
            suma = suma + 50 * perioada;
        if(m_info.getIndice_risc().equals("mare"))
            suma = suma + 100 * perioada;
        if(m_info.getIndice_emisie().equals("euro2"))
            suma = suma + 100 * perioada;
        if(m_info.getIndice_emisie().equals("euro3"))
            suma = suma + 50 * perioada;
        suma = suma + m_info.getPret() * 0.4;
        if(perioada == 6)
            suma = suma - suma * 0.05;
        if(perioada >= 12)
            suma = suma - suma * 0.1;
        setPret(suma/10);
    }
}
