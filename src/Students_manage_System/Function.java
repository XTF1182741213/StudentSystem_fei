package Students_manage_System;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Function extends JFrame {
	/**
	 * ���ܽ��ܡ�
	 */
	private static final long serialVersionUID = 2L;
	private JLabel label = new JLabel("��ӭ");
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

		String   strMsg1   =   "1)	��ʾ����ѧ����Ϣ��";     
		String   strMsg2   =   "2)	����һ��ѧ������Ϣ��";
		String   strMsg3   =   "3)	ɾ��һ��ѧ������Ϣ����ָ��Ҫɾ��ѧ����ѧ�ţ���";     
		String   strMsg4   =   "4)	�޸���Ϣ����ѧԺ���ơ�ѧ����Ϣ����"; 
		String   strMsg5   =   "5)	����һ��ѧ������Ϣ����ָ��ѧ�Ż���������";     
		String   strMsg6   =   "6)	�����ѧ�����䲢��ʾ��"; 
		String   strMsg7   =   "7)	�����ſ��ܷ���������ѧ����Ϣ��";     
		String   strMsg8   =   "8)	�ֱ�ѧԺ�Ͱ༶ͳ��ѧ������"; 
		String   strMsg9   =   "9)	��ѧ����Ϣ�����ļ���";     
		String   strMsg10   =  "10)	���ļ���ȡѧ����Ϣ"; 
		String   strMsg = "<html><body>"+strMsg1+"<br>"+strMsg2+"<br>"+strMsg3+"<br>"+strMsg4+"<br>"+strMsg5+"<br>"+strMsg6+"<br>"+strMsg7+"<br>"+strMsg8+"<br>"+strMsg9+"<br>"+strMsg10+"<body></html>";
		label = new JLabel(strMsg);
		label.setFont(new Font("����", Font.PLAIN, 20));
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
		Function wel = new Function("���ܽ���", true);
		
	}

}
