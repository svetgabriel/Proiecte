
package propiectpoo;


public class Client {
    private String nume;
    private String prenume;
    private String cnp;
    private String id_asigurare;
    
    
    
    public Client(String nume, String prenume, String cnp){
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
    }
    
    public String getNume(){
        return nume;
    }
    
    public void setNume(String nume){
        this.nume = nume;
    }
    
    public String getPrenume(){
        return prenume;
    }
    
    public void setPrenume(String prenume){
        this.prenume = prenume;
    }
    
    public String getCnp(){
        return cnp;
    }
    
    public void setCnp(String cnp){
        this.cnp = cnp;
    }
    
    public String getIdAsigurare(){
        return id_asigurare;
    }
    
    public void setIdAsigurare(String id){
        this.id_asigurare = id;
    }
    
    
}
