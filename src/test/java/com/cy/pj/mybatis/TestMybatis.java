package com.cy.pj.mybatis;

import com.cy.pj.mybatis.pojo.Student;
import com.cy.pj.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    @Test
    public void  testRefresh(){
        try {
            Class<?> stuClass = Class.forName("com.cy.pj.mybatis.pojo.Student");
            Student student = (Student) stuClass.newInstance();
            Student student2 = (Student) stuClass.newInstance();
            System.out.println(student);
            System.out.println(student2);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void  testFindAll(){
        SqlSession sqlSession = null;
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            List<Student> list = sqlSession.selectList("com.cy.pj.mybatis.dao.StudentDao.findAll");
            for (Student student : list){
                System.out.println(student);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }

    @Test
    public void testSaveStudent(){
        SqlSession sqlSession = null;
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            sqlSession = sqlSessionFactory.openSession(true);
            Student student = new Student(1004,"张无忌","男","mysql",98.0);
            int row = sqlSession.insert("com.cy.pj.mybatis.dao.StudentDao.saveStudent",student);
            System.out.println("受影响行数为：" + row);
            testFindAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }
    }

    @Test
    public void testFindStudentById(){
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()){
            Student student = sqlSession.selectOne("com.cy.pj.mybatis.dao.StudentDao.findStudentById", 1004);
            System.out.println(student);
        }
    }

    @Test
    public void testUpdateStudentById(){
        Student student = new Student(1004, "张无忌", "男", "mysql", 96.0);
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()){
            int row = sqlSession.update("com.cy.pj.mybatis.dao.StudentDao.updateStudentById", student);
            System.out.println("受影响行数为：" + row);
            testFindAll();
        }
    }

    @Test
    public void testDeleteStudentById(){
        try (SqlSession sqlSession = SqlSessionUtil.getSqlSession()){
            int row = sqlSession.delete("com.cy.pj.mybatis.dao.StudentDao.deleteStudentById", 1004);
            System.out.println("受影响行数为：" + row);
            testFindAll();
        }
    }
}
