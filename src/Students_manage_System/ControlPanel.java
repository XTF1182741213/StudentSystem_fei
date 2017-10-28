package Students_manage_System;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {
	/**
	 * 操作面板
	 */
	private static final long serialVersionUID = 3L;
	private Labels label, mlabel;
	private TextField tf;
	private Buttons button;
	private EditPanel change;
	private Student w = null;
	private RadioButtons rb1, rb2;
	ButtonGroup group = new ButtonGroup();

	public ControlPanel(int flag, StudentList wl) {
		super();
		init(flag, wl);
	}

	private void init(int flag, StudentList wl) {
		label = new Labels("按");
		tf = new TextField();
		button = new Buttons();
		mlabel = new Labels();

		label.setBounds(30, 10, 35, 35);
		rb1 = new RadioButtons("学号", true);
		rb1.setBounds(80, 10, 70, 35);
		tf.setBounds(240, 10, 240, 35);
		button.setBounds(520, 10, 100, 35);
		mlabel.setBounds(200, 70, 500, 35);
		mlabel.setVisible(false);

		mySettings(flag, wl);

		this.setLayout(null);
		this.add(rb1);
		this.add(mlabel);
		this.add(label);
		this.add(tf);
		this.add(button);
	}

	private void mySettings(int flag, StudentList wl) {
		switch (flag) {
		case 1:
			button.setText("删除");
			
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
	                	mlabel.setVisible(true);
						try {
							long id = Long.parseLong(tf.getText());
							if (wl.delete(id)) {
								mlabel.setForeground(Color.green);
								mlabel.setText("删除 " + id + " 成功！");
							
								
							} else {
								//mlabel.setText("无 " + id + "！");
								JOptionPane.showMessageDialog(null, "没有该学号！请重新输入。","警告！",  JOptionPane.WARNING_MESSAGE);
							}
						} catch (Exception exp) {
							//mlabel.setText("请输入正确的学号，不要包含非法字符");
							JOptionPane.showMessageDialog(null, "请输入正确的学号，不要包含非法字符", "失败！！", JOptionPane.ERROR_MESSAGE);
						}    
	              
					
				}
			});
			break;
		case 2:
			change = new EditPanel(wl, "修改");
			rb2 = new RadioButtons("姓名");
			rb2.setBounds(150, 10, 70, 35);
			group.add(rb1);
			group.add(rb2);
			this.add(rb2);
			button.setText("修改");

			this.add(change);
			change.setBounds(0, 50, 700, 550);
			change.setVisible(false);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String tfText = tf.getText();
					if (rb1.isSelected()) {
						long myId;
						try {
							myId = Long.parseLong(tfText);
							w = wl.searchById(myId);
							if (w == null) {
								//mlabel.setText("无相关信息！");
								//mlabel.setVisible(true);
								JOptionPane.showMessageDialog(null, "没有该内容！请重新输入。","警告！",  JOptionPane.WARNING_MESSAGE);
							}
						} catch (Exception e1) {
							//mlabel.setText("请输入正确的学号！");
							//mlabel.setVisible(true);
							JOptionPane.showMessageDialog(null, "请输入正确的学号，不要包含非法字符", "失败！！", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						w = wl.searchByName(tfText);
						if (w == null) {
							change.setVisible(false);
							//mlabel.setText("无相关信息！");
							//mlabel.setVisible(true);
							JOptionPane.showMessageDialog(null, "没有该内容！请重新输入。","警告！",  JOptionPane.WARNING_MESSAGE);
						}
					}
					if (w != null) {
						change.setData(w);
						change.setMyStudent(w);
						change.setVisible(true);
						mlabel.setVisible(false);
					}
				}
			});
			break;
		case 3:
			change = new EditPanel(wl);
			rb2 = new RadioButtons("姓名");
			rb2.setBounds(150, 10, 70, 35);
			group.add(rb1);
			group.add(rb2);
			this.add(rb2);
			button.setText("查找");

			this.add(change);
			change.setBounds(0, 50, 700, 550);
			change.setVisible(false);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String tfText = tf.getText();
					if (rb1.isSelected()) {
						long myId;
						try {
							myId = Long.parseLong(tfText);
							w = wl.searchById(myId);
							if (w == null) {
								//mlabel.setText("无相关信息！");
								//mlabel.setVisible(true);
								JOptionPane.showMessageDialog(null, "没有该内容！请重新输入。","警告！",  JOptionPane.WARNING_MESSAGE);
							}
						} catch (Exception e1) {
							//mlabel.setText("请输入正确的学号！");
							//mlabel.setVisible(true);
							JOptionPane.showMessageDialog(null, "请输入正确的学号，不要包含非法字符", "失败！！", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						w = wl.searchByName(tfText);
						if (w == null) {
							change.setVisible(false);
							//mlabel.setText("无相关信息！");
							//mlabel.setVisible(true);
							JOptionPane.showMessageDialog(null, "没有该内容！请重新输入。","警告！",  JOptionPane.WARNING_MESSAGE);
						}
					}
					if (w != null) {
						change.setData(w);
						change.setMyStudent(w);
						change.setVisible(true);
						mlabel.setVisible(false);
					}
				}
			});
			break;
		default:
		}
	}
}
