package com.sjg.zuzuCar.Util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName SpringBeanFactoryUtils
 * @Author song
 * @Date 2019/5/4 22:35
 * 功能:
 **/
@Component
public class BeanUtil implements ApplicationContextAware {

    private static ApplicationContext appCtx;

    /**
     * 重写setApplicationContext方法
     * 此方法可以把ApplicationContext对象inject到当前类中作为一个静态成员变量。
     *
     * @param applicationContext ApplicationContext 对象.
     * @throws BeansException
     * @author guanzheng
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanUtil.appCtx = applicationContext;
    }

    /**
     * 获取ApplicationContext
     *
     * @return
     * @author guanzheng
     */
    public static ApplicationContext getApplicationContext() {
        return appCtx;
    }

    /**
     * 这是一个便利的方法，帮助我们快速得到一个BEAN
     *
     * @param beanName bean的名字
     * @return 返回一个bean对象
     * @author guanzheng
     */
    public static Object getBean(String beanName) {
        return appCtx.getBean(beanName);
    }

}
