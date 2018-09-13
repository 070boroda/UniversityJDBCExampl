package com.foxminded.universety;

import java.util.List;

public class Group {
	
	private List<Student> groupNumber;
	
	public void addStudent(Student student){
		groupNumber.add(student);
	}
}
