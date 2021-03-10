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
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println("请输入要查询的id");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        User user = mapper.getUserById(1);
        System.out.println(user);
       sc.close();
        sqlSession.close();

    }

}
