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
	
	static JButton confirm = new JButton("�������");
	public win3(float predict) {
		super("閰摯閬��"); 
		setBounds(900, 200, 300, 200); 
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
		setVisible(true); 
		setBackground(Color.white); 
		
		
		Container pn = getContentPane(); 
		pn.setLayout(new BorderLayout());
		pn.add(confirm, BorderLayout.PAGE_END);
		confirm.setSize(80,60);
		
		//FlowLayout fy = new FlowLayout(); 
		//pn.setLayout(fy); 
		
		confirm.addActionListener(this);
		confirm.setBackground(Color.white); 
		
		
		/*
		if(predict>=84) {
			JLabel l1 = new JLabel("����摰");
			l1.setFont(new Font("璅扑擃�",Font.BOLD,16));
			l1.setHorizontalAlignment(SwingConstants.CENTER);
			pn.add(l1); 
			setContentPane(pn);				
		}
		
		if(predict<84) {
			JLabel l1 = new JLabel("������");
			l1.setFont(new Font("璅扑擃�",Font.BOLD,16));
			l1.setHorizontalAlignment(SwingConstants.CENTER);
			pn.add(l1); 
			setContentPane(pn);
		}*/
		
		if( predict>=0 && predict<25 ) {
			JLabel l1 = new JLabel("�����撣賂��������");
			l1.setFont(new Font("璅扑擃�",Font.BOLD,20));
			l1.setHorizontalAlignment(SwingConstants.CENTER);
			pn.add(l1); 
			setContentPane(pn);				
		}
		
		if( predict>=25 && predict<50) {
			JLabel l1 = new JLabel("����������嚗��銝�摰◢�嚗��");
			l1.setFont(new Font("璅扑擃�",Font.BOLD,20));
			l1.setHorizontalAlignment(SwingConstants.CENTER);
			pn.add(l1); 
			setContentPane(pn);				
		}
		
		if(predict>=50 && predict<75) {
			JLabel l1 = new JLabel("�����敺桃撣賂���Ⅱ隤��");
			l1.setFont(new Font("璅扑擃�",Font.BOLD,20));
			l1.setHorizontalAlignment(SwingConstants.CENTER);
			pn.add(l1); 
			setContentPane(pn);				
		}
		
		if(predict>=75) {
			JLabel l1 = new JLabel("����������嚚�");
			l1.setFont(new Font("璅扑擃�",Font.BOLD,20));
			l1.setHorizontalAlignment(SwingConstants.CENTER);
			pn.add(l1); 
			setContentPane(pn);				
		}
		
		
	}
	
	public void actionPerformed(ActionEvent e) {	// "�������"��孛�
		if((JButton) e.getSource()== confirm)
		{
			dispose();
		}
	}
	
}
