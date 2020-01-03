package top.woilanlan.bill;

import org.junit.Test;
import top.woilanlan.bill.bean.EventType;

public class EnumTest {

    /*
    枚举类型，测试
     */
    @Test
    public void test(){
        EventType eventType = EventType.OTHER;
        switch (eventType) {
            case SCAN:
                System.out.println("扫码");
                break;
            case SUBSCRIBE:
                System.out.println("绑定");
                break;
            case UNSUBSCRIBE:
                System.out.println("解绑");
                break;
            case OTHER:
            default:
                System.out.println("其他");
                break;
        }
        for (EventType s : EventType.values()){
            System.out.println(s + " :ordinal " + s.ordinal());
            System.out.println(s.compareTo(EventType.SUBSCRIBE));
            System.out.println(s.equals(EventType.SUBSCRIBE));
            System.out.println(s == EventType.SUBSCRIBE);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("----------------------");
        }
    }
}
