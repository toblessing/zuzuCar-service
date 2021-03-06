package com.sjg.mybatisGenerator.Mapper;

import com.sjg.mybatisGenerator.Model.Order;
import com.sjg.mybatisGenerator.Model.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
* Created by Mybatis Generator on 2019/07/05
*/
public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    long countByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    int deleteByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    @Delete({
        "delete from order",
        "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    @Insert({
        "insert into order (order_id, holder_id, ",
        "reservation_id, license_plate, ",
        "model_id, free_time, ",
        "reservation_time)",
        "values (#{orderId,jdbcType=INTEGER}, #{holderId,jdbcType=INTEGER}, ",
        "#{reservationId,jdbcType=INTEGER}, #{licensePlate,jdbcType=VARCHAR}, ",
        "#{modelId,jdbcType=INTEGER}, #{freeTime,jdbcType=VARCHAR}, ",
        "#{reservationTime,jdbcType=VARCHAR})"
    })
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    int insertSelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    List<Order> selectByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    @Select({
        "select",
        "order_id, holder_id, reservation_id, license_plate, model_id, free_time, reservation_time",
        "from order",
        "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    @ResultMap("com.sjg.mybatisGenerator.Mapper.OrderMapper.BaseResultMap")
    Order selectByPrimaryKey(Integer orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    @Update({
        "update order",
        "set holder_id = #{holderId,jdbcType=INTEGER},",
          "reservation_id = #{reservationId,jdbcType=INTEGER},",
          "license_plate = #{licensePlate,jdbcType=VARCHAR},",
          "model_id = #{modelId,jdbcType=INTEGER},",
          "free_time = #{freeTime,jdbcType=VARCHAR},",
          "reservation_time = #{reservationTime,jdbcType=VARCHAR}",
        "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Order record);
}