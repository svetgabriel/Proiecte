package e.event;
import javax.swing.*;
import java.awt.*;

public class AutentificareFrame extends JFrame{
    private JTextField tf1,tf2;
    private JButton cont;
    
    public AutentificareFrame(){
        super("Autentificare");
        
         JPanel p=new JPanel();
        p.setLayout(new GridLayout(3,2,0,0));
        p.add(new Label("Email:"));
         tf1=new JTextField(10);
        p.add(tf1);
        p.add(new Label("Parola:"));
         tf2=new JTextField(10);
        p.add(tf2);
         cont=new JButton("Autentifica");
        p.add(cont);
        add(p);
    }  
}
