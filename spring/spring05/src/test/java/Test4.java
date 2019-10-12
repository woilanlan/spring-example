import com.longlong.bean.DataSource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * xml配置实现profile
 */
public class Test4 {

    private ClassPathXmlApplicationContext ctx;

    @Before
    public void before(){
        ctx = new ClassPathXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles("prod");
        ctx.setConfigLocation("applicationContext.xml");
        ctx.refresh();
    }

    @Test
    public void test1(){
        DataSource ds = (DataSource) ctx.getBean("ds");
        System.out.println(ds);
    }
}
