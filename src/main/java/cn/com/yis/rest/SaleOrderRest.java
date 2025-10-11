package cn.com.yis.rest;

import cn.com.yis.domain.SaleOrder;
import cn.com.yis.service.SaleOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/order")
public class SaleOrderRest {

    @Autowired
    private SaleOrderService saleOrderService;

    /**
     * 新增订单
     *
     * @param saleOrder
     * @return
     */
    @RequestMapping("/add")
    public boolean add(SaleOrder saleOrder) {
        return saleOrderService.save(saleOrder);
    }

    /**
     * 查询订单详情
     *
     * @param id
     * @return
     */
    @RequestMapping("/detail")
    public SaleOrder detail(Long id) {
        log.info("查询订单详情，id={}", id);
        return saleOrderService.getById(id);
    }

}
