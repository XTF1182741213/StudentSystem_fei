package Students_manage_System;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {
	/**
	 * �������
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
		label = new Labels("��");
		tf = new TextField();
		button = new Buttons();
		mlabel = new Labels();

		label.setBounds(30, 10, 35, 35);
		rb1 = new RadioButtons("ѧ��", true);
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
			button.setText("ɾ��");
			
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
	                	mlabel.setVisible(true);
						try {
							long id = Long.parseLong(tf.getText());
							if (wl.delete(id)) {
								mlabel.setForeground(Color.green);
								mlabel.setText("ɾ�� " + id + " �ɹ���");
							
								
							} else {
								//mlabel.setText("�� " + id + "��");
								JOptionPane.showMessageDialog(null, "û�и�ѧ�ţ����������롣","���棡",  JOptionPane.WARNING_MESSAGE);
							}
						} catch (Exception exp) {
							//mlabel.setText("��������ȷ��ѧ�ţ���Ҫ�����Ƿ��ַ�");
							JOptionPane.showMessageDialog(null, "��������ȷ��ѧ�ţ���Ҫ�����Ƿ��ַ�", "ʧ�ܣ���", JOptionPane.ERROR_MESSAGE);
						}    
	              
					
				}
			});
			break;
		case 2:
			change = new EditPanel(wl, "�޸�");
			rb2 = new RadioButtons("����");
			rb2.setBounds(150, 10, 70, 35);
			group.add(rb1);
			group.add(rb2);
			this.add(rb2);
			button.setText("�޸�");

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
								//mlabel.setText("�������Ϣ��");
								//mlabel.setVisible(true);
								JOptionPane.showMessageDialog(null, "û�и����ݣ����������롣","���棡",  JOptionPane.WARNING_MESSAGE);
							}
						} catch (Exception e1) {
							//mlabel.setText("��������ȷ��ѧ�ţ�");
							//mlabel.setVisible(true);
							JOptionPane.showMessageDialog(null, "��������ȷ��ѧ�ţ���Ҫ�����Ƿ��ַ�", "ʧ�ܣ���", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						w = wl.searchByName(tfText);
						if (w == null) {
							change.setVisible(false);
							//mlabel.setText("�������Ϣ��");
							//mlabel.setVisible(true);
							JOptionPane.showMessageDialog(null, "û�и����ݣ����������롣","���棡",  JOptionPane.WARNING_MESSAGE);
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
			rb2 = new RadioButtons("����");
			rb2.setBounds(150, 10, 70, 35);
			group.add(rb1);
			group.add(rb2);
			this.add(rb2);
			button.setText("����");

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
								//mlabel.setText("�������Ϣ��");
								//mlabel.setVisible(true);
								JOptionPane.showMessageDialog(null, "û�и����ݣ����������롣","���棡",  JOptionPane.WARNING_MESSAGE);
							}
						} catch (Exception e1) {
							//mlabel.setText("��������ȷ��ѧ�ţ�");
							//mlabel.setVisible(true);
							JOptionPane.showMessageDialog(null, "��������ȷ��ѧ�ţ���Ҫ�����Ƿ��ַ�", "ʧ�ܣ���", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						w = wl.searchByName(tfText);
						if (w == null) {
							change.setVisible(false);
							//mlabel.setText("�������Ϣ��");
							//mlabel.setVisible(true);
							JOptionPane.showMessageDialog(null, "û�и����ݣ����������롣","���棡",  JOptionPane.WARNING_MESSAGE);
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
