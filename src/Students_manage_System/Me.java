package Students_manage_System;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Me extends JFrame {
	/**
	 * 关于开发者。
	 */
	private static final long serialVersionUID = 2L;
	private JLabel label = new JLabel("欢迎");
	private Container container;

	public Me(boolean b) {
		super();
		init(b);
	}

	public Me(String s, boolean b) {
		super(s);
		init(b);
	}

	private void init(boolean b) {
		container = this.getContentPane();
		//container.setBackground(Color.red);
		container.setLayout(null);

		String   strMsg1   =   "班级：15软件工程2班；";     
		String   strMsg2   =   "姓名：谢土飞";
		String   strMsg3   =   "学号：15251104218";     
		String   strMsg4   =   "联系方式：13536642890"; 

		String   strMsg = "<html><body>"+strMsg1+"<br>"+strMsg2+"<br>"+strMsg3+"<br>"+strMsg4+"<body></html>";
		label = new JLabel(strMsg);
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(150, -50, 700, 600);

		this.setBounds(110, 60, 700, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		try {
			if (b) {
				Thread.sleep(500);
				container.add(label);
				this.repaint();
				Thread.sleep(500);
			} else {
				container.add(label);
				this.repaint();
			}
		} catch (InterruptedException e) {

		}
	}

	public static void main(String[] args) {
		Me wel = new Me("关于开发者", true);
		
	}

}
