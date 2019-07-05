package com.sjg.zuzuCar.Controller;

import com.sjg.zuzuCar.Model.Message;
import com.sjg.zuzuCar.Service.CrudService;
import com.sjg.zuzuCar.Util.ReflectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CrudController
 * @Author song
 * @Date 2019/5/4 18:09
 * 功能:增删改查通用控制器，可以对Model包下面的所有类对应的数据库表进行增删改查
 **/
@RestController
public class CrudController {

    @Autowired
    CrudService crudService;

    /**
     *
     * @Author song
     * @Date 2019/5/28 21:17
     * @Description 功能: 对entity描述的类所对应的表进行增加操作的api
     * @Param 输入：
     * @return 返回：
    **/
    @PostMapping("add/{entity}")
    public Message<?> add(@PathVariable String entity, @RequestBody List<Map> list) {
        List<Object> entityList = new ArrayList<>();
        Message<List> message = new Message<List>();

        for (Map map : list) {
            try {
                //对列表内的每个前端传回的Map进行转换，转换成Entity所描述的类
                entityList.add(ReflectUtil.mapToModel(entity, map));
                message.setData(crudService.add(entityList));
            } catch (ClassNotFoundException|NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
                message.setSuccess(false);
                message.setMsg("要添加的类不存在");
                return message;
            }
        }

        //将转换后的对象添加到数据库
        message.setSuccess(true);
        message.setMsg("添加成功");

        return message;
    }

    /**
     *
     * @Author pxxx
     * @Date 2019/5/28 21:18
     * @Description 功能: 对entity所描述的类进行查询操作，根据前端传回的对每个属性的正则表达式约束，
     * 若是任意一个个属性没有跟正则表达式匹配， 则不返回此条数据
     * @Param 输入：
     * @return 返回：
    **/
    @PostMapping("read/{entity}")
    public Message<?> read(@PathVariable String entity, @RequestBody Map condition) {
        List readresult = null;
        try {
            readresult = crudService.read(entity);
        } catch (ClassNotFoundException|NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException  e) {
            e.printStackTrace();
        }
        if (readresult == null) {
            System.out.println("readresult返回的值为空");
        }
        Message<List> message = new Message<List>();
        List result = new ArrayList();
        Outer:
        for (Object o : readresult) {
            Field[] fields = o.getClass().getDeclaredFields();
            Inner:
            for (int i = 0; i < fields.length; i++) {
                String resultByMap = (String) condition.get(fields[i].getName());
                String resultByExample = null;
                try {
                    resultByExample = ReflectUtil.getFieldValueByName(fields[i].getName(), o) + "";
                } catch (ClassNotFoundException|NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException  e) {
                    message.setSuccess(false);
                    message.setMsg("查找失败");
                    return message;
                }
                if (resultByMap == null) {
                    continue Inner;
                }
                if (!resultByExample.matches(resultByMap)) {
                    continue Outer;
                }
            }
            result.add(o);

        }
        message.setSuccess(true);
        message.setMsg("查找成功");
        message.setData(result);

        return message;
    }



    /**
     *
     * @Author su
     * @Date 2019/5/28 21:17
     * @Description 功能: 对entity描述的类所对应的表进行删除操作的api
     * @Param 输入：
     * @return 返回：
     **/
    @PostMapping("/delete/{entity}")
    public Message<?> delete(@PathVariable String entity, @RequestBody List<Map> list ) {

        Message<List> message = new Message<List>();
        try {
            crudService.delete(list, entity);
        } catch (ClassNotFoundException|NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException  e) {
            message.setSuccess(false);
            message.setMsg("删除失败");
        }

        //将删除的对象删除
        message.setSuccess(true);
        message.setMsg("删除成功");

        return message;
    }

    /**
     * @Author :Pan_Yuhui
     * @Discription: 对entity描述的类所对应的表进行修改操作的api
     * @param entity
     * @param list
     * @return
     */
    @PostMapping("/update/{entity}")
    public Message<?> update(@PathVariable String entity, @RequestBody List<Map> list) {
        Message<List> message = new Message<List>();
        List<Object> entityList = new ArrayList<>();


        for (Map map : list) {
            try {

                //对列表内的每个前端传回的Map进行转换，转换成Entity所描述的类
                entityList.add(ReflectUtil.mapToModel(entity, map));
            }  catch (ClassNotFoundException|NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException  e) {
                message.setSuccess(false);
                message.setMsg("要修改的类不存在");
                return message;
            }
        }

        //将转换后的对象添加到数据库
        message.setSuccess(true);
        message.setMsg("更新成功");
        try {
            message.setData(crudService.update(entityList));
        } catch (ClassNotFoundException|NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException  e) {
            message.setMsg("更新失败");
            message.setSuccess(false);
        }

        return message;
    }
}

