package com.cy.pj.mybatis.dao;

import com.cy.pj.mybatis.pojo.Student;

import java.util.List;

/**
 * java解释器接口
 */

public interface StudentDao {
    /*
        
     */
    List<Student> findAll();
    int saveStudent(Student student);
    Student findStudentById(Integer id);
    int updateStudentById(Student student);
    int deleteStudentById(Integer id);
}
