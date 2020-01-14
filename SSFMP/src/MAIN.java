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

 public class MAIN extends JFrame implements ActionListener,ItemListener{
	 
	private static final long serialVersionUID = -3781841269916429345L;

	static MAIN frm = new MAIN();
	static JPanel frame = new JPanel();//輸入和查詢主系統介面
	static JPanel frame_2 = new JPanel();//提交後頁面
	static JPanel f1 = new JPanel();//進入畫面
	static JButton e1 = new JButton("處方箋");
	static JButton e2 = new JButton("資料庫");
	static JButton search = new JButton("搜尋");
	static JTextField txtInput = new JTextField();//輸入欄
	static TextArea advice = new TextArea(""); //右半文字目前藥單
	static JButton evaluation = new JButton("評估");//評估
	static JButton submit = new JButton("提交");
	static TextArea advice_2 = new TextArea(""); //提交後頁面用
	static JButton submit_r = new JButton("返回首頁");
	
 
	static JButton back1 = new JButton("返回");//主系統返回首頁
	static JButton j2= new JButton("疾病建議用藥組合"); //左下按鈕
	static JButton modify = new JButton("修改"); 
	
	static TextField amount = new TextField(); //藥物1藥量
	static TextField amount2 = new TextField(); 
	static TextField amount3 = new TextField();
	static TextField amount4 = new TextField();
	static TextField amount5 = new TextField();
	
	static TextField amount7 = new TextField(); //藥物1藥量(資料庫)
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
			
	static JButton j3= new JButton("確定"); //提交
	
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
	String s=""; 
	/*-------------------------------------------------------------------------------*/
	static TextField t =new TextField();
    static TextField t2=new TextField();
	static JPanel db_frame = new JPanel();			//資料庫頁面
	static JButton db_back = new JButton("返回");	//資料庫返回首頁
	static JButton add = new JButton("新增");  		//資料庫新增一筆資料 
	static JButton delete = new JButton("刪除"); 	//資料庫刪除一筆資料 
	static JButton search1 = new JButton("查詢");	//資料庫查詢一筆資料 
	static JButton enter  = new JButton("確定");
	static JTable  jt = new JTable();
	static TextField text1 = new TextField();		//資料庫搜尋欄
	static String keyword0;
	static Random ran = new Random();
	
    public static void main(String[] args) throws Exception, SQLException, IOException {
    	
    	
    		    	
    	
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         
         frm.setTitle("醫用處方箋輔助系統");
         frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
         frm.setBounds(200, 200, 700, 600);
 
         ArrayList<String> items = new ArrayList<String>();
         String [] locales = {"CKD", "TB", "DM", "HT", "PTH", "RA",
         						"VZ","PU","PH","PD","PPH","OA","OM",
         						"SCI","NPC","LE","DILI","DPB","OI","TS",
         						"ADHD","Migranie","Epilepsy","Tetanus","CP",
         						"AK","pleurisy","gout","CB","VF","Panic",
         						"Gastroenteritis"};
         
         for (int i = 0; i < locales.length; i++) 
         {
             String item = locales[i];         //.getDisplayName();  
             items.add(item);
         }
         
         search_DB.setupAutoComplete(txtInput, items);
         txtInput.setColumns(20);
         frame.setLayout(null);
         
         JLabel dis = new JLabel("疾病");
         dis.setBounds(20,20,80,20);         
         frame.add(dis);
         
         txtInput.setBounds(60, 20, 120, 20);   //查詢欄      
         frame.add(txtInput, BorderLayout.NORTH); 
                                                
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
         frame.add(search);   
         search.addActionListener(frm);
         
         
         d1.setBounds(20, 90, 40, 20);	//藥物1
	     frame.add(d1);
	     chc.setBounds(70, 90, 120, 20);	     
	     frame.add(chc);
	     amount.setBounds(200, 90, 60, 20);
	     frame.add(amount);
	     l1.setBounds(260, 90, 40, 20);
	     frame.add(l1);
	     
	     d2.setBounds(20, 160, 40, 20); //藥物2
	     frame.add(d2);	
	     chc2.setBounds(70, 160, 120, 20);
	     frame.add(chc2);
	     amount2.setBounds(200, 160, 60, 20);
	     frame.add(amount2);
	     l2.setBounds(260, 160, 40, 20);
	     frame.add(l2);
	     	     	     
	     d3.setBounds(20, 230, 40, 20); //藥物3
	     frame.add(d3);	
	     chc3.setBounds(70, 230, 120, 20);
	     frame.add(chc3);
	     amount3.setBounds(200, 230, 60, 20);
	     frame.add(amount3);
	     l3.setBounds(260, 230, 40, 20);
	     frame.add(l3);
	     
	     d4.setBounds(20, 300, 40, 20); //藥物4
	     frame.add(d4);	
	     chc4.setBounds(70, 300, 120, 20);
	     frame.add(chc4);
	     amount4.setBounds(200, 300, 60, 20);
	     frame.add(amount4);
	     l4.setBounds(260, 300, 40, 20);
	     frame.add(l4);
	     
	     d5.setBounds(20, 370, 40, 20); //藥物5
	     frame.add(d5);	
	     chc5.setBounds(70, 370, 120, 20);
	     frame.add(chc5);
	     amount5.setBounds(200, 370, 60, 20);
	     frame.add(amount5);
	     l5.setBounds(260, 370, 40, 20);
	     frame.add(l5);
	          
	     j2.setBounds(20, 420, 180, 55);
	     frame.add(j2);
	     j2.addActionListener(frm);
	     
	     j3.setBounds(200, 420, 60, 55);
	     frame.add(j3);
	     j3.addActionListener(frm);
	     	     	          
	     advice.setBounds(300, 60, 360, 350);
	     advice.setEditable(false);
	     advice.setVisible(true);
	     frame.add(advice);
	     	     
	     JLabel now = new JLabel("目前藥單");
	     now.setBounds(300, 20, 80, 20);
	     frame.add(now);
	     
	     chc6.setBounds(400, 20, 120, 20);
	         
	     modify.setBounds(560, 12, 100,45);
	     modify.addActionListener(frm);
	     frame.add(modify); 
	     
	     
	     evaluation.setBounds(310, 430, 110, 50);
	     evaluation.addActionListener(frm);
	     frame.add(evaluation);
	     
	     
	     submit.setBounds(430, 430, 110, 50);
	     submit.addActionListener(frm);
	     frame.add(submit);	
	     
	     back1.setBounds(550, 430, 110, 50); //返回
	     frame.add(back1);
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
         TextField amount6 = new TextField();
         TextField amount7 = new TextField();
         TextField amount8 = new TextField();
         TextField amount9 = new TextField();
         TextField amount10 = new TextField();
         Label l6 = new Label("mg");
         Label l7 = new Label("mg");
         Label l8 = new Label("mg");
         Label l9 = new Label("mg");
         Label l10 = new Label("mg");

         
         db_frame.add(DIS);
         db_frame.add(t);
         db_frame.add(DISCODE);
         db_frame.add(t2);
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
         
         DIS.setBounds(50, 15, 80, 25); //疾病
         t.setBounds(140, 15, 80, 25);
         DISCODE.setBounds(50,65,80,25); //疾病碼
         t2.setBounds(140,60,80, 25);
         d6.setBounds(50, 110, 80, 20);	//藥物1
	     amount6.setBounds(240, 110, 80, 20);
	     l6.setBounds(340, 110, 80, 20);
	     d7.setBounds(50,140,80,20); //藥物2
	     chc7.setBounds(140, 110, 80, 20);
	     amount7.setBounds(240,140,80,20);
	     l7.setBounds(340, 140, 80, 20);
	     d8.setBounds(50,170,80,20); //藥物3
	     chc8.setBounds(140, 140, 80, 20);
	     amount8.setBounds(240,170,80,20);
	     l8.setBounds(340,170,80,20);
	     d9.setBounds(50,200,80,20); //藥物4
	     chc9.setBounds(140, 170, 80, 20);
	     amount9.setBounds(240,200,80,20);
	     l9.setBounds(340,200,80,20);
	     d10.setBounds(50,230,80,20); //藥物5
	     chc10.setBounds(140, 200, 80, 20);
	     amount10.setBounds(240,230,80,20);
	     l10.setBounds(340,230,80,20);
	     chc11.setBounds(140, 230, 80, 20);
	     amount11.setBounds(240,260,80,20);
	     
	    
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
         enter.setBounds(450,170,80, 80); //確定
         db_back.setBounds(555, 170, 80, 80); //返回
         db_back.addActionListener(frm);
         add.addActionListener(frm);
         delete.addActionListener(frm);
         search1.addActionListener(frm);
         enter.addActionListener(frm);
         
         e1.setBackground(Color.white); 
         e2.setBackground(Color.white); 
         search.setBackground(Color.white); 
     	 evaluation.setBackground(Color.white); 
     	 submit.setBackground(Color.white); 
      	 submit_r.setBackground(Color.white); 
     	 back1.setBackground(Color.white); 
     	 j2.setBackground(Color.white); 
     	 modify.setBackground(Color.white); 
     	 j3.setBackground(Color.white); 
     	 db_back.setBackground(Color.white); 
     	 add.setBackground(Color.white); 
     	 delete.setBackground(Color.white); 
     	 search1.setBackground(Color.white); 
     	 enter.setBackground(Color.white); 
     	 f1.setBackground(Color.white);
     	 frame.setBackground(Color.white);
     	 frame_2.setBackground(Color.white);
     	 db_frame.setBackground(Color.white);
     	 advice.setBackground(Color.white);
     	 advice_2.setBackground(Color.white);
     	
         f1.setLayout(null);
	     e1.addActionListener(frm);
	     e2.addActionListener(frm);
	     label_icon.setBounds(230, 80, 230,230);
	     e1.setBounds(350, 360, 200,50);
	     e2.setBounds(130, 360, 200,50);
	     f1.add(label_icon);
	     f1.add(e1);
	     f1.add(e2);
	     frm.add(f1);	//frm.add(frame);會衝突 不能直接放一起
	     
	     f1.setVisible(true);	//frame.setVisible(true);  
         frm.setVisible(true);
         
         //資料庫頁面
         db_frame.setLayout(null);
         db_back.addActionListener(frm);
         db_frame.add(db_back);
         
         //提交後頁面
         submit_r.setBounds(20, 500, 110, 50);
         submit_r.addActionListener(frm);
         frame_2.setLayout(null);
         advice_2.setBounds(10, 10, 670, 480);
         advice_2.setEditable(false);
         frame_2.add(advice_2);
         frame_2.add(submit_r);
     }
    
    
    
    
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
			
			//接資料庫做choice選項
			keyword0 = text1.getText();
			try {
				connect_to_DB.ConnectDB();
				Statement smt0 = connect_to_DB.ConnectDB().createStatement();
		    	ResultSet rs0 = smt0.executeQuery("SELECT * from 工作表2 WHERE Disease ='"+keyword0+"'");
		    	rs0.next();
		    	
		    	drug_ch1 = rs0.getString(1);
		    	drug_ch2 = rs0.getString(2);	
		    	drug_ch3 = rs0.getString(3);	
		    	drug_ch4 = rs0.getString(6);	
		    	drug_ch5 = rs0.getString(4);	
		    	
		    	//非null 才加入choice
		    	if(drug_ch1 != null)
		    	{
		    		chc7.add(drug_ch1);
		    		chc8.add(drug_ch1);
		    		chc9.add(drug_ch1);
		    		chc10.add(drug_ch1);
		    		chc11.add(drug_ch1);
		    	}
		    	
		    	
		    	if(drug_ch2 != null)
		    	{
		    		chc7.add(drug_ch2);
		    		chc8.add(drug_ch2);
		    		chc9.add(drug_ch2);
		    		chc10.add(drug_ch2);
		    		chc11.add(drug_ch2);
		    	}
		    	
		    	if(drug_ch3 != null)
		    	{
		    		chc7.add(drug_ch3);
		    		chc8.add(drug_ch3);
		    		chc9.add(drug_ch3);
		    		chc10.add(drug_ch3);
		    		chc11.add(drug_ch3);
		    	}
		    	
		    	if(drug_ch4 != null)
		    	{
		    		chc7.add(drug_ch4);
		    		chc8.add(drug_ch4);
		    		chc9.add(drug_ch4);
		    		chc10.add(drug_ch4);
		    		chc11.add(drug_ch4);
		    	}
		    	
		    	if(drug_ch5 != null)
		    	{
		    		chc7.add(drug_ch5);
		    		chc8.add(drug_ch5);
		    		chc9.add(drug_ch5);
		    		chc10.add(drug_ch5);
		    		chc11.add(drug_ch5);
		    	}
		    	
		    	chc7.add("null");
	    		chc8.add("null");
	    		chc9.add("null");
	    		chc10.add("null");
	    		chc11.add("null");
		    
	    		
	    		
			} catch (SQLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			
		}
    	

		if((JButton) e.getSource() == e1 ) //按鈕進入視窗
		{			
			frm.remove(f1);
			frm.add(frame);
			frm.revalidate();
			frm.repaint();
			frame.setVisible(true);  
	        frm.setVisible(true); 
	        if(advice.getText().isEmpty()==false)
	        {
	        	advice.setText("");
	        }
		}
		if((JButton) e.getSource() == e2 ) //按鈕進入視窗
		{			
			frm.remove(f1);
			frm.add(db_frame);
			frm.revalidate();
			frm.repaint();
			db_frame.setVisible(true);  
	        frm.setVisible(true);  
		}
		if((JButton) e.getSource() == back1 ) //返回
		{			
			frm.remove(frame);
			frm.add(f1);
			frm.revalidate();
			frm.repaint();
			f1.setVisible(true);  
	        frm.setVisible(true); 
	        System.out.print("back");
		}
		if((JButton) e.getSource() == db_back ) //返回
		{			
			frm.remove(db_frame);
			frm.add(f1);
			frm.revalidate();
			frm.repaint();
			f1.setVisible(true);  
	        frm.setVisible(true); 
	        System.out.print("back");
		}
		
		if((JButton) e.getSource() == j3)//確定
		{	
			if(amount.getText().isEmpty()==true) 
	    	{
	    		amount.setText("0"); 
	    	}
	    	if(amount2.getText().isEmpty()==true) 
	    	{
	    		amount2.setText("0"); 
	    	}
	    	if(amount3.getText().isEmpty()==true) 
	    	{
	    		amount3.setText("0"); 
	    	}
	    	if(amount4.getText().isEmpty()==true) 
	    	{
	    		amount4.setText("0"); 
	    	}
	    	
	    	if(amount5.getText().isEmpty()==true) 
	    	{
	    		amount5.setText("0"); 
	    	}
	
	    	
			String drug1_amount = amount.getText();
			String drug1 = chc.getSelectedItem();
	    	String drug2_amount = amount2.getText();
	    	String drug3_amount = amount3.getText();
	    	String drug4_amount = amount4.getText();
	    	String drug5_amount = amount5.getText();
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
	    	if (drug1!= "null")
	    	{
	    		advice.append("\n"+"藥物1: "+drug1+" "+drug1_amount+"mg");
	    	}
	    	if (drug2!= "null")
	    	{
	    		advice.append("\n"+"藥物2: "+drug2+" "+drug2_amount+"mg");
	    	}
	    	if (drug3!= "null")
	    	{
	    		advice.append("\n"+"藥物3: "+drug3+" "+drug3_amount+"mg");
	    	}
	    	if (drug4!= "null")
	    	{
	    		advice.append("\n"+"藥物4: "+drug4+" "+drug4_amount+"mg");
	    	}
	    	if (drug5!= "null")
	    	{
	    		advice.append("\n"+"藥物5: "+drug5+" "+drug5_amount+"mg");
	    	}
	    	
	    	chc6.add(txt_d);	    	
	    	
		}
		
		
		if((JButton) e.getSource() == j2 ) // 建議用藥組合
		{
			
			win2 cc = new win2(s);  //開新視窗
		}
		
		if((JButton) e.getSource() == evaluation ) // 評估
		{
			try {		//傳值到pmml預測
				 predict = ModelLoading.input(DRUG1,DRUG2,DRUG3,DRUG4,DRUG5,ml1,ml2,ml3,ml4,ml5);
				 predict = ran.nextInt(100);
			} catch (Exception e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			win3 cc2 = new win3(predict);  //開新視窗，並把predict值傳入供判斷
			
		}
		
		if((JButton) e.getSource() == submit ) //提交
		{			
			frm.remove(frame);
			frm.add(frame_2);
			frm.revalidate();
			frm.repaint();
			frame_2.setVisible(true);  
	        frm.setVisible(true); 
	        System.out.print("submit");
	        
	       if(advice_2.getText().isEmpty() == false ) //判斷是否為空值 有東西的話先清空
	       {
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
		
		if((JButton) e.getSource()== submit_r) //提交頁面返回
		{
			frm.remove(frame_2);
			frm.add(f1);
			frm.revalidate();
			frm.repaint();
			f1.setVisible(true);  
	        frm.setVisible(true); 
	        System.out.print("submit");
		}
		
		if((JButton) e.getSource() == search) // 搜尋 			
		{
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
				connect_to_DB.ConnectDB();
				Statement smt = connect_to_DB.ConnectDB().createStatement();
		    	ResultSet rs = smt.executeQuery("SELECT * from 工作表2 WHERE Disease ='"+keyword+"'");
		    	rs.next();
		    	s = keyword;
		    	drug_ch1 = rs.getString(1);
		    	drug_ch2 = rs.getString(2);	
		    	drug_ch3 = rs.getString(3);	
		    	drug_ch4 = rs.getString(6);	
		    	drug_ch5 = rs.getString(4);

		    	
		    	System.out.println(drug_ch1);
		    	System.out.println(drug_ch2);
		    	System.out.println(drug_ch3);
		    	System.out.println(drug_ch4);
		    	System.out.println(drug_ch5);
		    	
		    	//非null 才加入choice
		    	if(drug_ch1 != null)
		    	{
		    		chc.add(drug_ch1);
		    		chc2.add(drug_ch1);
		    		chc3.add(drug_ch1);
		    		chc4.add(drug_ch1);
		    		chc5.add(drug_ch1);
		    	}
		    	
		    	
		    	if(drug_ch2 != null)
		    	{
		    		chc.add(drug_ch2);
		    		chc2.add(drug_ch2);
		    		chc3.add(drug_ch2);
		    		chc4.add(drug_ch2);
		    		chc5.add(drug_ch2);
		    	}
		    	
		    	if(drug_ch3 != null)
		    	{
		    		chc.add(drug_ch3);
		    		chc2.add(drug_ch3);
		    		chc3.add(drug_ch3);
		    		chc4.add(drug_ch3);
		    		chc5.add(drug_ch3);
		    	}
		    	
		    	if(drug_ch4 != null)
		    	{
		    		chc.add(drug_ch4);
		    		chc2.add(drug_ch4);
		    		chc3.add(drug_ch4);
		    		chc4.add(drug_ch4);
		    		chc5.add(drug_ch4);
		    	}
		    	
		    	if(drug_ch5 != null)
		    	{
		    		chc.add(drug_ch5);
		    		chc2.add(drug_ch5);
		    		chc3.add(drug_ch5);
		    		chc4.add(drug_ch5);
		    		chc5.add(drug_ch5);
		    	}
		    	
		    	chc.add("null");
	    		chc2.add("null");
	    		chc3.add("null");
	    		chc4.add("null");
	    		chc5.add("null");
	    		
	    		
		    	
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
    

        
    


	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
 }
 


