package e.event;
import javax.swing.*;
import java.awt.event.*;
//import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
//(JFrame object).pack() pentru ca panoul sa aiba automat dimensiunea potrivita pentru continut;
//(JFrame object).setDefaultCloseOperation(EXIT_ON_CLOSE); pentru a opri tot programul la inchiderea unui frame;
public class EEvent extends JFrame{
    private JButton b1,b2,b3; 
    private ControlerButoane cb;
    
    public EEvent(){
       super("E-Event");
       
        JPanel p=new JPanel();
        cb=new ControlerButoane();
        
        b1=new JButton("Creare cont");
       p.add(b1);
       b1.addActionListener(cb);
        b2=new JButton("Autentificare");
       p.add(b2);
       b2.addActionListener(cb);
        b3=new JButton("Server");
       p.add(b3);
       b3.addActionListener(cb);
       
       add(p);
    }  
    
    class ControlerButoane implements ActionListener{
        private JFrame a, b, c;
        
        @Override
        public void actionPerformed(ActionEvent e){
            if (e.getSource()==b1){
               if (a==null) a=new ConectareFrame();
                   a.setSize(300,160);
                   a.setVisible(true);
            }
            
            if (e.getSource()==b2){
                   b=new AutentificareFrame();
                   b.setSize(300,120);
                   b.setVisible(true);
            }
            
            if (e.getSource()==b3){
                   c=new ServerFrame();
                   c.setSize(250,100);
                   c.setVisible(true);
            } 
        } 
    }     
    public static void main(String[] args) {
     JFrame s=new EEvent();
     s.setSize(500,75);
     s.setVisible(true);
     s.setDefaultCloseOperation(EXIT_ON_CLOSE);  
    /*
     JFrame f=new NotificariFrame();
     f.setSize(300,120);
     f.setVisible(true);
     */
    }  
}
