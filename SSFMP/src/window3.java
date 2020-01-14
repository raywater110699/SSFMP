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

public class window3 extends JFrame implements ActionListener{
	
	static JButton confirm = new JButton("我知道了！");
	
	public window3(float predict) {
		super("評估視窗"); 
		setBounds(900, 200, 500, 200); 
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
		if(predict>=0 && predict<25) {
			JLabel l1 = new JLabel("目前用藥異常，請三思！！！");
			setfont(l1,pn);
			return;
		}
		
		if(predict>=25 && predict<50) {
			JLabel l1 = new JLabel("目前用藥略微異常，請再確認！");
			setfont(l1,pn);			
			return;
		}
		
		if(predict>=50 && predict<75) {
			JLabel l1 = new JLabel("目前用藥在合理範圍內，但存在一定風險！！");
			setfont(l1,pn);				
			return;
		}
		
		JLabel l1 = new JLabel("目前用藥在合理範圍內～");
		setfont(l1,pn);				
		
		
	}
	
	public void actionPerformed(ActionEvent e) {	// "我知道了！"的觸發
		if((JButton) e.getSource()== confirm)
		{
			dispose();
		}
	}
	
	public void setfont(JLabel label, Container panel) {
		label.setFont(new Font("標楷體",Font.BOLD,20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label); 
		setContentPane(panel);
	}
	
}
