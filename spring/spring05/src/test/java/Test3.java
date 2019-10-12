import com.longlong.bean.DataSource;
import com.longlong.bean.Person;
import com.longlong.bean.RedisConfig;
import com.longlong.config.JavaConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Java配置实现profile
 */
public class Test3 {

    private AnnotationConfigApplicationContext ctx;

    @Before
    public void before(){
        ctx = new AnnotationConfigApplicationContext();
        //设置当前环境为开发环境（dev）
        ctx.getEnvironment().setActiveProfiles("dev");
        ctx.register(JavaConfig.class);
        ctx.refresh();
    }

    @Test
    public void test1(){
        DataSource ds = (DataSource) ctx.getBean("ds");
        System.out.println(ds);
    }

    @Test
    public void test2(){
        RedisConfig rc = (RedisConfig) ctx.getBean("rc");
        System.out.println(rc);
    }

}
