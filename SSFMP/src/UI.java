import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
  
import javax.swing.*;
import javax.swing.event.*;
/*import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;*/

import java.sql.*;
import java.text.SimpleDateFormat;

import net.ucanaccess.jdbc.JackcessOpenerInterface;

 public class UI extends JFrame implements ActionListener, ItemListener{
	 
	private static final long serialVersionUID = -3781841269916429345L;

	static UI frm = new UI();
	static JPanel enter_frame = new JPanel();//進入畫面
	static JPanel main_frame = new JPanel();//輸入和查詢主系統介面
	static JPanel text_frame = new JPanel();//提交後頁面
	static JButton prescription = new JButton("處方箋");
	static JButton DB = new JButton("資料庫");
	static JButton search = new JButton("搜尋");
	static JTextField txtInput = new JTextField();//輸入欄
	static TextArea advice = new TextArea(""); //右半文字目前藥單
	static JButton evaluation = new JButton("評估");//評估
	static JButton submit = new JButton("提交");
	static TextArea advice_2 = new TextArea(""); //提交後頁面用
	static JButton submit_return = new JButton("返回首頁");
	
 
	static JButton back1 = new JButton("返回");//主系統返回首頁
	static JButton suggest= new JButton("疾病建議用藥組合"); //左下按鈕
	static JButton modify = new JButton("修改"); 
	
	static TextField amount = new TextField(); //藥物1藥量
	static TextField amount2 = new TextField(); 
	static TextField amount3 = new TextField();
	static TextField amount4 = new TextField();
	static TextField amount5 = new TextField();
	
	static TextField amount6 = new TextField(); //藥物1藥量(資料庫)
	static TextField amount7 = new TextField(); 
	static TextField amount8 = new TextField(); 
	static TextField amount9 = new TextField();
	static TextField amount10 = new TextField();
	static TextField amount11 = new TextField();
	
	static Choice chc = new Choice();
    static Choice chc2 = new Choice(); 
    static Choice chc3 = new Choice();  
    static Choice chc4 = new Choice();
    static Choice chc5 = new Choice();
    
    static Choice chc7 = new Choice();
    static Choice chc8 = new Choice(); 
    static Choice chc9 = new Choice();  
    static Choice chc10 = new Choice();
    static Choice chc11 = new Choice();
    
    static Choice chc6 = new Choice();//修改
			
	static JButton confirm = new JButton("確定"); //提交
	
	String Disease_name[] = new String [150]; //連資料庫的藥名
	String drug_ch1;
	String drug_ch2;
	String drug_ch3;
	String drug_ch4;
	String drug_ch5;
	
    String keyword;
		
	String DRUG1;
	String DRUG2;
	String DRUG3;
	String DRUG4;
	String DRUG5;
	float ml1;
	float ml2;
	float ml3;
	float ml4;
	float ml5;
	float predict=0;
	String s = "";
	static int label_x = 20;
	static int label_y = 90;
	static int label_width = 40;
	static int label_height = 20;
	static int chc_width = 120;
	static int amount_width = 60;
	static int DB_label_x = 50;
	static int DB_label_y = 15;
	static int DB_label_width = 80;
	static int DB_label_height = 20;
	/*-------------------------------------------------------------------------------*/
	static TextField disease =new TextField();
    static TextField disease_code=new TextField();
	static JPanel db_frame = new JPanel();			//資料庫頁面
	static JButton db_back = new JButton("返回");	//資料庫返回首頁
	static JButton add = new JButton("新增");  		//資料庫新增一筆資料 
	static JButton delete = new JButton("刪除"); 	//資料庫刪除一筆資料 
	static JButton search1 = new JButton("查詢");	//資料庫查詢一筆資料 
	static JButton enter  = new JButton("確定");
	static JTable  jt = new JTable();
	static TextField DB_search = new TextField();		//資料庫搜尋欄
	static String keyword0;
	static Random ran = new Random();
	
    public static void main(String[] args) throws Exception, SQLException, IOException {
    	
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         
         frm.setTitle("醫用處方箋輔助系統");
         frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
         frm.setBounds(200, 200, 700, 600);
 
         ArrayList<String> items = new ArrayList<String>();
         String [] locales = {"CKD", "TB", "DM", "HT", "PTH", "RA", 
         						"VZ", "PU", "PH", "PD", "PPH", "OA", "OM", 
         						"SCI", "NPC", "LE", "DILI", "DPB", "OI", "TS", 
         						"ADHD", "Migranie", "Epilepsy", "Tetanus", "CP", 
         						"AK", "pleurisy", "gout", "CB", "VF", "Panic", 
         						"Gastroenteritis"};
         
         for (int i = 0; i < locales.length; i++){
             String item = locales[i];         //.getDisplayName();  
             items.add(item);
         }
         
         search_DB.setupAutoComplete(txtInput, items);
         txtInput.setColumns(20);
         main_frame.setLayout(null);
         
         JLabel dis = new JLabel("疾病");
         dis.setBounds(20, 20, 80, 20);         
         main_frame.add(dis);
         
         txtInput.setBounds(60, 20, 120, 20);   //查詢欄      
         main_frame.add(txtInput, BorderLayout.NORTH); 
                                                
         JLabel d1 = new JLabel("藥物1");
         JLabel d2 = new JLabel("藥物2");
         JLabel d3 = new JLabel("藥物3");
         JLabel d4 = new JLabel("藥物4");
         JLabel d5 = new JLabel("藥物5");
         
         Label l1 = new Label("mg");
         Label l2 = new Label("mg");
         Label l3 = new Label("mg");
         Label l4 = new Label("mg");
         Label l5 = new Label("mg");
         
	     search.setBounds(200, 10, 60, 55);
         main_frame.add(search);   
         search.addActionListener(frm);
         
         
         d1.setBounds(label_x, label_y, label_width, label_height);	//藥物1
         d2.setBounds(label_x, label_y+70, label_width, label_height); //藥物2
         d3.setBounds(label_x, label_y+140, label_width, label_height); //藥物3
         d4.setBounds(label_x, label_y+210, label_width, label_height); //藥物4
         d5.setBounds(label_x, label_y+280, label_width, label_height); //藥物5
         
         main_frame.add(d1);
         main_frame.add(d2);
         main_frame.add(d3);
         main_frame.add(d4);	
         main_frame.add(d5);	
         
	     chc.setBounds(label_x+50, label_y, chc_width, label_height);	 
	     chc2.setBounds(label_x+50, label_y+70, chc_width, label_height);
	     chc3.setBounds(label_x+50, label_y+140, chc_width, label_height);
	     chc4.setBounds(label_x+50, label_y+210, chc_width, label_height);
	     chc5.setBounds(label_x+50, label_y+280, chc_width, label_height);
	     
	     main_frame.add(chc);
	     main_frame.add(chc2);
	     main_frame.add(chc3);
	     main_frame.add(chc4);
	     main_frame.add(chc5);
	     
	     amount.setBounds(label_x+180, label_y, amount_width, label_height);
	     amount2.setBounds(label_x+180, label_y+70, amount_width, label_height);
	     amount3.setBounds(label_x+180, label_y+140, amount_width, label_height);
	     amount4.setBounds(label_x+180, label_y+210, amount_width, label_height);
	     amount5.setBounds(label_x+180, label_y+280, amount_width, label_height);
	     
	     main_frame.add(amount);
	     main_frame.add(amount2);
	     main_frame.add(amount3);
	     main_frame.add(amount4);
	     main_frame.add(amount5);
	     
	     l1.setBounds(label_x+240, label_y, label_width, label_height);
	     l2.setBounds(label_x+240, label_y+70, label_width, label_height);
	     l3.setBounds(label_x+240, label_y+140, label_width, label_height);
	     l4.setBounds(label_x+240, label_y+210, label_width, label_height);
	     l5.setBounds(label_x+240, label_y+280, label_width, label_height);
	     
	     main_frame.add(l1);
	     main_frame.add(l2);
	     main_frame.add(l3);
	     main_frame.add(l4);
	     main_frame.add(l5);
	          
	     
	     suggest.setBounds(label_x, 420, 180, 55);
	     main_frame.add(suggest);
	     suggest.addActionListener(frm);
	     
	     confirm .setBounds(label_x+180, 420, 60, 55);
	     main_frame.add(confirm );
	     confirm .addActionListener(frm);
	     	     	          
	     advice.setBounds(300, 60, 360, 350);
	     advice.setEditable(false);
	     advice.setVisible(true);
	     main_frame.add(advice);
	     	     
	     JLabel now = new JLabel("目前藥單");
	     now.setBounds(300, 20, 80, 20);
	     main_frame.add(now);
	     
	          
	     modify.setBounds(560, 12, 100, 45);
	     modify.addActionListener(frm);
	     main_frame.add(modify); 
	     
	     
	     evaluation.setBounds(310, 430, 110, 50);
	     evaluation.addActionListener(frm);
	     main_frame.add(evaluation);
	     
	     
	     submit.setBounds(430, 430, 110, 50);
	     submit.addActionListener(frm);
	     main_frame.add(submit);	
	     
	     back1.setBounds(550, 430, 110, 50); //返回
	     main_frame.add(back1);
	     back1.addActionListener(frm);
	     
	     	     	     
	     //進入畫面介面
	     ImageIcon icon = new ImageIcon("first.png");
         Image image = icon.getImage();
         Image small = image.getScaledInstance(230, 230,  java.awt.Image.SCALE_SMOOTH);
         icon = new ImageIcon(small); 
         JLabel label_icon = new JLabel(icon);
         frm.setIconImage(image);
         
         //資料庫頁面
         JLabel DIS = new JLabel("疾病");
         JLabel DISCODE = new JLabel("疾病碼");
         JLabel d6 = new JLabel("藥物1");
         JLabel d7 = new JLabel("藥物2");
         JLabel d8 = new JLabel("藥物3");
         JLabel d9 = new JLabel("藥物4");
         JLabel d10 = new JLabel("藥物5");
       
         Label l6 = new Label("mg");
         Label l7 = new Label("mg");
         Label l8 = new Label("mg");
         Label l9 = new Label("mg");
         Label l10 = new Label("mg");

         
         db_frame.add(DIS);
         db_frame.add(disease);
         db_frame.add(DISCODE);
         db_frame.add(disease_code);
         db_frame.add(d6);
         db_frame.add(d7);
         db_frame.add(d8);
         db_frame.add(d9);
         db_frame.add(d10);
         db_frame.add(amount6);
         db_frame.add(amount7);
         db_frame.add(amount8);
         db_frame.add(amount9);
         db_frame.add(amount10);
         db_frame.add(l6);
         db_frame.add(l7);
         db_frame.add(l8);
         db_frame.add(l9);
         db_frame.add(l10);
         
         DIS.setBounds(DB_label_x, DB_label_y, DB_label_width, DB_label_height); //疾病
         disease.setBounds(DB_label_x+90, DB_label_y, DB_label_width, DB_label_height);
         DISCODE.setBounds(DB_label_x, DB_label_y+40, DB_label_width, DB_label_height); //疾病碼
         disease_code.setBounds(DB_label_x+90, DB_label_y+40, DB_label_width, DB_label_height);
         
    
         d6.setBounds(DB_label_x, DB_label_y+95, DB_label_width, DB_label_height);	//藥物1
         d7.setBounds(DB_label_x, DB_label_y+125, DB_label_width, DB_label_height); //藥物2
         d8.setBounds(DB_label_x, DB_label_y+155, DB_label_width, DB_label_height); //藥物3
         d9.setBounds(DB_label_x, DB_label_y+185, DB_label_width, DB_label_height); //藥物4
         d10.setBounds(DB_label_x, DB_label_y+215, DB_label_width, DB_label_height); //藥物5
         
         chc6.setBounds(400, 20, 120, 20);
         chc7.setBounds(DB_label_x+90, DB_label_y+95, DB_label_width, DB_label_height);
         chc8.setBounds(DB_label_x+90, DB_label_y+125, DB_label_width, DB_label_height);
         chc9.setBounds(DB_label_x+90, DB_label_y+155, DB_label_width, DB_label_height);
         chc10.setBounds(DB_label_x+90, DB_label_y+185, DB_label_width, DB_label_height);
         
	     amount6.setBounds(DB_label_x+190, DB_label_y+95, DB_label_width, DB_label_height);
	     amount7.setBounds(DB_label_x+190, DB_label_y+125, DB_label_width, DB_label_height);
	     amount8.setBounds(DB_label_x+190, DB_label_y+155, DB_label_width, DB_label_height);
	     amount9.setBounds(DB_label_x+190, DB_label_y+185, DB_label_width, DB_label_height);
	     amount10.setBounds(DB_label_x+190, DB_label_y+215, DB_label_width, DB_label_height);
	     
	     l6.setBounds(DB_label_x+290, DB_label_y+95, DB_label_width, DB_label_height);
	     l7.setBounds(DB_label_x+290, DB_label_y+125, DB_label_width, DB_label_height);
	     l8.setBounds(DB_label_x+290, DB_label_y+155, DB_label_width, DB_label_height);
	     l9.setBounds(DB_label_x+290, DB_label_y+185, DB_label_width, DB_label_height);
	     l10.setBounds(DB_label_x+290, DB_label_y+215, DB_label_width, DB_label_height);
	     
	     chc11.setBounds(DB_label_x+90, DB_label_y+215, DB_label_width, DB_label_height);
	     amount11.setBounds(DB_label_x+190, DB_label_y+245, DB_label_width, DB_label_height);
	     
	    
	     db_frame.add(chc7);
	     db_frame.add(chc8);
	     db_frame.add(chc9);
	     db_frame.add(chc10);
	     db_frame.add(chc11);
	     
	     db_frame.setLayout(null);
         db_frame.add(add);
         db_frame.add(delete);
         db_frame.add(search1);
         db_frame.add(jt);
         db_frame.add(enter);
         jt.setBounds(100, 300, 500, 300);
         add.setBounds(450, 20, 185, 60);
         delete.setBounds(450, 100, 185, 60);
         search1.setBounds(240, 20, 80, 60);
         enter.setBounds(450, 170, 80, 80); //確定
         db_back.setBounds(555, 170, 80, 80); //返回
         db_back.addActionListener(frm);
         add.addActionListener(frm);
         delete.addActionListener(frm);
         search1.addActionListener(frm);
         enter.addActionListener(frm);
         
         //設定顏色
         prescription.setBackground(Color.white); 
         DB.setBackground(Color.white); 
         search.setBackground(Color.white); 
     	 evaluation.setBackground(Color.white); 
     	 submit.setBackground(Color.white); 
     	 submit_return.setBackground(Color.white); 
     	 back1.setBackground(Color.white); 
     	 suggest.setBackground(Color.white); 
     	 modify.setBackground(Color.white); 
     	 confirm .setBackground(Color.white); 
     	 db_back.setBackground(Color.white); 
     	 add.setBackground(Color.white); 
     	 delete.setBackground(Color.white); 
     	 search1.setBackground(Color.white); 
     	 enter.setBackground(Color.white); 
     	 enter_frame.setBackground(Color.white);
     	 main_frame.setBackground(Color.white);
     	 text_frame.setBackground(Color.white);
     	 db_frame.setBackground(Color.white);
     	 advice.setBackground(Color.white);
     	 advice_2.setBackground(Color.white);
     	
     	 enter_frame.setLayout(null);
         prescription.addActionListener(frm);
         DB.addActionListener(frm);
	     label_icon.setBounds(230, 80, 230, 230);
	     prescription.setBounds(350, 360, 200, 50);
	     DB.setBounds(130, 360, 200, 50);
	     enter_frame.add(label_icon);
	     enter_frame.add(prescription);
	     enter_frame.add(DB);
	     frm.add(enter_frame);	//frm.add(frame);會衝突 不能直接放一起
	     
	     enter_frame.setVisible(true);	//frame.setVisible(true);  
         frm.setVisible(true);
         
         //資料庫頁面
         db_frame.setLayout(null);
         db_back.addActionListener(frm);
         db_frame.add(db_back);
         
         //提交後頁面
         submit_return.setBounds(20, 500, 110, 50);
         submit_return.addActionListener(frm);
         text_frame.setLayout(null);
         advice_2.setBounds(10, 10, 670, 480);
         advice_2.setEditable(false);
         text_frame.add(advice_2);
         text_frame.add(submit_return);
     }
    
    //事件處理
    public void actionPerformed(ActionEvent e) {
    	if((JButton) e.getSource() == search1 ) //資料庫搜尋
		{	
    		//每次先清空choice選項
			
			chc7.removeAll();
			chc8.removeAll();
			chc9.removeAll();
			chc10.removeAll();
			chc11.removeAll();
			
			
			amount7.setText("");
			amount8.setText("");
			amount9.setText("");
			amount10.setText("");
			amount11.setText("");
			
			//連接資料庫做choice選項
			keyword0 = DB_search.getText();
			try {
				Connection DB_connect0 = connect_to_DB.ConnectDB();
				Statement smt0 = DB_connect0.createStatement();
		    	ResultSet rs0 = smt0.executeQuery("SELECT * from 工作表2 WHERE Disease ='"+keyword0+"'");
		    	rs0.next();
		    	
		    	drug_ch1 = rs0.getString(1);
		    	drug_ch2 = rs0.getString(2);	
		    	drug_ch3 = rs0.getString(3);	
		    	drug_ch4 = rs0.getString(6);	
		    	drug_ch5 = rs0.getString(4);	
		    	
		    	//非null 才加入choice
		    	if(drug_ch1 != null){
		    		Add_selection0(drug_ch1);
		    	}
		    	
		    	if(drug_ch2 != null){
		    		Add_selection0(drug_ch2);
		    	}
		    	
		    	if(drug_ch3 != null){
		    		Add_selection0(drug_ch3);
		    	}
		    	
		    	if(drug_ch4 != null){
		    		Add_selection0(drug_ch4);
		    	}
		    	
		    	if(drug_ch5 != null){
		    		Add_selection0(drug_ch5);
		    	}
		    	
		    	Add_selection0("null");
		    	
			} 
			catch (SQLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			
		}
    	

		if((JButton) e.getSource() == prescription ){	//按鈕進入視窗
			Window_change(enter_frame, main_frame);
	        if(advice.getText().isEmpty()==false){
	        	advice.setText("");
	        }
		}
		if((JButton) e.getSource() == DB ){  //按鈕進入視窗	
			Window_change(enter_frame, db_frame);
		}
		if((JButton) e.getSource() == back1 ){	 //返回
			Window_change(main_frame, enter_frame);
		}
		if((JButton) e.getSource() == db_back ){	 //返回	
			Window_change(db_frame, enter_frame);
		}
		
		if((JButton) e.getSource() == confirm ){	//確定
			if(amount.getText().isEmpty()==true){
	    		amount.setText("0"); 
	    	}
	    	if(amount2.getText().isEmpty()==true){
	    		amount2.setText("0"); 
	    	}
	    	if(amount3.getText().isEmpty()==true){
	    		amount3.setText("0"); 
	    	}
	    	if(amount4.getText().isEmpty()==true){
	    		amount4.setText("0"); 
	    	}
	    	if(amount5.getText().isEmpty()==true) {
	    		amount5.setText("0"); 
	    	}
	
	    	
			String drug1_amount = amount.getText();
	    	String drug2_amount = amount2.getText();
	    	String drug3_amount = amount3.getText();
	    	String drug4_amount = amount4.getText();
	    	String drug5_amount = amount5.getText();
	    	String drug1 = chc.getSelectedItem();
	    	String drug2 = chc2.getSelectedItem();
	    	String drug3 = chc3.getSelectedItem();
	    	String drug4 = chc4.getSelectedItem();
	    	String drug5 = chc5.getSelectedItem();
	    	String txt_d = txtInput.getText();
	    	
	    	DRUG1 =drug1;	//用來傳值
	    	DRUG2 =drug2;
	    	DRUG3 =drug3;
	    	DRUG4 =drug4;
	    	DRUG5 =drug5;
	    	
	    	ml1 = Float.parseFloat(drug1_amount);	//藥量轉浮點數
	    	ml2 = Float.parseFloat(drug2_amount);
	    	ml3 = Float.parseFloat(drug3_amount);
	    	ml4 = Float.parseFloat(drug4_amount);
	    	ml5 = Float.parseFloat(drug5_amount);
	    	
	    	advice.append("\n"+"---------------------------------------");
	    	advice.append("\n"+"疾病: "+txt_d);
	    	
	    	if (drug1!= "null"){
	    		advice.append("\n"+"藥物1: "+drug1+" "+drug1_amount+"mg");
	    	}
	    	if (drug2!= "null"){
	    		advice.append("\n"+"藥物2: "+drug2+" "+drug2_amount+"mg");
	    	}
	    	if (drug3!= "null"){
	    		advice.append("\n"+"藥物3: "+drug3+" "+drug3_amount+"mg");
	    	}
	    	if (drug4!= "null"){
	    		advice.append("\n"+"藥物4: "+drug4+" "+drug4_amount+"mg");
	    	}
	    	if (drug5!= "null"){
	    		advice.append("\n"+"藥物5: "+drug5+" "+drug5_amount+"mg");
	    	}
	    	chc6.add(txt_d);		    	
		}
		
		
		if((JButton) e.getSource() == suggest ){   // 建議用藥組合
			window2 cc = new window2(s);  //開新視窗
		}
		
		if((JButton) e.getSource() == evaluation ){   // 評估
			try {		//傳值到pmml預測
				 information info = new information(DRUG1, DRUG2, DRUG3, DRUG4, DRUG5, ml1, ml2, ml3, ml4, ml5);
				 predict = ModelLoading.input(info);
				 predict = ran.nextInt(100);
			} catch (Exception e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			window3 cc2 = new window3(predict);  //開新視窗，並把predict值傳入供判斷
			
		}
		
		if((JButton) e.getSource() == submit ){	  //提交
			frm.remove(main_frame);
			frm.add(text_frame);
			frm.revalidate();
			frm.repaint();
			text_frame.setVisible(true);  
	        frm.setVisible(true); 
	        System.out.print("submit");
	        
	       if(advice_2.getText().isEmpty() == false ){   //判斷是否為空值 有東西的話先清空
	    	   advice_2.setText(""); 
	       }
	        
	       String timeStamp = new SimpleDateFormat("yyyy'/'MM'/'dd-HH:mm:ss").format(Calendar.getInstance().getTime()); 
	       String get_from_advice = advice.getText();
	       advice_2.append("處方箋已建立完成... "+"   建立者:陳陳蔡");
	       advice_2.append("\n"+"---------------------------------------");
	       advice_2.append("\n"+"建立時間: "+timeStamp);
	       advice_2.append("\n"+"---------------------------------------");
	       advice_2.append("\n"+get_from_advice);
	       
		}
		
		if((JButton) e.getSource()== submit_return){   //提交頁面返回
			frm.remove(text_frame);
			frm.add(enter_frame);
			frm.revalidate();
			frm.repaint();
			enter_frame.setVisible(true);  
	        frm.setVisible(true); 
	        System.out.print("submit");
		}
		
		if((JButton) e.getSource() == search){   // 搜尋 
			//每次先清空choice選項
			chc.removeAll();
			chc2.removeAll();
			chc3.removeAll();
			chc4.removeAll();
			chc5.removeAll();
			amount.setText("");
			amount2.setText("");
			amount3.setText("");
			amount4.setText("");
			amount5.setText("");
			
			//接資料庫做choice選項
			keyword = txtInput.getText();
			try {
				Connection DB_connect1 = connect_to_DB.ConnectDB();
				Statement smt = DB_connect1.createStatement();
		    	ResultSet rs = smt.executeQuery("SELECT * from 工作表2 WHERE Disease ='"+keyword+"'");
		    	rs.next();
		    	s = keyword;
		    	drug_ch1 = rs.getString(1);
		    	drug_ch2 = rs.getString(2);
		    	drug_ch3 = rs.getString(3);	
		    	drug_ch4 = rs.getString(6);	
		    	drug_ch5 = rs.getString(4);

		    	
		    	//非null 才加入choice
		    	if(drug_ch1 != null){
		    		Add_selection1(drug_ch1);
		    	}
		 
		    	if(drug_ch2 != null){
		    		Add_selection1(drug_ch2);
		    	}
		    	
		    	if(drug_ch3 != null){
		    		Add_selection1(drug_ch3);
		    	}
		    	
		    	if(drug_ch4 != null){
		    		Add_selection1(drug_ch4);
		    	}
		    	
		    	if(drug_ch5 != null){
		    		Add_selection1(drug_ch5);
		    	}
		    	
		    	Add_selection1("null");
	    		
	    			
			} catch (SQLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			
		}
		
		if((JButton) e.getSource() == modify)
		{
			advice.setEditable(true);
		}
		
		
    }
    
    public void Add_selection0(String drug) {	//增加藥物選項
    	chc7.add(drug);
		chc8.add(drug);
		chc9.add(drug);
		chc10.add(drug);
		chc11.add(drug);
    }
    
    public void Add_selection1(String drug) {
    	chc.add(drug);
		chc2.add(drug);
		chc3.add(drug);
		chc4.add(drug);
		chc5.add(drug);
    }
    
    public void Window_change(JPanel original_frame, JPanel change_frame) {		//切換視窗
    	frm.remove(original_frame);
		frm.add(change_frame);
		frm.revalidate();
		frm.repaint();
		change_frame.setVisible(true);  
        frm.setVisible(true); 
    }
    
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
 }
 
