import com.longlong.Book;
import com.longlong.JavaConfig;
import org.junit.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    private AnnotationConfigApplicationContext ctx;

    @Before
    public void before(){
        ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
    }

    @org.junit.Test
    public void test1(){
        Book book1 = ctx.getBean(Book.class);
        System.out.println(book1);
    }

    @org.junit.Test
    public void test2(){
        Book book = (Book) ctx.getBean("b1");
        System.out.println(book);
    }
}
