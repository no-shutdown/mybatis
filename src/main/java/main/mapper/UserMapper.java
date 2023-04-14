package main.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @author xinLin.huang
 * @date 2023/4/12 14:48
 */
public interface UserMapper {
    String xmlSelect();
    @Select("select 'annotation'")
    String annotationSelect();
}
