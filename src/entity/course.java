
package entity;

import javax.swing.JTable;
import project.Tools;

public class course extends mainData{
  String c_id;
  String c_name; 
  int dep_no;
  String doc_id;

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }
    public void setName(String c_name) {
        this.c_name = c_name;
    }
    public void setDep_no(int dep_no) {
        this.dep_no = dep_no;
    }
    public void setDoc_id(String doc_id) {
        this.doc_id = doc_id;
    }

    @Override
    public void add() {
       String insert="insert into course values ('"+c_id+"','"+c_name+"',"+dep_no+",'"+doc_id+"')";
       boolean isinserted=db.go.runNonQuery(insert);
       if(isinserted)
           Tools.msgBox("added course!");
    }

    @Override
    public void update() {
        String update="update course set c_name='"+c_name+"',dep_no="+dep_no+",doc_id='"+doc_id+"'";
        boolean isupdated=db.go.runNonQuery(update);
        if(isupdated)
            Tools.msgBox("updated!");
    }

    @Override
    public void delete() {
         String delet="delete from course where c_id='"+c_id+"'";
         boolean isdeleted=db.go.runNonQuery(delet);
         if(isdeleted)
             Tools.msgBox("deleted!");
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        db.go.fillToJTable(statement, table);
    }
  
    
}
