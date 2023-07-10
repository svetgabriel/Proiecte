
package propiectpoo;

public class Masina {
    
    private String marca;
    private String model;
    private int an;
    private String motorizare;
    private double cc;
    private String indice_emisie;
    private String indice_risc;
    private double pret;
    
    public Masina(String marca,String model,int an,String motorizare,double cc,double pret){
        this.marca = marca;
        this.model = model;
        this.an = an;
        this.motorizare = motorizare;
        this.cc = cc;
        this.pret = pret;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model){
        this.model = model;
    }
    
    public int getAn() {
        return an;
    }
    
    public String getMotorizare(){
        return motorizare;
    }
    
    public double getCC(){
        return cc;
    }
    
    public String getIndice_emisie(){
        return indice_emisie;
    }
    
    public void setIndice_emisie(String ie){
        this.indice_emisie = ie;
    }
    
    public String getIndice_risc(){
        return indice_risc;
    }
    
    public void setIndice_risc(String ir){
        this.indice_risc = ir;
    }
    
    public double getPret() {
        return pret;
    }
    
}
