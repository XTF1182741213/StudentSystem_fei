package Students_manage_System;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EditPanel extends JPanel {
	private Labels[] lb;
	private Labels message;
	private Buttons button;
	private TextField computerText, mathText, idText, nameText,englishText;
	private ButtonGroup group;
	private RadioButtons rb1, rb2;
	private ComboBoxes<Integer> birthBox;
	private Calendar cal = Calendar.getInstance();
	private ComboBoxes<String> collegeBox, classesBox;
	private Student myStudent;
	private StudentList wl;
	private String op;

	/**
	 * �༭ѧ�����
	 */
	private static final long serialVersionUID = 2L;

	public EditPanel(StudentList wl, String op) {
		super();
		this.wl = wl;
		this.op = op;
		init();
	}

	public EditPanel(StudentList wl) {
		super();
		this.wl = wl;
		this.op = "";
		init();
		button.setVisible(false);
	}

	private void init() {
		lb = new Labels[9];
		message = new Labels();
		button = new Buttons(op);
		idText = new TextField("");
		nameText = new TextField("");
		group = new ButtonGroup();
		rb1 = new RadioButtons("��", true);
		rb2 = new RadioButtons("Ů");
		birthBox = new ComboBoxes<Integer>();
		collegeBox = new ComboBoxes<String>();
		classesBox = new ComboBoxes<String>();
		computerText = new TextField("0");
		mathText = new TextField("0");
		englishText=new TextField("0");
		

		message.setBounds(180, 10 + 9 * 45, 20150, 35);
		this.add(message);

		lb[0] = new Labels("ѧ��");
		lb[1] = new Labels("����");
		lb[2] = new Labels("�Ա�");
		lb[3] = new Labels("������");
		lb[4] = new Labels("ѧԺ");
		lb[5] = new Labels("�༶");
		lb[6] = new Labels("������ɼ�");
		lb[7] = new Labels("��ѧ�ɼ�");
		lb[8] = new Labels("����ɼ�");

		for (int i = 0; i < lb.length; i++) {
			lb[i].setBounds(60, 10 + i * 45, 80, 35);
			this.add(lb[i]);
		}

		idText.setBounds(300, 10, 300, 35);
		this.add(idText);

		nameText.setBounds(300, 10 + 45 * 1, 300, 35);
		this.add(nameText);

		rb1.setBounds(300, 10 + 45 * 2, 150, 35);
		rb2.setBounds(450, 10 + 45 * 2, 150, 35);
		group.add(rb1);
		group.add(rb2);
		this.add(rb1);
		this.add(rb2);

		birthBox.setBounds(300, 10 + 45 * 3, 300, 35);
		this.add(birthBox);
		int thisYear = cal.get(Calendar.YEAR);
		for (int i = 1975; i <= thisYear - 18; i++) {
			birthBox.addItem(i);
		}

		

		collegeBox.setBounds(300, 10 + 45 * 4, 300, 35);
		this.add(collegeBox);
		collegeBox.addItem("��ϢѧԺ");
		collegeBox.addItem("���ѧԺ");
		collegeBox.addItem("��ͳѧԺ");
		collegeBox.addItem("��óѧԺ");
		collegeBox.addItem("����ѧԺ");
		collegeBox.addItem("��ѧѧԺ");
		collegeBox.addItem("����ѧԺ");
		collegeBox.addItem("����ѧԺ");
		collegeBox.addItem("��˰ѧԺ");
		collegeBox.addItem("����ѧԺ");
		collegeBox.addItem("����ѧԺ");
		collegeBox.addItem("����ѧԺ");
		collegeBox.addItem("����ѧԺ");
		
		
		

		classesBox.setBounds(300, 10 + 45 * 5, 300, 35);
		this.add(classesBox);
		myAddItem_1(classesBox);

		computerText.setBounds(300, 10 + 45 * 6, 300, 35);
		this.add(computerText);

		mathText.setBounds(300, 10 + 45 * 7, 300, 35);
		this.add(mathText);
		
		englishText.setBounds(300, 10 + 45 * 8, 300, 35);
		this.add(englishText);
		
		
		
		button.setBounds(500, 10 + 45 * 9, 100, 30);
		
		this.add(button);
		this.setLayout(null);
	



		collegeBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String department = (String) e.getItem();
					classesBox.removeAllItems();
					switch (department) {
					case "��ϢѧԺ":
						myAddItem_1(classesBox);
						break;
					case "���ѧԺ":
						myAddItem_2(classesBox);
						break;
					case "��ͳѧԺ":
						myAddItem_3(classesBox);
						break;
					case "��óѧԺ":
						myAddItem_4(classesBox);
					case "����ѧԺ":
						myAddItem_5(classesBox);
						break;
					case "��ѧѧԺ":
						myAddItem_6(classesBox);
						break;
					case "����ѧԺ":
						myAddItem_7(classesBox);
						break;
					case "����ѧԺ":
						myAddItem_8(classesBox);
					case "��˰ѧԺ":
						myAddItem_9(classesBox);
						break;
					case "����ѧԺ":
						myAddItem_10(classesBox);
						break;
					case "����ѧԺ":
						myAddItem_11(classesBox);
						break;
					case "����ѧԺ":
						myAddItem_12(classesBox);
					case "����ѧԺ":
						myAddItem_13(classesBox);
					}
				}
			}
		});

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				long id;
				float computer;
				float math;
				float english;
				String name = nameText.getText();

				String s1, s2, s3,s4;
				try {
					s1 = idText.getText();
					s2 = computerText.getText();
					s3 = mathText.getText();
					s4 = englishText.getText();
					if (name.equals("") || s1.equals("") || s2.equals("") || s3.equals("")|| s4.equals("")) {
						//message.setForeground(Color.red);
						//message.setText(op + "ʧ�ܣ�");
						JOptionPane.showMessageDialog(null, "���ڿ�����,�����룡", "������", JOptionPane.ERROR_MESSAGE);
						return;
					}
					id = Long.parseLong(s1);
					if (wl.containsId(id)  && op.equals("���")) {
						//message.setForeground(Color.red);
						//message.setText(id + "�Ѵ��ڣ�" + op + "ʧ�ܣ�");
						JOptionPane.showMessageDialog(null, "��ѧ���Ѵ���,����������", "������", JOptionPane.ERROR_MESSAGE);
						return;
					}
					computer = Float.parseFloat(s2);
					math = Float.parseFloat(s3);
					english = Float.parseFloat(s4);
				} catch (Exception e) {
					//message.setForeground(Color.red);
					//message.setText(op + "ʧ�ܣ�");
					JOptionPane.showMessageDialog(null, "���벻��ȷ����", "������", JOptionPane.ERROR_MESSAGE);
					return;
				}

				String gender;
				int birthday = (int) birthBox.getSelectedItem();
				
				String college = (String) collegeBox.getSelectedItem();
				String classes = (String) classesBox.getSelectedItem();
				if (rb1.isSelected()) {
					gender = "��";
				} else {
					gender = "Ů";
				}
				if (op.equals("�޸�")) {
					wl.delete(myStudent.getId());
				}
				wl.add(new Student(id, name, gender, birthday,  college, classes,computer, math, english));
				//message.setForeground(Color.green);
				message.setBackground(Color.cyan);
				//message.setText(op + "�ɹ���");
				JOptionPane.showMessageDialog(null, "�ɹ���", "�ɹ���", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

	public void setMyStudent(Student student) {
		this.myStudent = student;
	}

	public void setData(Student w) {
		idText.setText(w.getId() + "");
		nameText.setText(w.getName());
		String myGender = w.getGender();
		if (myGender.equals("��")) {
			rb1.setSelected(true);
		} else {
			rb2.setSelected(true);
		}
		birthBox.setSelectedItem(w.getBirthday());
		collegeBox.setSelectedItem(w.getCollege());
		classesBox.setSelectedItem(w.getClasses());
		computerText.setText(w.getComputer() + "");
		mathText.setText(w.getMath() + "");
		englishText.setText(w.getEnglish()+"");
		
	}

	private void myAddItem_1(ComboBoxes<String> box) {
		box.addItem("15�������1��");
		box.addItem("15�������2��");
		box.addItem("15�������ѧ�뼼��1��");
		box.addItem("15�������ѧ�뼼��2��");
		box.addItem("15��Ϣ��������Ϣϵͳ1��");
		box.addItem("15��Ϣ��������Ϣϵͳ2��");
		box.addItem("15��������1��");
		box.addItem("15��������2��");
		box.addItem("16�������1��");
		box.addItem("16�������2��");
	}

	private void myAddItem_2(ComboBoxes<String> box) {
		box.addItem("15���ѧ1��");
		box.addItem("15���ѧ2��");
		box.addItem("15�������1��");
		box.addItem("15�������2��");
		box.addItem("15���ѧ1��");
		box.addItem("15���ѧ2��");
		
	}


	private void myAddItem_3(ComboBoxes<String> box) {
		box.addItem("15��ѧ��Ӧ����ѧ1��");
		box.addItem("15��ѧ��Ӧ����ѧ2��");
		box.addItem("15��Ϣ������ѧ1��");
		box.addItem("15��Ϣ������ѧ2��");
		box.addItem("15ͳ��ѧ1��");
		box.addItem("15ͳ��ѧ2��");
		box.addItem("15Ӧ��ͳ��ѧ1��");
		box.addItem("15Ӧ��ͳ��ѧ2��");
	}


	private void myAddItem_4(ComboBoxes<String> box) {
		box.addItem("15����ѧ1��");
		box.addItem("15����ѧ2��");
		box.addItem("15����ͳ��ѧ1��");
		box.addItem("15����ͳ��ѧ2��");
		box.addItem("15���ʾ�����ó��1��");
		box.addItem("15���ʾ�����ó��2��");
		box.addItem("15��������1��");
		box.addItem("15��������2��");
	}
	private void myAddItem_5(ComboBoxes<String> box) {
		box.addItem("15���̹���1��");
		box.addItem("15���̹���2��");
		box.addItem("15�г�Ӫ��1��");
		box.addItem("15�г�Ӫ��2��");
		box.addItem("15������Դ����1��");
		box.addItem("15������Դ����2��");
		box.addItem("15��������1��");
		box.addItem("15��������2��");
	}
	private void myAddItem_6(ComboBoxes<String> box) {
		box.addItem("15��ѧ1��");
		box.addItem("15��ѧ2��");
		box.addItem("16��ѧ1��");
		box.addItem("16��ѧ2��");
	}
	private void myAddItem_7(ComboBoxes<String> box) {
		box.addItem("15����ѧ1��");
		box.addItem("15����ѧ2��");
		box.addItem("15���ڹ���1��");
		box.addItem("15���ڹ���2��");
		box.addItem("15Ͷ��ѧ1��");
		box.addItem("15Ͷ��ѧ2��");
		box.addItem("15����ѧ1��");
		box.addItem("15����ѧ2��");
	}
	private void myAddItem_8(ComboBoxes<String> box) {
		box.addItem("15��Ȼ��������Դ����1��");
		box.addItem("15��Ȼ��������Դ����2��");
		box.addItem("15���ĵ��������滮1��");
		box.addItem("15���ĵ��������滮2��");
		box.addItem("15�Ƶ����1��");
		box.addItem("15�Ƶ����2��");
		box.addItem("15���ι���1��");
		box.addItem("15���ι���2��");
		box.addItem("16��չ���������1��");
		box.addItem("16��չ���������2��");
	}


	private void myAddItem_10(ComboBoxes<String> box) {
		box.addItem("15��������1��");
		box.addItem("15��������2��");
		box.addItem("15������ҵ����1��");
		box.addItem("15������ҵ����2��");
		box.addItem("15�Ͷ�����ᱣ��1��");
		box.addItem("15�Ͷ�����ᱣ��2��");
		box.addItem("15�Ļ���ҵ����1��");
		box.addItem("15������Դ����2��");
		box.addItem("16���ز����������1��");
		box.addItem("16���ز����������2��");
	}


	private void myAddItem_9(ComboBoxes<String> box) {
		box.addItem("15����ѧ1��");
		box.addItem("15����ѧ2��");
		box.addItem("15˰��ѧ1��");
		box.addItem("15˰��ѧ2��");
		box.addItem("15�ʲ�����1��");
		box.addItem("15�ʲ�����2��");
	}
	private void myAddItem_11(ComboBoxes<String> box) {
		box.addItem("15Ӣ��1��");
		box.addItem("15Ӣ��2��");
		box.addItem("15����Ӣ��1��");
		box.addItem("15����Ӣ��2��");
		box.addItem("15����1��");
		box.addItem("15����2��");
		box.addItem("15����1��");
		box.addItem("15����2��");
	}
	private void myAddItem_12(ComboBoxes<String> box) {
		box.addItem("15��Ṥ��1��");
		box.addItem("15��������ѧ2��");
		box.addItem("15���ѧ1��");
		box.addItem("15����ѧ2��");
		box.addItem("15Ӧ������ѧ1��");
		box.addItem("15�༭����ѧ2��");
		box.addItem("15�㲥���ӱർ1��");
		box.addItem("15�㲥���ӱർ2��");
		box.addItem("16��������������1��");
		box.addItem("16��������������2��");
	}
	private void myAddItem_13(ComboBoxes<String> box) {
		box.addItem("15���ѧ1��");
		box.addItem("15���ѧ2��");
		box.addItem("15����1��");
		box.addItem("15����2��");
		box.addItem("15�������1��");
		box.addItem("15�������2��");
		box.addItem("15�Ӿ��������1��");
		box.addItem("15�Ӿ��������2��");
		box.addItem("16��Ʒ���1��");
		box.addItem("16��Ʒ���2��");
	}





}
