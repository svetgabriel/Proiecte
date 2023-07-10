package e.event;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FormularFrame extends JFrame{
    File f = new File("C:\\Users\\svetg\\Downloads\\E-Event\\Utilizatori");
    private JTextField tf1,tf2,tf3,tf4,tf5,tf6;
    private JButton a;
    private ControlerFormularFrame cff;
    private PrintWriter pwe;
    private Evenimente dateE;
    private  ArrayList<Object> evenimente=new ArrayList<>();
    private int i=0,j;
    
    void createFile(){
        if(!f.exists()){
            f.mkdirs();
        }
    }
    
    void addData(){
        
    }
    
    public FormularFrame(){
        super("Formular Eveniment");
       
         cff=new ControlerFormularFrame();
         JPanel p=new JPanel();
        p.setLayout(new GridLayout(7,2,0,0));
        p.add(new Label("Nume:"));
         tf1=new JTextField(10);
        p.add(tf1);
        p.add(new Label("Categorie:"));
         tf2=new JTextField(10);
        p.add(tf2);
        p.add(new Label("Data Eveniment:"));
         tf3=new JTextField(10);
        p.add(tf3);
        p.add(new Label("Loc:"));
         tf4=new JTextField(10);
        p.add(tf4);
        p.add(new Label("Pret:"));
         tf5=new JTextField(10);
        p.add(tf5);
        p.add(new Label("Data vanzarilor de bilete:"));
         tf6=new JTextField(10);
        p.add(tf6);
         a=new JButton("Adaugare");
        p.add(a);
        a.addActionListener(cff);
        add(p);
    
     addWindowListener(new WindowAdapter(){  
     @Override
     public void windowClosing(WindowEvent e){ //ce e aici se executa cand inchizi panoul asociat clasei;
            try{                
                    pwe=new PrintWriter(new FileWriter("Evenimente.txt",true));
                    for(j=0;j<i;j++)
               pwe.println(evenimente.get(j));
               pwe.flush();
                 }catch(IOException io){
                io.printStackTrace();
                 }
     dispose();
           }  
       });
    }
    class ControlerFormularFrame implements ActionListener{     
        
        @Override
        public void actionPerformed(ActionEvent e){
           if(e.getSource()==a){  
               if(tf1.getText().equals("") || tf2.getText().equals("") || tf3.getText().equals("") || tf4.getText().equals("") || tf5.getText().equals("") || tf6.getText().equals("")){
                  JOptionPane.showMessageDialog(null,"Formularul trebuie completat!","Informatie",JOptionPane.INFORMATION_MESSAGE);
               }else{   
                  dateE=new Evenimente(tf1.getText(),tf2.getText(),tf3.getText(),tf4.getText(),tf5.getText(),tf6.getText());
                  evenimente.add(i,dateE); 
                  i++;
               }
           }
        }
    }
}