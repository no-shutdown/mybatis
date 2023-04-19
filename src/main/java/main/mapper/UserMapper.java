package main.mapper;

import main.pojo.User;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

/**
 * @author xinLin.huang
 * @date 2023/4/12 14:48
 */
public interface UserMapper {
    String xmlSelect();

    @Select("select 'annotation'")
    String annotationSelect();


    @Select("select * from user where id=#{id} and name=#{name}")
//    @Options(statementType = StatementType.STATEMENT)
    User paramSelect(@Param("name") String name, @Param("id") String id);

}
