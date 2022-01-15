package com.example.springlearndomain.Service.service;

import com.example.springlearndomain.Service.UserDao;
import org.springframework.stereotype.Service;

/**
 * @Author: YangLiJun
 * @Date: 2021/8/22 23:37
 * @Version: 1.0
 * @Description:
 */
@Service
public class UserService implements UserDao {
    @Override
    public Integer getNum() {
        return 1;
    }
}
