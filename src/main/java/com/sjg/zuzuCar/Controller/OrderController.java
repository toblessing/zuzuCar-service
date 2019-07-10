package com.sjg.zuzuCar.Controller;

import com.sjg.zuzuCar.Mapper.ReservationFormMapper;
import com.sjg.zuzuCar.Mapper.custom.ReservationFormCustomMapper;
import com.sjg.zuzuCar.Model.Account;
import com.sjg.zuzuCar.Model.Message;
import com.sjg.zuzuCar.Model.ReservationForm;
import com.sjg.zuzuCar.Model.ReservationFormExample;
import com.sjg.zuzuCar.Model.custom.ReservationFormCustom;
import com.sjg.zuzuCar.Service.CrudService;
import com.sjg.zuzuCar.Service.ReservationFormService;
import com.sjg.zuzuCar.Util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderController
 * @Author ble
 * @Date 2019/7/5 22:34
 * 功能:
 **/
@RestController
public class OrderController {
    @Autowired
    ReservationFormService reservationFormService;

    @Autowired
    ReservationFormCustomMapper orderMapper;

    @PostMapping("addOrder")
    public Message<?> addOrder(@RequestBody ReservationForm order) {

        Message<List> message = new Message<List>();
        Account account = Tools.getUserFromSeesion();

        if (account != null) {
            order.setHolderId(account.getAccountId());

        } else {
            message.setSuccess(false);
            message.setMsg("您尚未登录，请登录后再试！");
            return message;
        }

        if (reservationFormService.add(order) !=0){
            message.setSuccess(true);
            message.setMsg("预约成功");
        } else {
            message.setSuccess(false);
            message.setMsg("预约失败");
        }
        return message;
    }

    @PostMapping("reservationOrder")
    public Message<?> reservationOrder(@RequestBody ReservationForm order) {

        Message<List> message = new Message<List>();
        Account account = Tools.getUserFromSeesion();

        if (account == null) {
            message.setSuccess(false);
            message.setMsg("您尚未登录，请登录后再试！");
            return message;
        }
        if(order.getReservationFormId()==null){
            message.setSuccess(false);
            message.setMsg("您没有选择预约单，请重试！");
            return message;
        }
        if(order.getReservationTime()==null){
            message.setSuccess(false);
            message.setMsg("您没有选择时间，请重试！");
            return message;
        }
        ReservationForm eacheOrder = new ReservationForm();
        eacheOrder.setReservationTime(order.getReservationTime());
        eacheOrder.setReservationFormId(order.getReservationFormId());
        eacheOrder.setReservationId(account.getAccountId());
        if (reservationFormService.update(eacheOrder)!=0){
            message.setSuccess(true);
            message.setMsg("预约成功");
        }else {
            message.setSuccess(false);
            message.setMsg("预约失败");
        }
        return message;
    }
    @PostMapping("cancelOrder")
    public Message<?> cancelOrder(@RequestBody ReservationForm order) {

        Message<List> message = new Message<List>();
        Account account = Tools.getUserFromSeesion();

        if (account == null) {
            message.setSuccess(false);
            message.setMsg("您尚未登录，请登录后再试！");
            return message;
        }
        ReservationForm reservationForm = orderMapper.selectByPrimaryKey(order.getReservationFormId());
        if(reservationForm.getReservationFormId()!=order.getReservationFormId()){
            message.setSuccess(false);
            message.setMsg("这不是您的预约单，请检查后重试");
            return message;
        }

        reservationForm.setReservationId(0);
        reservationForm.setReservationTime(0L);
        if (reservationFormService.update(reservationForm)!=0){
            message.setSuccess(true);
            message.setMsg("取消成功");
        }else {
            message.setSuccess(false);
            message.setMsg("取消失败");
        }
        return message;
    }


    @GetMapping("readFreeOrder")
    public Message<?> readFreeOrder() {
        Message<List> message = new Message<List>();
        //获取获取当前时间

        //查询数据
        message.setData(reservationFormService.readFreeOrder());

        message.setSuccess(true);
        message.setMsg("读取成功");

        return message;
    }

    @GetMapping("readAccountReservationOrder")
    public Message<?> readAccountReservationOrder() {
        Message<List> message = new Message<List>();

        Account account = Tools.getUserFromSeesion();
        if (account != null) {

            //查询数据
            message.setData(reservationFormService.readOrderByReservationId(account.getAccountId()));

            message.setSuccess(true);
            message.setMsg("读取成功");

        }else {

            message.setSuccess(false);
            message.setMsg("您尚未登录，请登录后再试！");
        }
        return message;
    }

    @GetMapping("readAccountReleaseOrder")
    public Message<?> readAccountReleaseOrder() {
        Message<List> message = new Message<List>();
        Account account = Tools.getUserFromSeesion();
        if (account != null) {

            //查询数据
            message.setData(reservationFormService.readOrderByHolderId(account.getAccountId()));

            message.setSuccess(true);
            message.setMsg("读取成功");
        }else {

            message.setSuccess(false);
            message.setMsg("您尚未登录，请登录后再试！");
        }
        return message;
    }
}
