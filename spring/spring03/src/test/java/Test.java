import com.longlong.Book;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    private ClassPathXmlApplicationContext ctx;

    @Before
    public void before() {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    /**
     * 构造方法注入
     */
    @org.junit.Test
    public void test1(){
        Book book1 = (Book) ctx.getBean("book1");
        System.out.println(book1);
    }

    /**
     * 通过下标定位参数
     */
    @org.junit.Test
    public void test2(){
        Book book2 = (Book) ctx.getBean("book2");
        System.out.println(book2);
    }

    /**
     * 先调用无参构造方法，然后调用set方法
     */
    @org.junit.Test
    public void test3(){
        Book book3 = (Book) ctx.getBean("book3");
        System.out.println(book3);
    }

    /**
     * p名称空间注入
     */
    @org.junit.Test
    public void test4(){
        Book book4 = (Book) ctx.getBean("book4");
        System.out.println(book4);
    }

}
