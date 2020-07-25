package com.glory.learning.provider;

import com.glory.learning.provider.entity.User;
import com.glory.learning.provider.service.UserService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Glory
 * @create 2020-07-18 15:29
 **/
public class TransactionTest {

    @Resource
    private UserService userService;

    @Transactional
    public void business() {
        User u = new User();
        u.setName("glory");
        userService.addUser(u);

        // 处理del异常，business方法不会回滚
        try {
            // 如果del出现异常，delUser方法回滚
            userService.delUser(u.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
