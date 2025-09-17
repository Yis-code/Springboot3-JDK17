package cn.com.yis.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("sale_order")
public class SaleOrder {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField(value = "order_no")
    private String orderNo;
    @TableField(value = "customer_name")
    private String customerName;
    @TableField(value = "customer_phone")
    private String customerPhone;
    @TableField(value = "customer_address")
    private String customerAddress;
    @TableField(value = "order_amount")
    private BigDecimal orderAmount;
    @TableField(value = "order_status")
    private String orderStatus;
    @TableField(value = "create_time")
    private Date createTime;
    @TableField(value = "update_time")
    private Date updateTime;
    @TableField(value = "deleted")
    private Boolean deleted;
    @TableField(value = "remark")
    private String remark;
}
