import com.sxsqli.domain.User;
import com.sxsqli.mapper.UserMapper;
import com.sxsqli.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    private SqlSession sqlSession;
    private UserMapper userMapper;

    @Before
    public void init() {
        sqlSession = MybatisUtils.getSqlSessionFactory().openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testFindAll() {
        List<User> users = userMapper.findAll();
        for (User user : users) {
            System.out.println(user.getUsername());
        }
    }

    @Test
    public void testFindByUser() {
        User user = new User();
        user.setUid(1);
        user.setUsername("xmu");
        user.setPassword("wlis9527");
        List<User> users = userMapper.findByUser(user);
        for (User u : users) {
            System.out.println(u.getUsername());
        }
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("xmuwl");
        user.setPassword("wlis9527");
        try {
            int insert = userMapper.insert(user);
            System.out.println(insert);
        } catch (Exception e) {
            System.out.println("wrong");
        }
    }
    @Test
    public void testDelete() {
        User user = new User();
        user.setUsername("xmuwl");
        user.setPassword("wlis9527");
        try {
            int insert = userMapper.delete(user);
            System.out.println(insert);
        } catch (Exception e) {
            System.out.println("wrong");
        }
    }
    @Test
    public void testUpdate() {
        User user = new User();
        user.setUid(5);
        user.setUsername("xmu");
        user.setPassword("wlis9527");
        try {
            int insert = userMapper.update(user);
            System.out.println(insert);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("wrong");
        }
    }
}
