package com.sjg.zuzuCar.Util;

import com.sjg.zuzuCar.Model.Account;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName Util
 * @Author song
 * @Date 2019/5/4 15:59
 * 功能:
 **/

public class Tools {


    public static Account getUserFromSeesion() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Account user = (Account) request.getSession().getAttribute("user");
        return user;
    }


}
