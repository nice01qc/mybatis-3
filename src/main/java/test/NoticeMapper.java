package test;

import org.apache.ibatis.annotations.Param;
import test.entity.Bloger;
import test.entity.Post;

import java.util.List;

@Haha(value = "nice01qc")
public interface NoticeMapper {

  Notice selectOneNotice(@Param("id") int id);
}
