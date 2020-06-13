package com.mile1.main;
import com.mile1.bean.*;
import com.mile1.service.*;
import com.mile1.exception.*;

public class StudentMain {
	static Student data[]=new Student[8];
		static{
			for(int i=0;i<data.length;i++) {
				data[i]=new Student();
			}
			data[0]=new Student("Sekar",new int[] {35,35,35});
			data[1]=new Student(null,new int[] {11,22,33});
			data[2]=null;
			data[3]=new Student("Manoj",null);
			data[4]=new Student("Aman",new int[] {50,60,80});
			data[5]=new Student("Manik",new int[] {89,87,90});
			data[6]=new Student("Manu",new int[] {22,11,11});
			data[7]=null;
		}
		public static void main(String args[]) {
			StudentService ss=new StudentService();
			StudentReport sr=new StudentReport();
			System.out.println("Grade Calculation:");
			String x=null;
			for(int i=0;i<data.length;i++) {
				try {
					x=sr.validate(data[i]);
				}
				catch(NullNameException e) {
					x="NullNameException occured";
				}
				catch(NullMarksArrayException e) {
					x="NullMarksArrayExcepton occured";
				}
				catch(NullStudentException e) {
					x="NullStudentException occured";
				}
				System.out.println("Grade="+x);
			}
			System.out.println("Number of objects with marks array as null="+ss.findNumberOfNullObjects(data));
			System.out.println("Number of objects with Name as null="+ss.findNumberOfNullName(data));
			System.out.println("Number of objects that are entirely null="+ss.findNumberOfNullObjects(data));
		}
}
