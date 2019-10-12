package com.longlong.service;

import com.longlong.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * 编程式事务,手动控制事务
 */
@Service
public class UserService2 {

    @Autowired
    UserDao userDao;

    @Autowired
    DataSourceTransactionManager transactionManager;

    public void transferMoney(){
        TransactionStatus status = null;
        try {
            //设置隔离级别，超时时间等
            DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
            status = transactionManager.getTransaction(definition);

            userDao.addMoney();
            int i = 1/0;
            userDao.minMoney();

            //提交事务
            transactionManager.commit(status);
        } catch (Exception e) {
            e.printStackTrace();
            //回滚
            transactionManager.rollback(status);
        }
    }
}
