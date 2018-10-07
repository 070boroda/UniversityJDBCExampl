package com.foxminded.dao;

import java.sql.SQLException;
import java.util.List;
import com.foxminded.universety.Student;

public interface DaoStudent {

    public Student create();

    public Student getById(int id);

    public void update(Student student);

    public void delete(Student student);

    public List<Student> getAll() throws SQLException;
}
