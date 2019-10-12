import com.longlong.bean.Person;
import com.longlong.bean.User;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * XML配置实现自动配置
 */
public class Test {

    private ClassPathXmlApplicationContext ctx;

    @Before
    public void before(){
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @org.junit.Test
    public void test1(){
        User user = (User) ctx.getBean("user");
        System.out.println(user);
    }

    @org.junit.Test
    public void test2(){
        Person p1 = (Person) ctx.getBean("p1");
        p1.sayHello("longlong");
    }

    /**
     * Bean的作用域
     * 单例（Singleton）：在整个应用中，只创建bean的一个实例
     * 原型（Prototype）：每次注入或者通过Spring应用上下文获取的时候，都会创建一个新的bean实例
     */
    @org.junit.Test
    public void test3(){
        User user = (User) ctx.getBean("user");
        User user1 = (User) ctx.getBean("user");
        System.out.println(user == user1);
    }
}
