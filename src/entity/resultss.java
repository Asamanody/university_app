
package entity;

import javax.swing.JTable;
import project.Tools;

public class resultss extends mainData{

    String stu_name;
    int stu_id;
    String degree;
    String crs_id;
    float mark;
    @Override
    public void add() {
        String insert="insert into degree values('"+degree+"',"+mark+","+stu_id+","+crs_id+")";
        boolean isInserted=db.go.runNonQuery(insert);
         if(isInserted)
         Tools.msgBox("inforamtion added !");
    }

    @Override
    public void update() {
        String update="update results set degree='"+degree+"',mark="+mark;
        boolean isUpdated=db.go.runNonQuery(update);
         if(isUpdated)
         Tools.msgBox("inforamtion updated !");
    }
/*    @Override
    public void getAllRows(JTable table) {
        String select="select stu_name,c_name,degree,mark from student,degree,course where degree.stu_id=student.stu_id and course.c_id=degree.c_id;";
        getCustomRows(select, table);
    }
  */
    @Override
    public void getCustomRows(String statement, JTable table) {
    db.go.fillToJTable(statement, table);
    }
}
