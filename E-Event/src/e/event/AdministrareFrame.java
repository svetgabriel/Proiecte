package e.event;
import javax.swing.*;
import java.awt.event.*;

public class AdministrareFrame extends JFrame{
    private JButton ie,sp;
    private ControlerAdministratie ca;
    
    public AdministrareFrame(){
        super("Administrare");
        
         ca=new ControlerAdministratie();
         JPanel p=new JPanel();
         ie=new JButton("Introduceti evenimente");
        p.add(ie);
        ie.addActionListener(ca);
         sp=new JButton("Schimbare parola");
        p.add(sp);
        sp.addActionListener(ca);
        add(p);
    }
    
    class ControlerAdministratie implements ActionListener{
        JFrame ff,spf;
        
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==ie){
                ff=new FormularFrame();
                ff.setSize(350,200);
                ff.setVisible(true);       
            }
            
            if(e.getSource()==sp){
                spf=new SchimbareParolaFrame();
                spf.setSize(250,100);
                spf.setVisible(true);
            }
        }
    }
}
