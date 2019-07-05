package com.sjg.zuzuCar.Controller;

import com.sjg.zuzuCar.Model.Account;
import com.sjg.zuzuCar.Model.Message;
import com.sjg.zuzuCar.Service.CrudService;
import com.sjg.zuzuCar.Service.AccountService;
import com.sjg.zuzuCar.Util.EncryUtils;
import com.sjg.zuzuCar.Util.Tools;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ClassName AccountController
 * @Author ble
 * @Date 2019/4/12 0:02
 * 功能: 与用户相关的控制器，用来与前端交互
 **/
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * @return 返回： 携带Account对象的Message，并带有成功或失败的消息
     * @Author song
     * @Date 2019/4/20 0:36
     * @Description 功能: 用户登录，查询数据库之前对用户名与密码进行了非空校验
     * @Param 输入： Account
     **/
    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/login")
    public Message<Account> login(@RequestBody Account user, HttpSession session, HttpServletResponse response) {
        Message<Account> usersMessage = new Message<>();
        if (!user.getUserName().isEmpty() && !user.getPassword().isEmpty()) {
            user.setPassword(EncryUtils.encryptMD5(user.getPassword()));
            Account resultUser = accountService.login(user);
            if (resultUser != null) {
                resultUser.setPassword("");
                usersMessage.setSuccess(true);
                usersMessage.setData(resultUser);
                usersMessage.setMsg("登录成功！");

                session.setAttribute("user", resultUser);
            } else {
                usersMessage.setSuccess(false);
                usersMessage.setMsg("用户名或密码错误！");
            }
        } else {
            usersMessage.setSuccess(false);
            usersMessage.setMsg("用户名或密码不能为空！");
        }
        return usersMessage;
    }

    /**
     * @return 返回： 携带Account对象的Message，并带有成功或失败的消息
     * @Author song
     * @Date 2019/4/20 11:18
     * @Description 功能: 用户注册方法，并进行用户名规则校验与密码的强度校验,以及两者的非空校验，默认用户身份为normal
     * @Param 输入：Account 对象，必须包括用户名与密码
     **/
    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    public Message<Account> register(@RequestBody Account account) {
        Message<Account> usersMessage = new Message<>();

        //正则表达式校验用户名，只能是大小写字母，数字的组合，并且要在3到32位之间
        String usernameReg = "([a-zA-Z0-9]){3,32}";
        //正则表达式校验密码，必须包括大写字母、小写字母、数字，并且要在6到32位之间
        String passwordReg = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{6,18}$";
        if (account.getUserName().isEmpty() || account.getPassword().isEmpty()) {

            usersMessage.setSuccess(false);
            usersMessage.setMsg("用户名或密码不能为空！");
        } else if (!account.getUserName().matches(usernameReg)) {
            usersMessage.setSuccess(false);
            usersMessage.setMsg("用户名只能是大于3位不超过32位的字母数字！");
        } else if (!account.getPassword().matches(passwordReg)) {

            usersMessage.setSuccess(false);
            usersMessage.setMsg("密码必须有大写字母、小写字母、数字，并且不小于6位！");
        } else if (account.getPhone() == null || account.getPhone().equals("")) {
            usersMessage.setSuccess(false);
            usersMessage.setMsg("电话不能为空！");
        } else {
            account.setPermission("normal");
            account.setPassword(EncryUtils.encryptMD5(account.getPassword()));
            int register = accountService.register(account);
            if (register == 0) {
                usersMessage.setSuccess(false);
                usersMessage.setMsg("用户名已存在！");
            } else {
                usersMessage.setSuccess(true);
                usersMessage.setMsg("注册成功！");
            }
        }
        return usersMessage;
    }

    /**
     * @return 返回： 携带Account对象的Message，并带有成功或失败的消息
     * @Author song
     * @Date 2019/4/20 13:32
     * @Description 功能: 更新用户的密码，并且在这之前校验输入的用户名与密码是否为空、密码是否符合强度
     * @Param 输入：Account 对象，必须包括用户名与密码
     **/
    @PostMapping("/updateAccount")
    @ApiOperation(value = "修改用户信息")
    public Message<Account> updateAccount(@RequestBody Account account) {

        Message<Account> usersMessage = new Message<>();


        //正则表达式校验密码，必须包括大写字母、小写字母、数字，并且要在6到32位之间
        String passwordReg = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{6,18}$";
        if (Tools.getUserFromSeesion() == null) {
            usersMessage.setSuccess(false);
            usersMessage.setMsg("您尚未登录！请登录后重试！");
        } else if (account.getUserName() == null || account.getUserName().isEmpty()) {
            usersMessage.setSuccess(false);
            usersMessage.setMsg("用户名不能为空！");
        } else {
            if (account.getPassword() != null &&
                    !account.getPassword().isEmpty()) {
                if (!account.getPassword().matches(passwordReg)) {
                    usersMessage.setSuccess(false);
                    usersMessage.setMsg("密码必须有大写字母、小写字母、数字，并且不小于6位！");
                    return usersMessage;

                } else{
                    account.setPassword(EncryUtils.encryptMD5(account.getPassword()));
                }
            } else {
                account.setPassword(null);
            }

            int i = accountService.updateUser(account);
            if (i == 0) {
                usersMessage.setSuccess(false);
                usersMessage.setMsg("用户不存在！");
            } else {
                usersMessage.setSuccess(true);
                usersMessage.setMsg("修改成功！");
            }
        }
        return usersMessage;

    }

    /**
     * @return 返回：boolean 存在返回true，不存在返回false
     * @Author song
     * @Date 2019/4/20 11:37
     * @Description 功能:  校验用户名是否已存在
     * @Param 输入： Sting 类型的username
     **/
    @GetMapping("/checkUserName/{userName}")
    @ApiOperation(value = "检查用户名是否存在")
    public boolean checkUserName(@PathVariable String userName) {
        return accountService.checkUsername(userName);
    }

}
