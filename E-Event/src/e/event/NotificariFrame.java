package e.event;
import javax.swing.*;
import java.awt.*;

public class NotificariFrame extends JFrame{
    private JButton afisare;
    private JComboBox listaC,listaE;
    
    public NotificariFrame(){
        super("Notificari:");
        JPanel p=new JPanel();
        p.setLayout(new GridLayout(3,2,0,0));
        p.add(new JLabel("Categorii culturale:"));
        listaC=new JComboBox();
        p.add(listaC);
        p.add(new JLabel("Eveniment:"));
        listaE=new JComboBox();
        p.add(listaE);
       afisare=new JButton("Afisare");
       p.add(afisare);
        add(p);
    }
}
