package e.event;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ServerFrame extends JFrame{
    private JButton acces;
    private JTextField tf;
    private ControlerServerFrame csf;
    private ParolaAdministrator parola;
    
    public ServerFrame(){
        super("Server");
         JPanel p=new JPanel();
        csf=new ControlerServerFrame();
        
        p.add(new Label("Parola:"));
         tf=new JTextField(10);
        p.add(tf);
         acces=new JButton("Acces");
        p.add(acces);
        acces.addActionListener(csf);
        add(p);
    }
    
    class ControlerServerFrame implements ActionListener{
        JFrame ad;
        @Override
      public void actionPerformed(ActionEvent e){
          parola=new ParolaAdministrator();
                if(e.getSource()==acces && parola.Comparatie(tf.getText())==true){
                    ad=new AdministrareFrame();
                    ad.setSize(300,100);
                    ad.setVisible(true);
                }else{
                    tf.setText(null);
                    JOptionPane.showMessageDialog(null, "Parola gresita!","Informatie", JOptionPane.INFORMATION_MESSAGE);
                }

      }
    }
}