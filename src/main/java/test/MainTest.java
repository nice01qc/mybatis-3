package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import test.dao.AuthorDao;
import test.entity.Author;
import test.entity.Bloger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainTest {
  public static void main(String[] args) throws IOException {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession session = sqlSessionFactory.openSession(true);

    NoticeMapper mapper = session.getMapper(NoticeMapper.class);
    Notice notice = mapper.selectOneNotice(1);
    System.out.println(notice);
//    session.commit();
  }
}
