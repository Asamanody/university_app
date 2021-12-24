
package entity;

import javax.swing.JTable;
import project.Tools;

public class department extends mainData{
    int dep_no;
    String dep_name;
    String doc_id;

    public void setDep_no(int dep_no) {
        this.dep_no = dep_no;
    }
    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }
    public void setDoc_id(String doc_id) {
        this.doc_id = doc_id;
    }

    @Override
    public void add() {
        String insert="insert into department values ("+dep_no+",'"+dep_name+"','"+doc_id+"')";
        boolean isinserted=db.go.runNonQuery(insert);
        if(isinserted)
            Tools.msgBox("added department!");
    }

    @Override
    public void update() {
        String update="update departmet set dep_name='"+dep_name+"',doc_id='"+doc_id+"'where dep_no="+dep_no;
        boolean isupdated=db.go.runNonQuery(update);
        if(isupdated)
            Tools.msgBox("updated!");
    }

    @Override
    public void delete() {
        String delet="delete from department where dep_no="+dep_no;
        boolean isdeleted=db.go.runNonQuery(delet);
        if(isdeleted)
            Tools.msgBox("deleted!");
    }
    @Override
    public void getCustomRows(String statement, JTable table) {
       db.go.fillToJTable(statement, table);
    }
}
