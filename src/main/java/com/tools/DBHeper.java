package com.tools;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DBHeper {
    private SqlSession sqlSession = null;
    // 单例设计模式：1、构造方法私有化；2、对外需要有个能使用的方法；
    private static DBHeper dbHeper = null;
    private DBHeper(){
    }
    public static DBHeper getInstance() {
        if (dbHeper == null) {
            dbHeper = new DBHeper();
        }

        return dbHeper;
    }

    public SqlSession getSession() {
        try {
            SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
            SqlSessionFactory sf = sfb.build(Resources.getResourceAsStream("mybatis-config.xml"));
            sqlSession = sf.openSession();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }

}
