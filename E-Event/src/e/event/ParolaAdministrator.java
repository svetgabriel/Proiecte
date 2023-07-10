package e.event;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParolaAdministrator implements VerificariParole{
    
    @Override
   public boolean Comparatie(String s){
   File continut=new File("ParolaServer.txt");
   Scanner scaner;
       try {
            scaner = new Scanner(continut);
            if(!scaner.hasNext())
            return true;
            if(s.equals(scaner.nextLine()))
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ParolaAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        }
     return false;
    }
}
