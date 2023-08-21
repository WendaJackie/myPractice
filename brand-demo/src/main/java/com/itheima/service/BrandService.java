package com.itheima.service;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有功能
     * @return
     */
    public List<Brand> selectAll(){


        //2.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        List<Brand> brands = mapper.selectAll();

        sqlSession.close();

        return brands;
    }

    /**
     * 添加
     * @param brand
     */
    public void add(Brand brand){
        //2.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.调用添加的方法
        mapper.add(brand);

        //提交事务（由于是增删改的操作，需要提交事务，释放资源）
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }

    /**
     * 根据id查询
     * @return
     */
    public Brand selectById(int id){

        //2.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        Brand brand = mapper.selectByIdBrand(id);

        sqlSession.close();

        return brand;
    }

    /**
     * 修改
     * @param brand
     */
    public void update(Brand brand){
        //2.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.调用添加的方法
        mapper.update(brand);

        //提交事务（由于是增删改的操作，需要提交事务，释放资源）
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }

    /**
     * 根据id删除
     * @return
     */
    public void deleteById(int id){
        //2.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        mapper.deleteById(id);

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }
}
