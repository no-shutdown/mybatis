package main;

import main.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

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
        SqlSessionFactory build = builder.build(input);
        UserMapper mapper = build.openSession().getMapper(UserMapper.class);
        System.out.println(mapper.xmlSelect());
    }
}
