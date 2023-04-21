package main;

import main.mapper.UserMapper;
import main.pojo.Demo;
import main.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author xinLin.huang
 * @date 2023/4/12 14:41
 */
public class Main {
    public static void main(String[] args) {
        InputStream input = null;
        try {
            input = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            System.out.println(e.getMessage() + "mybatis-config.xml 文件异常");
        }
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(input);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> user = mapper.refResultSets();
        System.out.println();


    }
}
