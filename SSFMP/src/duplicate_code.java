import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;

public class duplicate_code extends UI{
	public static void Add_selection0(String drug) {	//�W�[�Ī��ﶵ
    	chc7.add(drug);
		chc8.add(drug);
		chc9.add(drug);
		chc10.add(drug);
		chc11.add(drug);
    }
    
    public static void Add_selection1(String drug) {
    	chc.add(drug);
		chc2.add(drug);
		chc3.add(drug);
		chc4.add(drug);
		chc5.add(drug);
    }
    
    public static void Window_change(JPanel original_frame, JPanel change_frame) {		//��������
    	frm.remove(original_frame);
		frm.add(change_frame);
		frm.revalidate();
		frm.repaint();
		change_frame.setVisible(true);  
        frm.setVisible(true); 
    }
    
    public static void getDrug(ResultSet RS) throws SQLException {		//��o�Ī�string
    	drug_ch1 = RS.getString(1);
    	drug_ch2 = RS.getString(2);
    	drug_ch3 = RS.getString(3);	
    	drug_ch4 = RS.getString(6);	
    	drug_ch5 = RS.getString(4);
    }
}
