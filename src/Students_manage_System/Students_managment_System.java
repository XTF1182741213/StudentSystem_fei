package Students_manage_System;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Students_managment_System extends JFrame implements ActionListener {
	/**
	 * ����ϵͳ����
	 */
	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout = new CardLayout(0, 0);
	private StudentList wl;
	private JToolBar toolBar;
	private JPanel cardPanel, addPanel, delPanel, modifyPanel, searchPanel;
	private JMenuBar menuBar;
	private JMenu fileMenu, editMenu,calculateMenu,aboutMenu;
	private JMenuItem showItem, exitItem, saveItem;
	private JMenuItem addItem,deleteItem,searchItem,modifyItem;
	private JMenuItem scoreItem,collegeItem,classesItem;
	private JMenuItem meItem,functionItem;
	private Tables table;
	private JScrollPane scroll;
	private Container container;

	public Students_managment_System() {
		super();
		wl = new StudentList();
		wl.load();
		init();
	}

	public Students_managment_System(String s) {
		super(s);
		wl = new StudentList();
		wl.load();
		init();
	}

	private void init() {
		container = this.getContentPane();
		toolBar = new JToolBar();
		container.setLayout(new BorderLayout());
		cardPanel = new JPanel();
		container.add(cardPanel);
		cardPanel.setLayout(cardLayout);
//		container.setFont(new Font("����", Font.PLAIN, 30));
		
		// ��Ӳ˵���
		setMyMenuBar();

		setTable(9);

		

		scroll = new JScrollPane(table);
		addPanel = new EditPanel(wl, "���");
		delPanel = new ControlPanel(1, wl);
		modifyPanel = new ControlPanel(2, wl);
		searchPanel = new ControlPanel(3, wl);

		cardPanel.add(scroll, "p1");
		cardPanel.add(addPanel, "p2");
		cardPanel.add(delPanel, "p3");
		cardPanel.add(modifyPanel, "p4");
		cardPanel.add(searchPanel, "p5");

		

		container.add(toolBar, BorderLayout.NORTH);
		container.add(cardPanel, BorderLayout.CENTER);
		cardLayout.show(cardPanel, "p1");

		addEvent();

		this.setBounds(110, 60, 900, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void setMyMenuBar() {
		menuBar = new JMenuBar();
		fileMenu = new JMenu("�ļ�");
		fileMenu.setFont(new Font("����", Font.PLAIN, 14));
		editMenu = new JMenu("�༭");
		editMenu.setFont(new Font("����", Font.PLAIN, 14));
		calculateMenu = new JMenu("����");
		calculateMenu.setFont(new Font("����", Font.PLAIN, 14));
		aboutMenu = new JMenu("����");
		aboutMenu.setFont(new Font("����", Font.PLAIN, 14));
		
		showItem = new JMenuItem("��ʾ");
		showItem.setFont(new Font("����", Font.PLAIN, 14));
		saveItem = new JMenuItem("����");
		saveItem.setFont(new Font("����", Font.PLAIN, 14));
		exitItem = new JMenuItem("�˳�");
		exitItem.setFont(new Font("����", Font.PLAIN, 14));
		
		addItem = new JMenuItem("���");
		addItem.setFont(new Font("����", Font.PLAIN, 14));
		deleteItem = new JMenuItem("ɾ��");
		deleteItem.setFont(new Font("����", Font.PLAIN, 14));
		searchItem = new JMenuItem("����");
		searchItem.setFont(new Font("����", Font.PLAIN, 14));
		modifyItem = new JMenuItem("�޸�");
		modifyItem.setFont(new Font("����", Font.PLAIN, 14));
		
		scoreItem = new JMenuItem("����ͳ��");
		scoreItem.setFont(new Font("����", Font.PLAIN, 14));
		collegeItem = new JMenuItem("ѧԺ����");
		collegeItem.setFont(new Font("����", Font.PLAIN, 14));
		classesItem = new JMenuItem("�༶����");
		classesItem.setFont(new Font("����", Font.PLAIN, 14));
		
		functionItem = new JMenuItem("���ܽ���");
		functionItem.setFont(new Font("����", Font.PLAIN, 14));
		meItem = new JMenuItem("���ڿ�����");
		meItem.setFont(new Font("����", Font.PLAIN, 14));
		fileMenu.add(showItem);
		fileMenu.add(saveItem);
		fileMenu.add(exitItem);
		editMenu.add(addItem);
		editMenu.add(searchItem);
		editMenu.add(modifyItem);
		editMenu.add(deleteItem);
		calculateMenu.add(scoreItem);
		calculateMenu.add(collegeItem);
		calculateMenu.add(classesItem);
		aboutMenu.add(functionItem);
		aboutMenu.add(meItem);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(calculateMenu);
		menuBar.add(aboutMenu);
		this.setJMenuBar(menuBar);
	}

	private void setTable(int colSize) {
		String[][] data = null;
		String[] columnNames = null;
		switch (colSize) {
		case 9:
			data = wl.getWorkerInfo(colSize);
			columnNames =new String[] { "ѧ��", "����", "�Ա�", "������",  "ѧԺ","�༶", "������ɼ�", "��ѧ�ɼ�", "����ɼ�" };
			break;
		case 10:
			data = wl.getWorkerInfo(colSize);
			columnNames =new String[] { "ѧ��", "����", "�Ա�", "������",  "ѧԺ","�༶", "������ɼ�", "��ѧ�ɼ�", "����ɼ�", "�����ܷ�" };
			break;
		case 3:
			data = wl.getDepartmentInfo();
			columnNames =new String[] { "ѧԺ", "ѧ������" };
			break;
		case 2:
			data = wl.getPostInfo();
			columnNames =new String[] { "�༶", "ѧ������" };
			break;
			
		default:
		}
		TableModel model = new DefaultTableModel(data, columnNames) {
			private static final long serialVersionUID = 1L;

			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}
		};
		table=  new Tables(model);
	    TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
	    table.setRowSorter(sorter);
	}

	private void addEvent() {
		showItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//wl.load();
				setMyCardPanel(9);
			}
		});
		saveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wl.save();
			}
		});
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int res=JOptionPane.showConfirmDialog(null, "�˳�ѧ������ϵͳ����", "�˳�ϵͳ", JOptionPane.YES_NO_OPTION);
                if(res==JOptionPane.YES_OPTION){ 
                	System.exit(0);   //������ǡ���ִ����������
                }else{
                        //������񡱺�ִ����������
                    return;
                }
			}
		});
		addItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "p2");
			}
		});
		searchItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "p5");
			}
		});
		modifyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "p4");
			}
		});
		deleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "p3");
			}
		});
		scoreItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMyCardPanel(10);
			}
		});
		collegeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMyCardPanel(3);
			}
		});
		classesItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMyCardPanel(2);
			}
		});
		functionItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Function("���ܽ���", false);
			}
		});
		meItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Me("���ڿ�����", false);
			}
		});

	}

	private void setMyCardPanel(int i) {
		setTable(i);
		scroll = new JScrollPane(table);
		cardPanel.add(scroll, "p");
		cardLayout.show(cardPanel, "p");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	

}
