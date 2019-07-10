package com.sjg.zuzuCar.Mapper.custom;

import com.sjg.zuzuCar.Mapper.ReservationFormMapper;
import com.sjg.zuzuCar.Model.ReservationForm;
import com.sjg.zuzuCar.Model.custom.ReservationFormCustom;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ReservationFormCustomMapper
 * @Author ble
 * @Date 2019/7/9 9:17
 * 功能:
 **/
public interface ReservationFormCustomMapper extends ReservationFormMapper {


    @Select({
            "select",
            "reservation_form.*,",
            "models.model_name,",
            "account.user_name,",
            "account.net_name,",
            "account.phone",
            "from reservation_form,models,account",
            "where reservation_form.holder_id = account.account_id and reservation_form.model_id = models.model_id",
            "and reservation_form.reservation_id is null and  reservation_form.free_end_time > unix_timestamp(now())"
    })
    @ResultMap("com.sjg.zuzuCar.Mapper.custom.ReservationFormCustomMapper.BaseResultMap")
    List<ReservationFormCustom> selectFreeWithForeignKey();

    @Select({
            "select",
            "reservation_form.*,",
            "models.model_name,",
            "account.user_name,",
            "account.net_name,",
            "account.phone",
            "from reservation_form,models,account",
            "where reservation_form.holder_id = account.account_id and reservation_form.model_id = models.model_id",
            "and reservation_form.reservation_id= #{accountId,jdbcType=INTEGER}"
    })
    @ResultMap("com.sjg.zuzuCar.Mapper.custom.ReservationFormCustomMapper.BaseResultMap")
    List<ReservationFormCustom> selectByReservationId(Integer accountId);

    @Select({
            "select",
            "reservation_form.*,",
            "models.model_name,",
            "account.user_name,",
            "account.net_name,",
            "account.phone",
            "from reservation_form,models,account",
            "where reservation_form.holder_id = account.account_id and reservation_form.model_id = models.model_id",
            "and reservation_form.holder_id= #{accountId,jdbcType=INTEGER}"
    })
    @ResultMap("com.sjg.zuzuCar.Mapper.custom.ReservationFormCustomMapper.BaseResultMap")
    List<ReservationFormCustom> selectByHolderId(Integer accountId);

}
