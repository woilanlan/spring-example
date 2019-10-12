import com.longlong.User;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    private ClassPathXmlApplicationContext ctx;

    @Before
    public void before(){
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @org.junit.Test
    public void test1(){
        User user = ctx.getBean(User.class);
        user.sayHello("普通构造方法创建");
    }

    @org.junit.Test
    public void test2(){
        User user2 = (User) ctx.getBean("user2");
        user2.sayHello("静态工厂创建");
    }

    @org.junit.Test
    public void test3(){
        User user3 = (User) ctx.getBean("user3");
        user3.sayHello("实例工厂创建");
    }
}
