package Students_manage_System;

//登录界面
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.sql.*;

class Login extends JFrame implements ActionListener {
	Container cp = null;
	String name = null;
	String psw = null;
	JFrame f = null;
	JButton j1, j2;
	JTextField t1;
	JPasswordField t2;
	JLabel jlable1, jlable2;
	Color c;
	JPanel jp1, jp2;

	Login() {
		f = new JFrame("学生管理系统");
		j1 = new JButton("确定");
		j2 = new JButton("取消");
		cp = f.getContentPane();
		jlable1 = new JLabel("输入用户:");
		jlable2 = new JLabel("输用户密:");
		jp1 = new JPanel();
		jp2 = new JPanel();
		t1 = new JTextField(15);
		t2 = new JPasswordField(15);
		jp1.add(jlable1);
		jp1.add(t1);
		jp1.add(jlable2);
		jp1.add(t2);
		
		
	
		
		JLabel JL = new JLabel("<html><font color=#000000 size='4'>欢迎进入学生管理系统</i></font>",SwingConstants.CENTER);
		cp.add(JL, "North");
		jp2.add(j1);
		jp2.add(j2);
		cp.add(jp1, "Center");
		cp.add("South", jp2);
		jp1.setBackground(Color.lightGray);
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		Dimension screen = kit.getScreenSize();
		int x = screen.width; 
								 
		int y = screen.height; 
		f.setSize(300, 300);
		int xcenter = (x - 300) / 2;
		int ycenter = (y - 300) / 2;
		f.setLocation(xcenter, ycenter);
		f.setVisible(true);
		// -----------------------------------------------------
		j1.addActionListener(this);
		j2.addActionListener(this);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void confirm() throws IOException
	{
		File file = new File("Login.txt");
		try {
			if (!file.exists())
				file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(new FileReader(file));
		String temp = br.readLine();
		String line;
		while ((line = br.readLine()) != null) {
			temp += "," + line;
		}
		if (temp == null) {
			System.out.println();
		} else {
			
			String[] str = temp.split(",");
			name = str[0];
			psw = str[1];
			if (t1.getText().trim().equals(name) && t2.getText().trim().equals(psw)) {
				
				 
				new Students_managment_System("学生管理系统");
				
				
				f.hide();
				br.close();
			} else {
				JOptionPane.showMessageDialog(null, "该用户不存在！！", "提示�?", JOptionPane.YES_NO_OPTION);
			}
			t1.setText("");
			t2.setText("");
			// for(int i=0;i>str.length;i++){
			// System.out.println(str[i]);
			// }
		}
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("确定")) {
			try {
				confirm();
			} catch (IOException e1) {
			
				e1.printStackTrace();
			}
		} else if (cmd.equals("取消")) {
			f.dispose();
		}
	}

	public static void main(String[] arg) {
		Login a = new Login();
	}
}