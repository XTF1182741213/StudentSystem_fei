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
	 * 编辑学生面板
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
		rb1 = new RadioButtons("男", true);
		rb2 = new RadioButtons("女");
		birthBox = new ComboBoxes<Integer>();
		collegeBox = new ComboBoxes<String>();
		classesBox = new ComboBoxes<String>();
		computerText = new TextField("0");
		mathText = new TextField("0");
		englishText=new TextField("0");
		

		message.setBounds(180, 10 + 9 * 45, 20150, 35);
		this.add(message);

		lb[0] = new Labels("学号");
		lb[1] = new Labels("姓名");
		lb[2] = new Labels("性别");
		lb[3] = new Labels("出生年");
		lb[4] = new Labels("学院");
		lb[5] = new Labels("班级");
		lb[6] = new Labels("计算机成绩");
		lb[7] = new Labels("数学成绩");
		lb[8] = new Labels("外语成绩");

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
		collegeBox.addItem("信息学院");
		collegeBox.addItem("会计学院");
		collegeBox.addItem("数统学院");
		collegeBox.addItem("经贸学院");
		collegeBox.addItem("工商学院");
		collegeBox.addItem("法学学院");
		collegeBox.addItem("金融学院");
		collegeBox.addItem("地旅学院");
		collegeBox.addItem("财税学院");
		collegeBox.addItem("公管学院");
		collegeBox.addItem("外语学院");
		collegeBox.addItem("人文学院");
		collegeBox.addItem("艺术学院");
		
		
		

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
					case "信息学院":
						myAddItem_1(classesBox);
						break;
					case "会计学院":
						myAddItem_2(classesBox);
						break;
					case "数统学院":
						myAddItem_3(classesBox);
						break;
					case "经贸学院":
						myAddItem_4(classesBox);
					case "工商学院":
						myAddItem_5(classesBox);
						break;
					case "法学学院":
						myAddItem_6(classesBox);
						break;
					case "金融学院":
						myAddItem_7(classesBox);
						break;
					case "地旅学院":
						myAddItem_8(classesBox);
					case "财税学院":
						myAddItem_9(classesBox);
						break;
					case "公管学院":
						myAddItem_10(classesBox);
						break;
					case "外语学院":
						myAddItem_11(classesBox);
						break;
					case "人文学院":
						myAddItem_12(classesBox);
					case "艺术学院":
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
						//message.setText(op + "失败！");
						JOptionPane.showMessageDialog(null, "存在空内容,请输入！", "出错！！", JOptionPane.ERROR_MESSAGE);
						return;
					}
					id = Long.parseLong(s1);
					if (wl.containsId(id)  && op.equals("添加")) {
						//message.setForeground(Color.red);
						//message.setText(id + "已存在，" + op + "失败！");
						JOptionPane.showMessageDialog(null, "该学号已存在,请重新输入", "出错！！", JOptionPane.ERROR_MESSAGE);
						return;
					}
					computer = Float.parseFloat(s2);
					math = Float.parseFloat(s3);
					english = Float.parseFloat(s4);
				} catch (Exception e) {
					//message.setForeground(Color.red);
					//message.setText(op + "失败！");
					JOptionPane.showMessageDialog(null, "输入不正确！！", "出错！！", JOptionPane.ERROR_MESSAGE);
					return;
				}

				String gender;
				int birthday = (int) birthBox.getSelectedItem();
				
				String college = (String) collegeBox.getSelectedItem();
				String classes = (String) classesBox.getSelectedItem();
				if (rb1.isSelected()) {
					gender = "男";
				} else {
					gender = "女";
				}
				if (op.equals("修改")) {
					wl.delete(myStudent.getId());
				}
				wl.add(new Student(id, name, gender, birthday,  college, classes,computer, math, english));
				//message.setForeground(Color.green);
				message.setBackground(Color.cyan);
				//message.setText(op + "成功！");
				JOptionPane.showMessageDialog(null, "成功！", "成功！", JOptionPane.INFORMATION_MESSAGE);
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
		if (myGender.equals("男")) {
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
		box.addItem("15软件工程1班");
		box.addItem("15软件工程2班");
		box.addItem("15计算机科学与技术1班");
		box.addItem("15计算机科学与技术2班");
		box.addItem("15信息管理与信息系统1班");
		box.addItem("15信息管理与信息系统2班");
		box.addItem("15电子商务1班");
		box.addItem("15电子商务2班");
		box.addItem("16软件工程1班");
		box.addItem("16软件工程2班");
	}

	private void myAddItem_2(ComboBoxes<String> box) {
		box.addItem("15会计学1班");
		box.addItem("15会计学2班");
		box.addItem("15财务管理1班");
		box.addItem("15财务管理2班");
		box.addItem("15审计学1班");
		box.addItem("15审计学2班");
		
	}


	private void myAddItem_3(ComboBoxes<String> box) {
		box.addItem("15数学与应用数学1班");
		box.addItem("15数学与应用数学2班");
		box.addItem("15信息与计算科学1班");
		box.addItem("15信息与计算科学2班");
		box.addItem("15统计学1班");
		box.addItem("15统计学2班");
		box.addItem("15应用统计学1班");
		box.addItem("15应用统计学2班");
	}


	private void myAddItem_4(ComboBoxes<String> box) {
		box.addItem("15经济学1班");
		box.addItem("15经济学2班");
		box.addItem("15经济统计学1班");
		box.addItem("15经济统计学2班");
		box.addItem("15国际经济与贸易1班");
		box.addItem("15国际经济与贸易2班");
		box.addItem("15国际商务1班");
		box.addItem("15国际商务2班");
	}
	private void myAddItem_5(ComboBoxes<String> box) {
		box.addItem("15工商管理1班");
		box.addItem("15工商管理2班");
		box.addItem("15市场营销1班");
		box.addItem("15市场营销2班");
		box.addItem("15人力资源管理1班");
		box.addItem("15人力资源管理2班");
		box.addItem("15物流管理1班");
		box.addItem("15物流管理2班");
	}
	private void myAddItem_6(ComboBoxes<String> box) {
		box.addItem("15法学1班");
		box.addItem("15法学2班");
		box.addItem("16法学1班");
		box.addItem("16法学2班");
	}
	private void myAddItem_7(ComboBoxes<String> box) {
		box.addItem("15金融学1班");
		box.addItem("15金融学2班");
		box.addItem("15金融工程1班");
		box.addItem("15金融工程2班");
		box.addItem("15投资学1班");
		box.addItem("15投资学2班");
		box.addItem("15保险学1班");
		box.addItem("15保险学2班");
	}
	private void myAddItem_8(ComboBoxes<String> box) {
		box.addItem("15自然地理与资源环境1班");
		box.addItem("15自然地理与资源环境2班");
		box.addItem("15人文地理与城乡规划1班");
		box.addItem("15人文地理与城乡规划2班");
		box.addItem("15酒店管理1班");
		box.addItem("15酒店管理2班");
		box.addItem("15旅游管理1班");
		box.addItem("15旅游管理2班");
		box.addItem("16会展经济与管理1班");
		box.addItem("16会展经济与管理2班");
	}


	private void myAddItem_10(ComboBoxes<String> box) {
		box.addItem("15行政管理1班");
		box.addItem("15行政管理2班");
		box.addItem("15公共事业管理1班");
		box.addItem("15公共事业管理2班");
		box.addItem("15劳动与社会保障1班");
		box.addItem("15劳动与社会保障2班");
		box.addItem("15文化产业管理1班");
		box.addItem("15土地资源管理2班");
		box.addItem("16房地产开发与管理1班");
		box.addItem("16房地产开发与管理2班");
	}


	private void myAddItem_9(ComboBoxes<String> box) {
		box.addItem("15财政学1班");
		box.addItem("15财政学2班");
		box.addItem("15税收学1班");
		box.addItem("15税收学2班");
		box.addItem("15资产评估1班");
		box.addItem("15资产评估2班");
	}
	private void myAddItem_11(ComboBoxes<String> box) {
		box.addItem("15英语1班");
		box.addItem("15英语2班");
		box.addItem("15商务英语1班");
		box.addItem("15商务英语2班");
		box.addItem("15日语1班");
		box.addItem("15日语2班");
		box.addItem("15翻译1班");
		box.addItem("15翻译2班");
	}
	private void myAddItem_12(ComboBoxes<String> box) {
		box.addItem("15社会工作1班");
		box.addItem("15汉语言文学2班");
		box.addItem("15社会学1班");
		box.addItem("15新闻学2班");
		box.addItem("15应用心理学1班");
		box.addItem("15编辑出版学2班");
		box.addItem("15广播电视编导1班");
		box.addItem("15广播电视编导2班");
		box.addItem("16播音与主持艺术1班");
		box.addItem("16播音与主持艺术2班");
	}
	private void myAddItem_13(ComboBoxes<String> box) {
		box.addItem("15广告学1班");
		box.addItem("15广告学2班");
		box.addItem("15动画1班");
		box.addItem("15动画2班");
		box.addItem("15环境设计1班");
		box.addItem("15环境设计2班");
		box.addItem("15视觉传达设计1班");
		box.addItem("15视觉传达设计2班");
		box.addItem("16产品设计1班");
		box.addItem("16产品设计2班");
	}





}
