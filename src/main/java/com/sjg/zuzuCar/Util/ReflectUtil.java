package com.sjg.zuzuCar.Util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName ReflectUtil
 * @Author song
 * @Date 2019/5/29 14:25
 * 功能: 聚合了关于java反射机制的工具型方法
 **/
public class ReflectUtil {

    /**
     * @return 返回： 方法对象
     * @Author song
     * @Date 2019/5/29 15:37
     * @Description 功能: 从一个对象里面，获取一个方法
     * @Param 输入： obj:对象，methodName：方法名，parameterTypes：方法参数类型
     **/
    public static Method getMethodFromObj(Object obj, String methodName, Class<?>... parameterTypes) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Method method  = obj.getClass().getDeclaredMethod(methodName, parameterTypes);

        Objects.requireNonNull(method).setAccessible(true);
        return method;
    }

    /**
     * @return 返回： 返回一个Mapper对象
     * @Author song
     * @Date 2019/5/29 15:38
     * @Description 功能: 根据Entity的Class，获取其对应的Maaper
     * @Param 输入： classOfEntity：一个实体类的类型
     **/
    public static Object getMapperObjOfEntity(Class classOfEntity) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取对应的Mapper的Class
        Class classOfMapper = Class.forName("com.sjg.zuzuCar.Mapper." + classOfEntity.getSimpleName() + "Mapper");


        //获取与要添加的类相对应的Mapper
        return BeanUtil.
                getApplicationContext().
                getBean(classOfMapper);
    }


    /**
     * @return 返回： 返回一个Mapper对象
     * @Author song
     * @Date 2019/5/29 15:38
     * @Description 功能: 根据Entity的类型名，获取其对应的Maaper
     * @Param 输入： classOfEntity：一个实体类的类型
     **/
    public static Object getMapperObjOfEntity(String entityName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取entity描述的类对应的Class
        Class classOfEntity = Class.forName("com.sjg.zuzuCar.Model." + entityName);
        return getMapperObjOfEntity(classOfEntity);
    }


    /**
     * @return 返回： 一个人Examp对象
     * @Author song
     * @Date 2019/5/29 15:42
     * @Description 功能: 根据Entity的类型名，获得Exampl对象
     * @Param 输入： classOfEntity：一个实体类的类型
     **/
    public static Object getExampleObjOfEntity(String entity) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取entity描述的类对应的Example的Class
        Class classOfExample = getExampleClassOfEntity(entity);
        //获取一个Example对象用来从数据库查找数据
        Object exampleObj = Objects.requireNonNull(classOfExample).getDeclaredConstructor().newInstance();
        return exampleObj;
    }


    /**
     * @return 返回：类型对象
     * @Author song
     * @Date 2019/5/29 15:43
     * @Description 功能: 根据实体类的类型名，获取它的类型对象
     * @Param 输入：entity：类名
     **/
    public static Class<?> getExampleClassOfEntity(String entity) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class classOfExample = Class.forName("com.sjg.zuzuCar.Model." + entity + "Example");
        return classOfExample;
    }


    /**
     * @return 返回：类型对象
     * @Author song
     * @Date 2019/5/29 15:44
     * @Description 功能: 根据一个实体类的类名，获取这个类的类型对象
     * @Param 输入：实体类的类名
     **/
    public static Class getaClassOfEntity(String entity) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取要添加的类的Class
        Class classOfEntity = Class.forName("com.sjg.zuzuCar.Model." + entity);

        return classOfEntity;
    }


    /**
     * @return 返回： 一个Object类型的对象，是转换过后的对象
     * @Author song
     * @Date 2019/5/4 16:36
     * @Description 功能: 将Map对象里面的数据转换为Model包里对应类的对象
     * @Param 输入：className 是要转换的类的名称，Map存贮着要转换的数据
     **/
    public static Object mapToModel(String className, Map map) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //获取要转换的类型的Class
        Class c = Class.forName("com.sjg.zuzuCar.Model." + className);
        //获取对应类的属性声明信息数组
        Field[] fields = c.getDeclaredFields();
        //声明Class数组用来装载属性的类型
        Class<?>[] classParas = new Class[fields.length];
        //声明Obje数组，用来装载要载入到对象的值
        Object[] paras = new Object[fields.length];

        //遍历每个属性，并将其类型与要装填的值装载如数组
        for (int i = 0; i < fields.length; i++) {
            classParas[i] = fields[i].getType();
            paras[i] = map.get(fields[i].getName());
        }
        //获取要转换类型的构造方法
        Constructor constructor = c.getConstructor(classParas);
        //返回转换后的对象
        return constructor.newInstance(paras);

    }

    /**
     * @return 返回：
     * @Author pxxx
     * @Date 2019/5/28 21:27
     * @Description 功能: 使用反射机制根据属性名获取一个对象的属性值
     * @Param 输入： fieldName：属性名，o:属性所属的对象
     **/
    public static Object getFieldValueByName(String fieldName, Object o) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        String firstLetter = fieldName.substring(0, 1).toUpperCase();
        String getter = "get" + firstLetter + fieldName.substring(1);
        Method method = o.getClass().getMethod(getter, new Class[]{});

        Object value = method.invoke(o, new Object[]{});

        return value;
    }
}
