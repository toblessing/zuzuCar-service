package com.sjg.zuzuCar.Controller;

import com.sjg.zuzuCar.Model.Message;
import com.sjg.zuzuCar.Model.Models;
import com.sjg.zuzuCar.Service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ModelsController
 * @Author ble
 * @Date 2019/7/5 22:33
 * 功能:
 **/

@RestController
public class ModelsController {

    @Autowired
    CrudService crudService;

    @GetMapping("readModels")
    public Message<List> readModels() {
        Message<List> message = new Message<>();
        try {
            message.setData(crudService.read(Models.class.getSimpleName()));
            message.setSuccess(true);
            message.setMsg("查找成功");
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
            message.setSuccess(false);
            message.setMsg("查找失败");
        }
        return  message;
    }
}
