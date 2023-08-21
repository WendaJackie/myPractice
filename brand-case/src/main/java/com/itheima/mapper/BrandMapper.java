package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap") //用ResultMap做了一个映射：因为你的数据库里的名称和Brand类里的名称是不对应的。
    //一个是下划线的命名方式，一个是驼峰命名方式。
    List<Brand> selectAll();

    @Insert("insert into tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status});")
    void add(Brand brand);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 分页查询
     * @param begin
     * @param size
     * @return
     */
    @Select("select * from tb_brand limit #{begin}, #{size}")
    @ResultMap("brandResultMap")
    List<Brand> selectByPage(@Param("begin") int begin, @Param("size") int size);

    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(*) from tb_brand")
    int selectTotalCount();

    /**
     * 分页条件查询
     * @param begin
     * @param size
     * @return
     */
    //@Select("select * from tb_brand limit #{begin}, #{size}")
    //@ResultMap("brandResultMap")
    List<Brand> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("brand") Brand brand);

    /**
     * 根据条件查询总记录数
     * @return
     */
    //@Select("select count(*) from tb_brand")
    int selectTotalCountByCondition(Brand brand);
    //这里没有使用Param注解，故在xml文件里面brandName直接使用就OK了

}
