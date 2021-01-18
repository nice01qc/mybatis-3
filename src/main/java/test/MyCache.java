package test;

import org.apache.ibatis.cache.Cache;

import java.util.concurrent.ConcurrentHashMap;

public class MyCache implements Cache {
  String id;
  ConcurrentHashMap<Object, Object> cache = new ConcurrentHashMap<>(100);

  public MyCache() {
  }

  public MyCache(String id){
    System.out.println("myCache id....." + id);
    this.id = id;
  }

  @Override
  public String getId() {
    System.out.println("MyCache getId......");
    return this.id;
  }

  @Override
  public void putObject(Object key, Object value) {
    System.out.println("MyCache putObject......");
    cache.put(key, value);
  }

  @Override
  public Object getObject(Object key) {
    System.out.println("MyCache getObject......");
    return cache.get(key);
  }

  @Override
  public Object removeObject(Object key) {
    System.out.println("MyCache removeObject......");
    return cache.remove(key);
  }

  @Override
  public void clear() {
    System.out.println("MyCache clear......");
    cache.clear();
  }

  @Override
  public int getSize() {
    System.out.println("MyCache getSize......");
    return cache.size();
  }
}
