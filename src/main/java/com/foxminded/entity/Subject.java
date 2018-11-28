package com.foxminded.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    private int id;
    private String name;
    
    @Override
    public String toString() {
        return name;
    }

	public Subject(int id) {
		super();
		this.id = id;
	}

	public Subject(String name) {
		super();
		this.name = name;
	}
	
}
