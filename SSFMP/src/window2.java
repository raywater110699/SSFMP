import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class window2 extends JFrame 
{
	String[] Disease_name = new String [150];
	String drugname[] = new String[200];
	String drug_ch1, drug_ch2, drug_ch3, drug_ch4, drug_ch5 = "";
	String Name[] = new String[8];
	int count = 0;
	int non_null=0;
	
	private static final long serialVersionUID = 1L;
	
	public window2(String s) 
	 {
		super("建議用藥組合"); 
		setBounds(900, 200, 300, 200); 
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
		setVisible(true); 
		Container pn = getContentPane(); 
		try {
			connect_to_DB.ConnectDB();
			Statement smt = connect_to_DB.ConnectDB().createStatement();
	    	ResultSet rs = smt.executeQuery("SELECT * from 工作表1 WHERE Disease ='"+s+"'");
	    	
	    	Statement stmt = connect_to_DB.ConnectDB().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE); 
	    	ResultSet rset = stmt.executeQuery("SELECT * from 工作表1 WHERE Disease ='"+s+"'"); 
	    	ResultSetMetaData rsmd = rset.getMetaData(); 
	    	int columnCount = rsmd.getColumnCount();
	    	int E[]=new int[columnCount+1];
	    	
	    	while(rset.next()) {	    		
	    		non_null=0;
	    			for(int i=1; i<=columnCount; i++)
	    			{    		
	    				if(i!=1) {
	    					if(rset.getInt(i) != 0) {
	    							Name[non_null] = rsmd.getColumnName(i);
	    							E[i]=1;
	    							drugname[i-1] = Name[non_null];		
	    							non_null++;
	    					}
	    				}
	    				else{
	    					drugname[0] = "Disease";
	    					non_null++;
	    				}
	    			}
	    			count++;
	    	}		
	    	while(count>=0 ) {
	    		count--;
	    		rset.previous();
	    	}
	    	rset.next();
	    	for(int n=0; n<=columnCount-1; n++) {	
	    			if(E[n]==1) {
	    				JLabel L = new JLabel(drugname[n-1]);
	    				pn.add(L);
	    			}
	    			else if(n==0){
	    				JLabel L = new JLabel(drugname[0]);
	    				pn.add(L);    				
	    			}
	    		}
	    	
	    	System.out.print("\n");
	    	
	    	while(rs.next()) {			    		
	    			for(int col=1; col<=columnCount-1; col++)
	    			{
	    				if(col!=1) {
	    					if(rs.getInt(col) != 0) {	    					
	    							Disease_name[col] = rs.getString(col);
	    							JLabel L = new JLabel(Disease_name[col]);
	    							pn.add(L);
	    					}
	    					else if(E[col]==1) {
	    						JLabel L = new JLabel("0");
	    						pn.add(L);
	    					}
	    				}
	    				else {
	    					JLabel L = new JLabel(rs.getString(col));
	    					pn.add(L);
	    				}
	    			}		
	    			System.out.print("\n");
	    	 }	
	    	
	    	
	    	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	 }
}
