package e.event;

public class Evenimente {
   private String nume;
   private String categorie;
   private String dataeveniment;
   private String loc;
   private String pret;
   private String databilete;
   
   public Evenimente(String a,String b,String c,String d,String e,String f){
       this.nume=a;
       this.categorie=b;
       this.dataeveniment=c;
       this.loc=d;
       this.pret=e;
       this.databilete=f;
   }

    @Override
    public String toString(){
    StringBuffer sb=new StringBuffer();
    sb.append(nume);
    sb.append("/");
    sb.append(categorie);
    sb.append("/");    
    sb.append(dataeveniment);
    sb.append("/");   
    sb.append(loc);
    sb.append("/");   
    sb.append(pret);
    sb.append("/");   
    sb.append(databilete);    
    return sb.toString();
    }
}