package com.cy.pj.mybatis;

import com.cy.pj.mybatis.dao.StudentDao;
import com.cy.pj.mybatis.pojo.Student;
import com.cy.pj.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMybatisMapper {
    @Test
    public void testFindAll(){
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()){
            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
            List<Student> list = studentDao.findAll();
            for (Student student : list){
                System.out.println(student);
            }
        }
    }

    @Test
    public void testSaveStudent(){
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()){
            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
            Student student = new Student(1004, "张无忌", "男", "mysql", 97.0);
            int row = studentDao.saveStudent(student);
            System.out.println("受影响行数为：" + row);
            testFindAll();
        }
    }

    @Test
    public void testFindStudentById(){
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()){
            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
            Student student = studentDao.findStudentById(1004);
            System.out.println(student);
        }
    }

    @Test
    public void testUpdateStudentById(){
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()){
            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
            Student student = new Student(1004, "张无忌", "男", "sql", 96.0);
            int row = studentDao.updateStudentById(student);
            System.out.println("受影响行数为：" + row);
            testFindAll();
        }
    }

    @Test
    public void testDeleteStudentById(){
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()){
            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
            int row = studentDao.deleteStudentById(1004);
            System.out.println("受影响行数为：" + row);
            testFindAll();
        }
    }
}
