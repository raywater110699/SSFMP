import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class connect_to_DB {

public static Connection ConnectDB() throws SQLException {
    	
    	//動態配置DB位置
    	String path = System.getProperty("mydir");
        if(path == null){
            System.setProperty("mydir", System.getProperty("user.dir"));
        }
       
        String  pathxml=System.getProperty("mydir")+"\\DRUGG.accdb";	//DB位置
        
    	try 
    	{
    		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
    	}catch(ClassNotFoundException e) 
    	{
    		System.out.println("Driver loading failed!");
    	}
    	Connection con = DriverManager.getConnection("jdbc:ucanaccess://"+pathxml);
    	return con;
    }



}
