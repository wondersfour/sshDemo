/*package com.imooc.util;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import cn.itsource.util.JdbcUtil;
import cn.itsource.util.StringUtil;
 
*//**
 * 该Dao层的基类实现了基本的CRUD操作
 * 
 * @author lv
 *//*
public class Basedao<T> {
 
  *//**
   * 该方法执行所有的增删改
   * 
   * @paramsql
   * @paramobjects
   * @return
   * @throwsException
   *//*
  protected boolean update(String sql, Object... objects) throws Exception {
  //声明连接变量
  Connection connection= null;
  //声明动态语句变量
  PreparedStatement psmt= null;
  //声明查询结果集变量
  ResultSet resultSet= null;
  //获取工具类实例
  JdbcUtil util= JdbcUtil.getInstance();
  try{
  //通过工具类实例获取连接对象
  connection= util.getConn();
  //通过连接对象获取动态语句对象，并且预编译sql语句
  psmt= connection.prepareStatement(sql);
  //给sql中的参数赋值
  if(objects!= null) {
  for(int i= 0; i< objects.length; i++) {
  //第一个?索引是1，所以在数组下标的基础上+1，值为数组中对应的元素值
  psmt.setObject(i+ 1, objects[i]);
  }
  }
  //执行增删改操作
  int executeUpdate= psmt.executeUpdate();
  //提交事务
  connection.commit();
  //如果执行sql的返回值是1，曾表示成功，否则执行sql失败
  return executeUpdate== 1 ? true: false;
  } catch(SQLException e) {
  e.printStackTrace();
  //有异常，回滚事务
  connection.rollback();
  } finally{
  //释放资源
  util.close(connection, psmt, resultSet);
  }
  return false;
  }
 
  *//**
   * 该方法执行所有的查询操作，并且将查询的数据封装到一个集合中
   * 
   * @paramsql
   * @paramclazz
   * @paramobjects
   * @return
   * @throwsException
   *//*
  protectedList<T> query(String sql, Class<T> clazz, Object... objects) throwsException {
  //声明连接变量
  Connection connection= null;
  //声明动态语句变量
  PreparedStatement psmt= null;
  //声明查询结果集变量
  ResultSet resultSet= null;
  //获取工具类实例
  JdbcUtil util= JdbcUtil.getInstance();
  //声明集合变量
  ArrayList<T> list= null;
  try{
  //通过工具类实例获取连接对象
  connection= util.getConn();
  //通过连接对象获取动态语句对象，并且预编译sql语句
  psmt= connection.prepareStatement(sql);
  //给sql中的参数赋值
  if(objects!= null) {
  for(inti= 0; i< objects.length; i++) {
  //第一个?索引是1，所以在数组下标的基础上+1，值为数组中对应的元素值
  psmt.setObject(i+ 1, objects[i]);
  }
  }
  //执行查询操作
  resultSet= psmt.executeQuery();
    //通过查询结果集对象获取对象的列的数量，类型和属性，并且封装到 列信息的对象ResultSetMetaData中
  ResultSetMetaData metaData= resultSet.getMetaData();
  //通过列信息的对象ResultSetMetaData查询当前对象中的列的数量
  intcolumnCount= metaData.getColumnCount();
  //判断如果有列信息对象不为null，将ResultSetMetaData对象中的字段值封装到Java中的对应类的对象中
  if(metaData!= null) {
  //创建集合对象
  list= newArrayList<>();
  //遍历结果集
  while(resultSet.next()) {
  //通过反射创建对象
  T o= clazz.getConstructor().newInstance();
  //根据ResultSetMetaData中列的数量，遍历获取列的值，给Java中对应的对象字段赋值
  for(inti= 0; i< columnCount; i++) {
  //根据ResultSetMetaData对象获取数据库中字段名（数据库中该字段名和Java中对应的JavaBean中的字段名必须已经约定好对应的规则）
  String columnName= metaData.getColumnName(i+ 1);
  //将数据库字段根据约定规则，调用StringUtil工具类，转换为JavaBean中的字段名，再根据该字段名获取字段对象
  Field field= clazz.getDeclaredField(StringUtil.lineToHump(columnName));
  //由于字段是private修饰，所以赋值之前，要先破坏封装
  field.setAccessible(true);
  //给对应的字段赋值
  setFieldValue(field, resultSet, i, o);
  }
  //将每一个对象添加到集合中
  list.add(o);
  }
  }
  } catch(SQLException e) {
  e.printStackTrace();
  } catch(IllegalAccessException e) {
  e.printStackTrace();
  } catch(InstantiationException e) {
  e.printStackTrace();
  } catch(NoSuchMethodException e) {
  e.printStackTrace();
  } catch(InvocationTargetException e) {
  e.printStackTrace();
  } catch(NoSuchFieldException e) {
  e.printStackTrace();
  } finally{
  //释放资源
  util.close(connection, psmt, resultSet);
  }
  return list;
  }
 
  *//**
   * 该方法执行根据ID查询操作，并且将查询的数据封装到一个对象中
   * 
   * @paramsql
   * @paramclazz
   * @paramid
   * @return
   * @throwsException
   *//*
  protectedT queryById(String sql, Class<T> clazz, longid) throwsException {
  T o= null;
  //声明连接变量
  Connection connection= null;
  //声明动态语句变量
  PreparedStatement psmt= null;
  //声明查询结果集变量
  ResultSet resultSet= null;
  //获取工具类实例
  JdbcUtil util= JdbcUtil.getInstance();
  try{
  //通过工具类实例获取连接对象
  connection= util.getConn();
  //通过连接对象获取动态语句对象，并且预编译sql语句
  psmt= connection.prepareStatement(sql);
  //给sql中的参数赋值
  psmt.setLong(1,id);
  //执行查询操作
  resultSet= psmt.executeQuery();
  //通过查询结果集对象获取对象的列的数量，类型和属性，并且封装到 列信息的对象ResultSetMetaData中
  ResultSetMetaData metaData= resultSet.getMetaData();
  //通过列信息的对象ResultSetMetaData查询当前对象中的列的数量
  intcolumnCount= metaData.getColumnCount();
  //判断如果有列信息对象不为null，将ResultSetMetaData对象中的字段值封装到Java中的对应类的对象中
  if(metaData!= null) {
  //遍历结果集
  while(resultSet.next()) {
  //通过反射创建对象
  o= clazz.getConstructor().newInstance();
  //根据ResultSetMetaData中列的数量，遍历获取列的值，给Java中对应的对象字段赋值
  for(inti= 0; i< columnCount; i++) {
  //根据ResultSetMetaData对象获取数据库中字段名（数据库中该字段名和Java中对应的JavaBean中的字段名必须已经约定好对应的规则）
  String columnName= metaData.getColumnName(i+ 1);
  //将数据库字段根据约定规则，调用StringUtil工具类，转换为JavaBean中的驼峰字段名，再根据该字段名获取字段对象
  Field field= clazz.getDeclaredField(StringUtil.lineToHump(columnName));
  //由于字段是private修饰，所以赋值之前，要先破坏封装
  field.setAccessible(true);
  //给对应的字段赋值
  setFieldValue(field, resultSet, i, o);
  }
  }
  }
  } catch(SQLException e) {
  e.printStackTrace();
  } catch(IllegalAccessException e) {
  e.printStackTrace();
  } catch(InstantiationException e) {
  e.printStackTrace();
  } catch(NoSuchMethodException e) {
  e.printStackTrace();
  } catch(InvocationTargetException e) {
  e.printStackTrace();
  } catch(NoSuchFieldException e) {
  e.printStackTrace();
  } finally{
  //释放资源
  util.close(connection, psmt, resultSet);
  }
  returno;
  }
 
 
  *//**
   * 查询数据条数
   * 
   * @paramsql
   * @paramobjects
   * @return
   * @throwsException
   *//*
  protectedlonggetQueryCount(String sql,Object... objects) throwsException {
  //声明变量，保存行数
  longrow= 0;
  //声明连接变量
  Connection connection= null;
  //声明动态语句变量
  PreparedStatement psmt= null;
  //声明查询结果集变量
  ResultSet resultSet= null;
  //获取工具类实例
  JdbcUtil util= JdbcUtil.getInstance();
  try{
  //通过工具类实例获取连接对象
  connection= util.getConn();
  //通过连接对象获取动态语句对象，并且预编译sql语句
  psmt= connection.prepareStatement(sql);
  //给sql中的参数赋值
  if(objects!= null) {
  for(inti= 0; i< objects.length; i++) {
  //第一个?索引是1，所以在数组下标的基础上+1，值为数组中对应的元素值
  psmt.setObject(i+ 1, objects[i]);
  }
  }
  //执行查询操作
  resultSet= psmt.executeQuery();
  //将光标移动到此ResultSet对象中的最后一行
  resultSet.last();
  //获取当前光标所在行的行号
  row= resultSet.getRow();
  } catch(SQLException e) {
  e.printStackTrace();
  } finally{
  //释放资源
  util.close(connection, psmt, resultSet);
  }
  returnrow;
  }
  
  *//**
   * 给对象中字段Field赋值
   * 
   * @paramfield
   * @paramresultSet
   * @parami
   * @paramo
   *//*
  privatevoidsetFieldValue(Field field, ResultSet resultSet, inti, Object o){
  if(field== null|| resultSet== null|| o== null){
  return;
  }
  //获取字段数据类型
  Class<?> type= field.getType();
  try{
  //根据字段的数据类型给JavaBean中字段赋对应类型的值
  if(type== byte.class|| type== Byte.class) {
  field.setByte(o, resultSet.getByte(i+ 1));
  } elseif(type== short.class|| type== Short.class) {
  field.setShort(o, resultSet.getShort(i+ 1));
  } elseif(type== int.class|| type== Integer.class) {
  field.setInt(o, resultSet.getInt(i+ 1));
  } elseif(type== long.class|| type== Long.class) {
  field.setLong(o, resultSet.getLong(i+ 1));
  } elseif(type== float.class|| type== Float.class) {
  field.setFloat(o, resultSet.getFloat(i+ 1));
  } elseif(type== double.class|| type== Double.class) {
  field.setDouble(o, resultSet.getDouble(i+ 1));
  } elseif(type== boolean.class|| type== Boolean.class) {
  field.setBoolean(o, resultSet.getBoolean(i+ 1));
  } elseif(type== Date.class) {
  //Date类型
  field.set(o, resultSet.getDate(i+ 1));
  } elseif(type== String.class) {
  //String类型
  field.set(o, resultSet.getString(i+ 1));
  } else{
  //其它类型
  field.set(o, resultSet.getObject(i+ 1));
  }
  } catch(IllegalArgumentException e) {
  e.printStackTrace();
  } catch(IllegalAccessException e) {
  e.printStackTrace();
  } catch(SQLException e) {
  e.printStackTrace();
  }
  }
}
*/