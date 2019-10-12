import com.longlong.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 对象注入
 */
public class Test2 {

    private ClassPathXmlApplicationContext ctx;

    @Before
    public void before(){
        ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
    }

    @Test
    public void test1(){
        User user1 = (User) ctx.getBean("user1");
        System.out.println(user1);
    }

    @Test
    public void test2(){
        User user2 = (User) ctx.getBean("user2");
        System.out.println(user2);
    }

    @Test
    public void test3(){
        User user3 = (User) ctx.getBean("user3");
        System.out.println(user3);
    }

    @Test
    public void test4(){
        User user4 = (User) ctx.getBean("user4");
        System.out.println(user4);
    }

    @Test
    public void test5(){
        User user5 = (User) ctx.getBean("user5");
        System.out.println(user5);
    }
}
