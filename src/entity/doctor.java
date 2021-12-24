package entity;

import javax.swing.JTable;
import project.Tools;

public class doctor extends mainData{

int doc_id;
String doc_name;
String doc_email;
String doc_salary;

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
    }
    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public void setDoc_email(String doc_email) {
        this.doc_email = doc_email;
    }

    public void setDoc_salary(String doc_salary) {
        this.doc_salary = doc_salary;
    }

    @Override
    public void add() {
        String insert="insert into doctor values("+doc_id+",'"+doc_name+"','"+doc_email+"',"+doc_salary+")";        
     boolean isadded= db.go.runNonQuery(insert);
        if(isadded)
            Tools.msgBox("added doctor!");
    }

    @Override
    public void update() {
        String update="update doctor set doc_name='"+doc_name+
                "',doc_email='"+doc_email+"',doc_sallary="+doc_salary+" where doc_id="+doc_id;
       boolean isupdated = db.go.runNonQuery(update);
        if(isupdated)
            Tools.msgBox("updated!");
    }

    @Override
    public void delete() {
        String delet="delete from doctor where doc_id= "+ doc_id;
        boolean isdeleted =db.go.runNonQuery(delet);
        if(isdeleted)
            Tools.msgBox("dleted!");
    }

    @Override
    public void getCustomRows(String statement, JTable table) {
        db.go.fillToJTable(statement, table);
    }



    
}
