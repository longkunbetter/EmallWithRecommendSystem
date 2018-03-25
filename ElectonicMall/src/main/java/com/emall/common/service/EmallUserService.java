package com.emall.common.service;

import com.emall.common.dao.EmallUserMapper;
import com.emall.common.entity.EmallUser;
import com.emall.common.entity.EmallUserExample;
import com.emall.util.Md5Util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class EmallUserService {
    private static final Log log = LogFactory.getLog(EmallUserService.class);

    @Autowired
    private EmallUserMapper userDao;

    public EmallUser verifyUser(EmallUser loginInfo){
        String encodedPassword = Md5Util.md5Hex(loginInfo.getPassword());
        loginInfo.setPassword(encodedPassword);
        EmallUser loginedUser = userDao.selectByLoginInfo(loginInfo);
        return loginedUser;
    }
}
