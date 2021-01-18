package test;

import org.apache.ibatis.executor.CachingExecutor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Intercepts({
  @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }),
  @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class })
})
public class MyIntercept implements Interceptor {
  private Map<String, String> dataSourceNameMap = new ConcurrentHashMap<>(32);
  @Override
  public Object intercept(Invocation invocation) throws Throwable {

    String dataSourceNameSuffix = "master";
    String dataSourceName = "";
    Object[] args = invocation.getArgs();
    MappedStatement mappedStatement;
    String quryId;
    if (args.length > 0 &&  args[0] !=null && args[0] instanceof MappedStatement){
      mappedStatement = (MappedStatement) args[0];
      if (SqlCommandType.SELECT.equals(mappedStatement.getSqlCommandType())){
        dataSourceNameSuffix = "slave";
      }

      quryId = mappedStatement.getId();
      if (dataSourceNameMap.containsKey(quryId)){
        dataSourceName = dataSourceNameMap.get(quryId);
      }else {
        Class<?> methodClass = Class.forName(quryId.substring(0, quryId.lastIndexOf(".")));
        dataSourceName = methodClass.getAnnotation(Haha.class).value();
        dataSourceNameMap.put(quryId, dataSourceName);
      }
    }else {
      throw new SQLException("mybatis Intercept 拦截出现异常");
    }

    dataSourceName = dataSourceName + "-" + dataSourceNameSuffix;

    DatabaseContextHolder.setDataSource(dataSourceName);
    return invocation.proceed();
  }
}
