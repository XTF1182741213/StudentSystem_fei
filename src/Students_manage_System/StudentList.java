package Students_manage_System;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JOptionPane;

public class StudentList implements Serializable {
	/**
	 * 对学生的各种操作
	 */
	private static final long serialVersionUID = 2L;
	ArrayList<Student> students;
	Calendar cal;

	public StudentList() {
		if (students == null) {
			students = new ArrayList<Student>();
		}
		cal = Calendar.getInstance();
	}

	public void add(Student w) {
		students.add(w);
	}

	public String[][] getWorkerInfo(int colSize) {
		int size = students.size();
		int x = 0;
		String[][] rowData = new String[size][colSize];
		for (Student w : students) {
			String[] col = w.toString().split(":");
			for (int y = 0; y < col.length; y++) {
				rowData[x][y] = col[y];
			}
			try {
				rowData[x][9] = this.getYears(w) + "";
			} catch (Exception e) {
			}
			x++;
		}
		return rowData;
	}

	public boolean delete(long l) {
		for (Student w : students) {
			if (w.getId() == l) {
			
                	students.remove(w);
    				return true;    //点击“是”后执行这个代码块
             
				
			}
		}
		return false;
	}

	public Student searchById(long myId) {
		for (Student w : students) {
			if (w.getId() == myId) {
				return w;
			}
		}
		return null;
	}

	public Student searchByName(String myName) {
		for (Student w : students) {
			if (w.getName().equals(myName)) {
				return w;
			}
		}
		return null;
	}



	public float getYears(Student w) {
		return w.getComputer()+w.getMath()+ w.getEnglish();
	}

	public boolean containsId(long id) {
		for (Student w : students) {
			if (w.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public String[][] getDepartmentInfo() {
		HashMap<String, int[]> dInfo = new HashMap<String, int[]>();
		String college;
		for (Student w : students) {
			college = w.getCollege();
			if (dInfo.containsKey(college)) {
				int[] info = dInfo.get(college);
				info = dInfo.get(college);
				info[0]++;
				info[1] = info[1] + 0;
			} else {
				int[] info = new int[2];
				info[0] = 1;
				info[1] = 0;
				dInfo.put(college, info);
			}
		}
		Set<HashMap.Entry<String, int[]>> entrySet = dInfo.entrySet();
		Iterator<HashMap.Entry<String, int[]>> it = entrySet.iterator();
		String[][] rowData = new String[dInfo.size()][3];
		int i = 0;
		while (it.hasNext()) {
			HashMap.Entry<String, int[]> me = it.next();
			String key = me.getKey();
			int[] data = me.getValue();
			rowData[i][0] = key;
			rowData[i][1] = data[0] + "";
			rowData[i][2] = data[1] + "";
			i++;
		}
		return rowData;
	}

	public String[][] getPostInfo() {
		HashMap<String, int[]> dInfo = new HashMap<String, int[]>();
		String classes;
		for (Student w : students) {
			classes = w.getClasses();
			if (dInfo.containsKey(classes)) {
				int[] info = dInfo.get(classes);
				info = dInfo.get(classes);
				info[0]++;
				info[1] = info[1] + 0;
			} else {
				int[] info = new int[2];
				info[0] = 1;
				info[1] = 0;
				dInfo.put(classes, info);
			}
		}
		Set<HashMap.Entry<String, int[]>> entrySet = dInfo.entrySet();
		Iterator<HashMap.Entry<String, int[]>> it = entrySet.iterator();
		String[][] rowData = new String[dInfo.size()][3];
		int i = 0;
		while (it.hasNext()) {
			HashMap.Entry<String, int[]> me = it.next();
			String key = me.getKey();
			int[] data = me.getValue();
			rowData[i][0] = key;
			rowData[i][1] = data[0] + "";
			rowData[i][2] = data[1] + "";
			i++;
		}
		return rowData;
	}
 
	@SuppressWarnings("unchecked")
	public boolean load() {
		File file = new File("Student.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
				return false;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			Object obj = in.readObject();
			try {
				students = (ArrayList<Student>) obj;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			} finally {
				if (in != null) {
					in.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;

	}

	public void save() {
		File file = new File("Student.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(students);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
