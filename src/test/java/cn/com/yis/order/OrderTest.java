package cn.com.yis.order;

import cn.com.yis.domain.SaleOrder;
import cn.com.yis.service.SaleOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootTest
public class OrderTest {

    @Autowired
    private SaleOrderService saleOrderService;

    @Test
    public void testSaveOrder() {
        SaleOrder order = new SaleOrder();
        order.setOrderNo("123213123211");
        order.setCustomerName("yishuai");
        order.setCustomerPhone("13800000000");
        order.setCustomerAddress("beijing");
        order.setOrderAmount(new BigDecimal("100"));
        order.setOrderStatus("1");
        order.setCreateTime(new Date());
        order.setRemark("test");
        saleOrderService.save(order);
    }

    @Test
    public void testQueryOrder() {
        SaleOrder order = saleOrderService.getById(1L);
        System.out.println(order);
    }

}
