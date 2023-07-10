package e.event;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SchimbareParolaFrame extends JFrame{
        private JButton sal;
        private JTextField tf;
        private ControlerSchimbareParola sp;
        private FileWriter pwp;
        
    public SchimbareParolaFrame(){
        super("Schimbare Parola");
        
         JPanel p=new JPanel();
         sp=new ControlerSchimbareParola();
       //p.setLayout(new GridLayout(2,2,0,0));
        p.add(new Label("Parola noua:"));
         tf=new JTextField(10);
        p.add(tf);
        
         sal=new JButton("Salvare");
        p.add(sal);
        sal.addActionListener(sp);
        add(p);
}
 
class ControlerSchimbareParola implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==sal){
            try {
                pwp=new FileWriter("ParolaServer.txt");
                pwp.write(tf.getText());
                pwp.close();
            } catch (IOException ex) {
                Logger.getLogger(SchimbareParolaFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
   JOptionPane.showMessageDialog(null, "Parola a fost schimbata.","Informatie", JOptionPane.INFORMATION_MESSAGE);
       setVisible(false);
        }
    } 
    }
}