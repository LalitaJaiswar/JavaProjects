package com.mile1.service;
import com.mile1.bean.Student;

public class StudentService {
	public int findNumberOfNullMarks(Student data[]) {
		int count=0;
		for(int i=0;i<data.length;i++) {
			try {
			if(data[i].marks==null)
				count++;
			}
		catch(NullPointerException e) {
				
			}
		}
		return count;
	}
	public int findNumberOfNullName(Student data[]) {
		int count=0;
		for(int i=0;i<data.length;i++) {
			try {
			if(data[i].name==null) {
				count++;
			}
			}
			catch(NullPointerException e) {
				
			}
		}
		return count;
	}
	public int findNumberOfNullObjects(Student data[]) {
		int count=0;
		for(int i=0;i<data.length;i++) {
			try {
			if(data[i]==null)
				count++;
			}
		catch(NullPointerException e) {
				
			}
		}
		return count;
	}
}
