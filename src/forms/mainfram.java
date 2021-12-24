package forms;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import project.Tools;

public class mainfram extends JFrame{
    public mainfram()
    {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(300, 300);
    
    Panel p=new Panel();
    p.setSize(300,300);
    p.setBackground(Color.WHITE);
    
     
    JButton stu=new JButton("Students");
    JButton btn_doc=new JButton("Doctors");
    JButton btn_dep=new JButton("departments");
    JButton btn_crs=new JButton("Courses");
    
    add(p);
    
    p.add(stu);
    p.add(btn_doc);
    p.add(btn_dep);
    p.add(btn_crs);
    p.setSize(250,250);
    p.setLayout(new GridLayout(2,2));
   
   
    stu.addActionListener((ActionListener) new Action() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            Tools.openForm(new students(), " students");
        }
    });
    btn_doc.addActionListener(new Action() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            Tools.openForm(new doctors(), " doctors");     
        }
    });
    btn_dep.addActionListener(new Action() {
        @Override
        public void actionPerformed(ActionEvent e) {
           setVisible(false);
            Tools.openForm(new departmentt(), " departments");
        }
    });
     btn_crs.addActionListener(new Action() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            Tools.openForm(new coursee(), " courses");
        }
    });
    } 
    
    static abstract class Action implements ActionListener{
        public  void actionPerformed()
        {
           
        }
    }
}