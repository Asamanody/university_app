
package forms;

import controls.JMyButton;
import controls.JTextBox;
import db.go;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import project.Tools;

public class login extends JFrame{
    public login(){
        
        setSize(300, 210); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Panel p=new Panel(); 
        p.setSize(300,370);
        Panel p1=new Panel(); //label user & text user
        Panel p2=new Panel();
        Panel p3=new Panel();
        Panel p4=new Panel();

        p.setSize(300, 370);
        
        p1.setSize(100,70);
        p2.setSize(100,70);
        JLabel usr=new JLabel("UserName:");
        JLabel pss=new JLabel("PassWord:");
        
        usr.setFont(new java.awt.Font("Tahoma", 0, 12));
        pss.setFont(new java.awt.Font("Tahoma", 0, 12));
        usr.setForeground(new java.awt.Color(0, 0, 204));
        pss.setForeground(new java.awt.Color(0, 0, 204));

        JTextField user=new JTextBox(10);
        JTextField pass=new JTextBox(10);
         
        user.setText("");
        pass.setText("");
        
        JLabel img=new JLabel();
        img.setSize(300,300);
        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forms/emp.png")));
        
        JMyButton login=new JMyButton("LogIn");
        
        p1.add(usr);
        p1.add(user);
        p1.setSize(300,70);
        p1.setLayout(new GridLayout(1, 2,5,0));

        p2.add(pss);
        p2.add(pass);
        p2.setLayout(new GridLayout(1, 2,5,0));
        p2.setSize(300,70);
        
        p3.add(p1);
        p3.add(p2);
        p3.setLayout(new GridLayout(2, 1,10,20));
        
        p.add(img,BorderLayout.NORTH);
        
        p.add(p3,BorderLayout.CENTER);
        add(p);
        p.add(login,BorderLayout.SOUTH);
        
        login.addActionListener(new Action() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  if (("".equals(user.getText()) && "".equals(pass.getText())))
                        {
                            setVisible(false);
                            Tools.openForm(new guestform(),": hello our Guest.");
                        }
                  else if((!"".equals(user.getText()) && !"".equals(pass.getText())))
                        {
                            boolean check=go.checkUserAndPass(user.getText(),pass.getText());
                            if(check)
                            {
                                setVisible(false);
                                Tools.openForm(new mainfram(),"");
                            }else{
                                 Tools.msgBox("username or password incorrect !");
                                 user.setText("");
                                 pass.setText("");
                                 user.requestFocus();
                             }
                        }
            }
        });
        
        
        
    }
      static abstract class Action implements ActionListener{
        public  void actionPerformed()
        {
           
        }

        
    }
}
