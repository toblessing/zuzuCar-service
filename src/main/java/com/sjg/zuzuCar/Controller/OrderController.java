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
    CrudService crudService;

    @Autowired
    ReservationFormService reservationFormService;

    @Autowired
    ReservationFormCustomMapper orderMapper;

    @PostMapping("addOrder")
    public Message<?> addOrder(@RequestBody ReservationForm order) {

        List<Object> entityList = new ArrayList<>();
        Message<List> message = new Message<List>();
        Account account = Tools.getUserFromSeesion();

        if (account != null) {
            order.setHolderId(account.getAccountId());

        } else {
            message.setSuccess(false);
            message.setMsg("您尚未登录，请登录后再试！");
            return message;
        }

        entityList.add(order);
        try {
            message.setData(crudService.add(entityList));
            message.setSuccess(true);
            message.setMsg("添加成功");
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
            message.setSuccess(false);
            message.setMsg("添加失败");
        }
        return message;
    }

    @PostMapping("reservationOrder")
    public Message<?> reservationOrder(@RequestBody ReservationForm order) {

        List<Object> entityList = new ArrayList<>();
        Message<List> message = new Message<List>();
        Account account = Tools.getUserFromSeesion();

        if (account == null) {
            message.setSuccess(false);
            message.setMsg("您尚未登录，请登录后再试！");
            return message;
        }

        ReservationForm eacheOrder = new ReservationForm();
        eacheOrder.setReservationTime(order.getReservationTime());
        eacheOrder.setReservationFormId(order.getReservationFormId());

        entityList.add(eacheOrder);
        try {
            message.setData(crudService.update(entityList));
            message.setSuccess(true);
            message.setMsg("预约成功");
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
            message.setSuccess(false);
            message.setMsg("预约失败");
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
        //获取获取当前时间
        Date date = new Date();
        System.out.println("date:" + date.getTime());

        if (account != null) {
            //创建查询约束
            ReservationFormExample orderExample = new ReservationFormExample();
            orderExample.createCriteria()
                    .andReservationIdEqualTo(account.getAccountId());
            orderExample.setOrderByClause("reservation_time asc");

            try {
                //查询数据
                message.setData(crudService.readByExample(ReservationForm.class.getSimpleName(), orderExample));
                message.setSuccess(true);
                message.setMsg("读取成功");
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
                message.setSuccess(false);
                message.setMsg("读取失败；");
            }
        }
        return message;
    }

    @GetMapping("readAccountReleaseOrder")
    public Message<?> readAccountReleaseOrder() {
        Message<List> message = new Message<List>();

        Account account = Tools.getUserFromSeesion();
        //获取获取当前时间
        Date date = new Date();
        System.out.println("date:" + date.getTime());

        if (account != null) {
            //创建查询约束
            ReservationFormExample orderExample = new ReservationFormExample();
            orderExample.createCriteria()
                    .andHolderIdEqualTo(account.getAccountId());
            orderExample.setOrderByClause("free_start_time asc");

            try {
                //查询数据
                message.setData(crudService.readByExample(ReservationForm.class.getSimpleName(), orderExample));
                message.setSuccess(true);
                message.setMsg("读取成功");
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
                message.setSuccess(false);
                message.setMsg("读取失败；");
            }
        }
        return message;
    }
}
