package test;


/**
 * 用于切换数据源
 */
public class DatabaseContextHolder {

  // 线程安全容器，用于高并发情况下，保证切换数据源一致
  private static ThreadLocal<String> local = new ThreadLocal<>();

  /**
   * 设置数据源
   */
  public static void setDataSource(String name) {
    local.set(name);
    System.out.println(local.get());
  }

  /**
   * 获取当前数据源
   * @return
   */
  public static String getDataSource() {
    return local.get();
  }

}
