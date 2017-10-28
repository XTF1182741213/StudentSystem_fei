package Students_manage_System;

import java.io.Serializable;

public class Student implements Serializable {
	/**
	 * ‘±π§¿‡
	 */
	private static final long serialVersionUID = 1L;
	private int birthday;
	private long id;
	private String name, gender, college, classes;
	private float math,english,computer;

	public Student() {
	}

	public Student(long id, String name, String gender, int birthday,  String college, String classes,
			float computer, float math,float english) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.english = english;
		this.college = college;
		this.classes = classes;
		this.computer = computer;
		this.math = math;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}



	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public float getComputer() {
		return computer;
	}

	public void setComputer(float computer) {
		this.computer = computer;
	}

	public float getMath() {
		return math;
	}

	public void setMath(float math) {
		this.math = math;
	}
	
	public float getEnglish() {
		return english;
	}

	public void setEnglish(float english) {
		this.english = english;
	}

	public String toString() {
		return this.id + ": " + this.name + ": " + this.gender + ": " + this.birthday  + ": "
				+ this.college + ": " + this.classes  +": " + this.computer + ": " + this.math+ ": " + this.english;
	}

}
