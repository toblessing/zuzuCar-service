package com.sjg.zuzuCar.Service;
import com.sjg.zuzuCar.Mapper.AccountMapper;
import com.sjg.zuzuCar.Model.Account;
import com.sjg.zuzuCar.Model.AccountExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AccountService
 * @Author ble
 * @Date 2019/4/12 0:02
 * 功能: 与用户相关的业务逻辑
 **/
@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    /**
     * @Author song
     * @Date 2019/4/19 22:21
     * @Description 功能:用户登录方法
     * @Param 输入： Users对象，必须包括用户名与密码
     * @return 返回： Users对象，
     **/
    public Account login(Account account) {
        Account result = null;
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andPasswordEqualTo(account.getPassword())
                .andUserNameEqualTo(account.getUserName());
        List<Account> accountList = accountMapper.selectByExample(accountExample);
        if (accountList.size() == 1) {
            result = accountList.get(0);
        }

        return result;
    }

/**
 *
 * @Author song
 * @Date 2019/4/20 11:08
 * @Description 功能:  用户注册方法，在注册之前有检查用户名是否存在
 * @Param 输入： Account对象，必须包括用户名与密码
 * @return 返回： int 插入数据的的行数
**/
    public int register(Account account) {
        if (!checkUsername(account.getUserName())) {
            try {

                int insert = accountMapper.insert(account);
                return insert;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    /**
     *
     * @Author song
     * @Date 2019/4/20 11:11
     * @Description 功能: 检查用户名是否已存在
     * @Param 输入：String 用户名
     * @return 返回：boolean 存在返回true，不存在返回false
    **/
    public boolean checkUsername (String userName){
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria()
                .andUserNameEqualTo(userName);
        List<Account> account = accountMapper.selectByExample(accountExample);
        if(account.size()==0){
            return false;
        }else {
            return true;
        }
    }


    /**
     *
     * @Author song
     * @Date 2019/4/20 13:33
     * @Description 功能: 修改用户的资料
     * @Param 输入： Account对象，必须包括用户名与密码
     * @return 返回： int 修改数据的的行数
    **/
    public int updateUser(Account account) {
        if (checkUsername(account.getUserName())) {
            try {
                int insert = accountMapper.updateByPrimaryKeySelective(account);
                return insert;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
