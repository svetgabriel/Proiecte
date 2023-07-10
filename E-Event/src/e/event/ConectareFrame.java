package e.event;
import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectareFrame extends JFrame{
    private JTextField tf1,tf2,tf3;
    private JButton cont;
    
    public ConectareFrame(){
        super("Conectare");
        
         JPanel p=new JPanel();
        p.setLayout(new GridLayout(4,2,0,0));
        p.add(new Label("Nume:"));
         tf1=new JTextField(10);
        p.add(tf1);
        p.add(new Label("Email:"));
         tf2=new JTextField(10);
        p.add(tf2);
        p.add(new Label("Parola:"));
         tf3=new JTextField(10);
        p.add(tf3);
         cont=new JButton("Creeaza cont");
        p.add(cont);
        add(p);
    }
    
    public void AdaugaUtilizator(JTextField n,JTextField e,JTextField p){
        try {
            FileWriter inregistrare=new FileWriter("Utilizatori.txt");
            inregistrare.write(e.getText() + "/" + p.getText() + "/" + n.getText() + "\n");
        } catch (IOException ex) {
            Logger.getLogger(ConectareFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
