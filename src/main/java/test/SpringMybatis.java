package test;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.ibatis.io.Resources;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class SpringMybatis {
  public static void main(String[] args) throws Exception {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://192.168.138.132:3306/test?serverTimezone=GMT");
    dataSource.setUsername("root");
    dataSource.setPassword("1234");


    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    factoryBean.setDataSource(dataSource);
    InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

//    factoryBean.setMapperLocations(new Resource[]{new InputStreamResource(inputStream)});
    factoryBean.setConfigLocation(new InputStreamResource(inputStream));
    factoryBean.afterPropertiesSet();

    MapperFactoryBean<NoticeMapper> mapperFactoryBean = new MapperFactoryBean<>();
    mapperFactoryBean.setMapperInterface(NoticeMapper.class);
    mapperFactoryBean.setSqlSessionFactory(factoryBean.getObject());

    NoticeMapper object = mapperFactoryBean.getObject();

    Notice notice = object.selectOneNotice(1);
    object.selectOneNotice(1);
    object.selectOneNotice(1);
    System.out.println(notice);


  }
}
