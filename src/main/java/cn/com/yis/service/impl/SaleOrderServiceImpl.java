package cn.com.yis.service.impl;

import cn.com.yis.domain.SaleOrder;
import cn.com.yis.mapper.SaleOrderMapper;
import cn.com.yis.service.SaleOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
* @author yishuai
* @description 针对表【sale_order(订单表)】的数据库操作Service实现
* @createDate 2025-09-07 21:59:45
*/
@Slf4j
@Service
public class SaleOrderServiceImpl extends ServiceImpl<SaleOrderMapper, SaleOrder>
    implements SaleOrderService{

    public SaleOrderServiceImpl() {
        log.info("SaleOrderServiceImpl init");
    }
}




