package com.sjg.zuzuCar.Service;

import com.sjg.zuzuCar.Mapper.custom.ReservationFormCustomMapper;
import com.sjg.zuzuCar.Model.ReservationForm;
import com.sjg.zuzuCar.Model.custom.ReservationFormCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ReservationFormService
 * @Author ble
 * @Date 2019/7/9 9:45
 * 功能:
 **/
@Service
public class ReservationFormService {

    @Autowired
    private ReservationFormCustomMapper reservationFormCustomMapper;

    public List<ReservationFormCustom> readFreeOrder(){

        return reservationFormCustomMapper.selectFreeWithForeignKey();
    }

    public List<ReservationFormCustom> readOrderByReservationId(Integer accountId) {
        return reservationFormCustomMapper.selectByReservationId(accountId);
    }
    public List<ReservationFormCustom> readOrderByHolderId(Integer accountId) {
        return reservationFormCustomMapper.selectByHolderId(accountId);
    }

    public int add(ReservationForm order) {
        return reservationFormCustomMapper.insertSelective(order);
    }

    public int update(ReservationForm order) {
        return reservationFormCustomMapper.updateByPrimaryKeySelective(order);
    }
}
