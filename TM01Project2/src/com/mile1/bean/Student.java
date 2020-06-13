package com.mile1.bean;

public class Student {
	public String name;
	public int marks[];
	public Student() {}
	public Student(String name,int marks[]) {
		this.name=name;
		this.marks=marks;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int[] getMarks() {
		return this.marks;
	}
	public void setMarks(int marks[]) {
		this.marks=marks;
	}
	
}
