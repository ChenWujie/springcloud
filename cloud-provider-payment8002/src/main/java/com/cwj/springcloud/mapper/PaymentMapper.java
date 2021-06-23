package com.cwj.springcloud.mapper;

import com.cwj.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
//@Repository不用Spring的
public interface PaymentMapper {
    @Insert("insert into payment(serial) values(#{serial})")
    public int create(Payment payment);

    @Select("select * from payment where id=#{id}")
    public Payment getPaymentById(@Param("id") Long id);
}
