package top.woilanlan.bill;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.woilanlan.bill.bean.Bill;
import top.woilanlan.bill.mapper.BillMapper;
import top.woilanlan.bill.util.DBUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

public class BillTest {

    private SqlSession sqlSession;
    private BillMapper billMapper;

    @Before
    public void Before(){
       sqlSession = DBUtils.getInstance().openSession();
       billMapper = sqlSession.getMapper(BillMapper.class);
    }

    @After
    public void After(){
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test1(){
        Bill bill = new Bill();
        bill.setName("two");
        bill.setMoney(new BigDecimal("99.99"));
        LocalDateTime dateTime = LocalDateTime.now();
        bill.setCreatedTime(dateTime);
        bill.setUpdatedTime(dateTime);
        int insert = billMapper.insert(bill);
        System.out.println(insert);
    }

    @Test
    public void test2(){
        int i = billMapper.deleteByPrimaryKey(7);
        System.out.println(i);
    }

    @Test
    public void test3(){
        Bill bill = new Bill();
        bill.setId(8);
        bill.setName("one");
        bill.setMoney(new BigDecimal("8.01"));
        int i = billMapper.updateByPrimaryKey(bill);
        System.out.println(i);
    }

    @Test
    public void test4(){
        Bill bill = billMapper.selectByPrimaryKey(5);
        System.out.println(bill);
    }

    @Test
    public void test5(){
        List<Bill> bills = billMapper.selectAll();
        System.out.println(bills);
    }

}
