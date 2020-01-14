import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
