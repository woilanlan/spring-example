import com.longlong.cmd.ShowCmd;
import com.longlong.config.JavaConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 条件注解的使用
 */
public class Test5 {

    private AnnotationConfigApplicationContext ctx;

    @Before
    public void before(){
        ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("dev");
        ctx.register(JavaConfig.class);
        ctx.refresh();
    }

    @Test
    public void test1(){
        ShowCmd cmd = (ShowCmd) ctx.getBean("cmd");
        System.out.println(cmd.show());
    }
}
