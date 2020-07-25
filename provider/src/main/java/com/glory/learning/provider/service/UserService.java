package com.glory.learning.provider.service;

import com.glory.learning.provider.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Glory
 * @create 2020-07-18 15:31
 **/
@Service
public class UserService {

    // 开启新事务，执行添加操作，如果存在父级事务，把父级事务挂起
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean addUser(User user) {
        // dao调用
        return true;
    }

    // 跟REQUESTED级别传播行为相同，回滚操作不同
    // NESTED方法出现异常，仅回滚当前方法操作，父级防范根据异常可选择部分提交、整体回滚；
    @Transactional(propagation = Propagation.NESTED)
    public int delUser(int id) {
        // dao调用
        return 1;
    }
}
