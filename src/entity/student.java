
package entity;

import javax.swing.JTable;
import project.Tools;

public class student extends mainData{

    String stu_id;
    String stu_name;
    String stu_email;
    String stu_bdate;
    String ayear;

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }
    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }
    public void setStu_email(String stu_email) {
        this.stu_email = stu_email;
    }
    public void setStu_bdate(String stu_bdate) {
        this.stu_bdate = stu_bdate;
    }
    public void setAyear(String ayear) {
        this.ayear = ayear;
    }

    @Override
    public void add() {
           String insert="insert into student values ("+
                   stu_id+","+"'"+stu_name+"','"+stu_email+"','"+stu_bdate+"','"+ayear+"');";
           boolean isAdd=db.go.runNonQuery(insert);
           if(isAdd)
               Tools.msgBox("student added !");
           else
               Tools.msgBox("invalid add student !");
    }

    @Override
    public void update() {

      String update="update student set stu_name='"+stu_name+"',"
              + "stu_email='"+stu_email+
              "',stu_bdate='"+stu_bdate+"',Ayear='"+ayear+"'where stu_id="+stu_id
              ;        
         boolean isUpdated=db.go.runNonQuery(update);
         if(isUpdated)
             Tools.msgBox("inforamtion updated !");
         else
             Tools.msgBox("inforamtion not updated !");
    }

    @Override
    public void delete() {
        String delet="delete from student where stu_id='"+stu_id+"'";
        boolean deleted=db.go.runNonQuery(delet);
        if(deleted)
            Tools.msgBox("deleted!");
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        db.go.fillToJTable(statement, table);
    }

}
