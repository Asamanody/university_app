/*
This classes explaining in the following lectures
(119, 126, 134,138, 139, 140, 141, 142, 143, 144,
                         145, 146, 147, 148, 149)
 */
package project;

import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class Tools {

    public static void msgBox(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static void openForm(JFrame form,String fname) {
        try {
            form.setLocationRelativeTo(null);
            Image img = ImageIO.read(Tools.class.getResource("emp.png")); //set icom for fram
            form.setIconImage(img);
            form.setTitle("Universty System"+fname);
            form.setDefaultCloseOperation(EXIT_ON_CLOSE);
            form.setVisible(true);
        } catch (IOException ex) {
            msgBox(ex.getMessage());
        }
    }

    public static void clearText(Container form) {
        for (Component c : form.getComponents()) {
            if (c instanceof JTextField) {
                JTextField txt = (JTextField) c;
                txt.setText("");
            } else if (c instanceof Container) {
                clearText((Container) c);
            }
        }
    }
    public class Table {

        public int columns;
        public Object[][] Items;

        public Table(int columns) {
            this.columns = columns;
            Items = new Object[0][columns];
        }

        public void addNewRow(Object row[]) {
            //الاحتفاظ بالعناصر القديمة داخل متغير مؤقت
            Object TempItems[][] = Items;
            //زيادة المتغير الاساسي بعنصر اضافي
            Items = new Object[Items.length + 1][columns];
            //تعبئة العناصر القديمة في العنصر الاساسي
            for (int x = 0; x < TempItems.length; x++) {
                Items[x] = TempItems[x];
            }
            //اضافة الصف الجديد للعنصر الاساسي
            Items[Items.length - 1] = row;
        }

        public void printItems() {
            for (Object objs[] : Items) {
                for (Object obj : objs) {
                    System.out.print(obj + " ; ");
                }
                System.out.println();
            }
        }

        public void editRow(int rowIndex, int columnIndex, Object newData) {
            Items[rowIndex][columnIndex] = newData;
        }

    }

}
