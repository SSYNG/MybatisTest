package cn.ssy.dao;

import cn.ssy.pojo.User;
import cn.ssy.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;

public class UserDaoTest {

    @Test
    public void test() {
        //1.获得sqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //2.执行sql
        //方式1：getMapper[推荐]
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userlist = mapper.getuserlist();
        //方式2：
        userlist = sqlSession.selectList("cn.ssy.dao.UserMapper.getuserlist");

        for (User user : userlist) {
            System.out.println(user);
        }
        //关闭sqlSession
        sqlSession.close();
    }

}
