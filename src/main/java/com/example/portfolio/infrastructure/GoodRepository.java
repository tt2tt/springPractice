package com.example.portfolio.infrastructure;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface GoodRepository {
    @Insert("insert into goods (userId,partnerId) values ((SELECT id FROM users WHERE name = #{name}),#{partnerId})")
    void cretaeGood(String name, Integer partnerId);

    @Update("UPDATE users SET goodsCount = #{goodsCount} WHERE id = #{partnerId}")
    void goodCountUp(Integer goodsCount, Integer partnerId);
}
