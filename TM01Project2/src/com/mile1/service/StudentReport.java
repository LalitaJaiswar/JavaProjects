package com.mile1.service;
import com.mile1.bean.Student;
import com.mile1.exception.*;
public class StudentReport {
	public String findGrade(Student studentObject) 
	{
		int res=0,n=studentObject.marks.length;
		for(int i=0;i<n;i++) {
			if(studentObject.marks[i]<35)
				return("F");
			else {
				res=res+studentObject.marks[i];
			}
		}
		if(res<=150)
			return("D");
		else if(res>150 && res<=200)
			return("C");
		else if(res>200 && res<=250)
			return("B");
		else
			return("A");
	}
	public String validate(Student studentObject) throws NullStudentException,NullMarksArrayException,NullNameException
	{
		if(studentObject==null)
			throw new NullStudentException();
		else {
			if(studentObject.name==null)
				throw new NullNameException();
			else if(studentObject.marks==null)
				throw new NullMarksArrayException();
		}
		return(new StudentReport().findGrade(studentObject));
	}
}
