package cn.ssy.dao;

import cn.ssy.pojo.User;
import cn.ssy.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;
import java.util.Scanner;

public class UserDaoTest {

    @Test
    public void test() {
        //1.获得sqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //2.执行sql
        //方式1：getMapper[推荐]
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userlist = mapper.getuserlist();
            //方式2：
            userlist = sqlSession.selectList("cn.ssy.dao.UserMapper.getuserlist");

            for (User user : userlist) {
                System.out.println(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭sqlSession
            sqlSession.close();
        }
    }
    @Test
    public  void  getUserById(){
        int a=0;
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println("请输入要查询的id");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            a = sc.nextInt();
        }
        User user = mapper.getUserById(a);
        System.out.println(user);
        sqlSession.commit();
        sc.close();
        sqlSession.close();
    }
    //增删改均需要提交事务
    //删除
    @Test
    public  void  deleteUserById(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Boolean flag = mapper.deleteUserById(2);
        System.out.println(flag);
        sqlSession.commit();
        sqlSession.close();
    }
    //新增用户
    @Test
    public  void  addUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Boolean flag = mapper.addUser(new User(4,"御坂莉亚","666"));
        System.out.println(flag);
        sqlSession.commit();
        sqlSession.close();
    }
    //更新用户
    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Boolean flag = mapper.updateUser(new User(1,"水卜樱","666"));
        System.out.println(flag);
        sqlSession.commit();
        sqlSession.close();
    }

}
