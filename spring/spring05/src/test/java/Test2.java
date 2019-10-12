import com.longlong.bean.Person;
import com.longlong.bean.User;
import com.longlong.config.JavaConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * java实现自动配置
 */
public class Test2 {

    private AnnotationConfigApplicationContext ctx;

    @Before
    public void before(){
        ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
    }

    @Test
    public void test1(){
        User user = (User) ctx.getBean("user");
        System.out.println(user);
    }

    @Test
    public void test2(){
        Person p1 = (Person) ctx.getBean("p1");
        p1.sayHello("longlong");
    }
}
