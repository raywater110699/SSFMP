import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class win3 extends JFrame implements ActionListener{
	
	static JButton confirm = new JButton("我知道了！");
	public win3(float predict) {
		super("評估視窗"); 
		setBounds(900, 200, 300, 200); 
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
		setVisible(true); 
		setBackground(Color.white); 
		
		//容器 
		Container pn = getContentPane(); 
		pn.setLayout(new BorderLayout());
		pn.add(confirm, BorderLayout.PAGE_END);
		confirm.setSize(80,60);
		
		confirm.addActionListener(this);
		confirm.setBackground(Color.white); 
		
		//依照predict值設定評估文字
		if( predict>=0 && predict<25 ) {
			JLabel l1 = new JLabel("目前用藥異常，請三思！！！");
			l1.setFont(new Font("標楷體",Font.BOLD,20));
			l1.setHorizontalAlignment(SwingConstants.CENTER);
			pn.add(l1); 
			setContentPane(pn);				
		}
		
		if( predict>=25 && predict<50) {
			JLabel l1 = new JLabel("目前用藥在合理範圍內，但存在一定風險！！");
			l1.setFont(new Font("標楷體",Font.BOLD,20));
			l1.setHorizontalAlignment(SwingConstants.CENTER);
			pn.add(l1); 
			setContentPane(pn);				
		}
		
		if(predict>=50 && predict<75) {
			JLabel l1 = new JLabel("目前用藥略微異常，請再確認！");
			l1.setFont(new Font("標楷體",Font.BOLD,20));
			l1.setHorizontalAlignment(SwingConstants.CENTER);
			pn.add(l1); 
			setContentPane(pn);				
		}
		
		if(predict>=75) {
			JLabel l1 = new JLabel("目前用藥在合理範圍內～");
			l1.setFont(new Font("標楷體",Font.BOLD,20));
			l1.setHorizontalAlignment(SwingConstants.CENTER);
			pn.add(l1); 
			setContentPane(pn);				
		}
		
		
	}
	
	public void actionPerformed(ActionEvent e) {	// "我知道了！"的觸發
		if((JButton) e.getSource()== confirm)
		{
			dispose();
		}
	}
	
}
