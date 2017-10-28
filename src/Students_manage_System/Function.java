package Students_manage_System;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Function extends JFrame {
	/**
	 * 功能介绍。
	 */
	private static final long serialVersionUID = 2L;
	private JLabel label = new JLabel("欢迎");
	private Container container;

	public Function(boolean b) {
		super();
		init(b);
	}

	public Function(String s, boolean b) {
		super(s);
		init(b);
	}

	private void init(boolean b) {
		container = this.getContentPane();
		//container.setBackground(Color.red);
		container.setLayout(null);

		String   strMsg1   =   "1)	显示所有学生信息；";     
		String   strMsg2   =   "2)	增加一个学生的信息；";
		String   strMsg3   =   "3)	删除一个学生的信息（需指定要删除学生的学号）；";     
		String   strMsg4   =   "4)	修改信息（如学院名称、学生信息）；"; 
		String   strMsg5   =   "5)	查找一个学生的信息（需指定学号或姓名）；";     
		String   strMsg6   =   "6)	计算出学生年龄并显示；"; 
		String   strMsg7   =   "7)	按三门课总分排列所有学生信息；";     
		String   strMsg8   =   "8)	分别按学院和班级统计学生人数"; 
		String   strMsg9   =   "9)	将学生信息存入文件；";     
		String   strMsg10   =  "10)	从文件读取学生信息"; 
		String   strMsg = "<html><body>"+strMsg1+"<br>"+strMsg2+"<br>"+strMsg3+"<br>"+strMsg4+"<br>"+strMsg5+"<br>"+strMsg6+"<br>"+strMsg7+"<br>"+strMsg8+"<br>"+strMsg9+"<br>"+strMsg10+"<body></html>";
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
		Function wel = new Function("功能介绍", true);
		
	}

}
