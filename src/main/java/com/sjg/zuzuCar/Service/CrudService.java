package com.sjg.zuzuCar.Service;

import com.sjg.zuzuCar.Util.ReflectUtil;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;


/**
 * @ClassName CrudService
 * @Author song
 * @Date 2019/5/4 21:25
 * 功能:
 **/
@Service
public class CrudService {


    /**
     * @return 返回： 添加后其对应数据库中的所有数据
     * @Author song
     * @Date 2019/5/5 21:17
     * @Description 功能:  将list里面的元素根据其本身的类型，添加到对应的数据库表内
     * @Param 输入： list，里面存储着要添加的数据
     **/
    public List add(List list) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException  {

        //获取要添加的类的Class
        Class classOfEntity = list.get(0).getClass();

        //获取与要添加的类相对应的Mapper
        Object mapperObj = ReflectUtil.getMapperObjOfEntity(classOfEntity);

        //获取对应Mapper的insert方法
        String methodName = "insert";
        Method finalInsert = ReflectUtil.getMethodFromObj(mapperObj, methodName, classOfEntity);

        //遍历每个元素将其添加到数据库
        list.forEach(o -> {


            try {
                finalInsert.invoke(mapperObj, o);
            } catch (IllegalAccessException|InvocationTargetException e) {
                e.printStackTrace();
            }


        });

        //返回添加后的数据列表
        return read(classOfEntity.getSimpleName());
    }

    /**
     * @return 返回：其对应数据库中的所有数据
     * @Author song
     * @Date 2019/5/5 21:19
     * @Description 功能: 读取一个实体类对应在数据库中的所有记录
     * @Param 输入：entity是要查找的类的名称
     **/
    public List read(String entity)  throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException  {

        Object exampleObj = ReflectUtil.getExampleObjOfEntity(entity);

        return readByExample(entity, exampleObj);
    }

    /**
     * @return 返回：
     * @Author px
     * @Date 2019/5/30 0030 下午 5:36
     * @Description 功能:  read方法的多态,需要传入example对象
     * @Param 输入：
     **/
    public List readByExample(String entity, Object example)  throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException  {
        //获取Mapper对象

        Object mapperObj = ReflectUtil.getMapperObjOfEntity(entity);
        //获取对应Mapper的selectByExample方法
        Method finalSelectByExample = ReflectUtil.getMethodFromObj(mapperObj,
                "selectByExample", ReflectUtil.getExampleClassOfEntity(entity));
        List result = (List) finalSelectByExample.invoke(mapperObj, example);

        return result;
    }




    /**
     * @return 返回： 空
     * @Author Su
     * @Date 2019/5/26 21:36
     * @Description 功能:  将list里面的元素根据其本身的类型，在对应的数据库表删除
     * @Param 输入： list，里面存储着要删除的数据
     **/
    public void delete(List list, String entity)  throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException  {
            //获取entity所对应的Class
            Class classOfEntity = ReflectUtil.getaClassOfEntity(entity);

            //根据entitiy的Class，去获取mapper对象
            Object mapperObj = ReflectUtil.getMapperObjOfEntity(classOfEntity);

            //获取对应Mapper的delete方法
            Method finalDelete = ReflectUtil.getMethodFromObj(mapperObj, "deleteByPrimaryKey", Integer.class);

            //遍历每个元素将其删除
            list.forEach(o -> {
                try {
                    Map map = (Map) o;
                    finalDelete.invoke(mapperObj, map.get(entity.toLowerCase()+"id"));
                    System.out.println(map.get(entity.toLowerCase()+"id")+"adhjlasdhklad::::"+entity);
                } catch (IllegalAccessException | InvocationTargetException e) {
                }
            });



    }

    /**
     * @Author :Pan_Yuhui
     * @Date
     * @Description :把list里面的元素根据其本身的类型，对数据表做修改操作
     * @Param list
     * *@return  返回值直接调用read方法
     */
    public List update(List list)  throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException  {

        //获取要添加的类的Class
        Class classOfEntity = list.get(0).getClass();

        //获取与要添加的类相对应的Mapper
        Object mapperObj = ReflectUtil.getMapperObjOfEntity(classOfEntity);

        //获取对应Mapper的update方法
        Method finalUpdate = ReflectUtil.getMethodFromObj(mapperObj, "updateByPrimaryKeySelective",
                classOfEntity);

//        System.out.println(list.toString()+"crudS");
        //更新
        list.forEach(o -> {

            try {
                finalUpdate.invoke(mapperObj, o);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

        });
        //返回添加后的数据列表
        return read(classOfEntity.getSimpleName());
    }
}
