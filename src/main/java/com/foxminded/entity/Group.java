package com.foxminded.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Group {
	
	private int id;
    private String name;
    
    public Group(int id) {
    	this.id = id;
    }

    public Group(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
