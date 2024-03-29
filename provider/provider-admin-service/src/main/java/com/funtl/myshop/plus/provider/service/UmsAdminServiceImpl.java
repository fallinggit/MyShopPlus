package com.funtl.myshop.plus.provider.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.funtl.myshop.plus.provider.api.UmsAdminService;
import com.funtl.myshop.plus.provider.domain.UmsAdmin;
import com.funtl.myshop.plus.provider.mapper.UmsAdminMapper;
import com.funtl.myshop.plus.provider.service.fallback.UmsAdminServiceFallback;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 用户管理服务
 * @ClassName UmsServiceImpl
 * @Description TODO
 * @Author Scorpio
 * @Date 2019/11/30 10:29
 */
@Service(version = "1.0.0")
public class UmsAdminServiceImpl implements UmsAdminService {

    @Resource
    private UmsAdminMapper umsAdminMapper;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public int insert(UmsAdmin umsAdmin) {
        //初始化用户对象
        initUmsAdmin(umsAdmin);
        return umsAdminMapper.insert(umsAdmin);
    }

    @Override
    @SentinelResource(value = "getByUsername", fallback = "getByUsernameFallback", fallbackClass = UmsAdminServiceFallback.class)
    public UmsAdmin get(String username) {
//        if ("admin".equals(username)) {
//            throw new  IllegalArgumentException("invoke args");
//        }
        Example example = new Example(UmsAdmin.class);
        example.createCriteria().andEqualTo("username",username);
        return umsAdminMapper.selectOneByExample(example);
    }

    @Override
    public UmsAdmin get(UmsAdmin umsAdmin) {
        return umsAdminMapper.selectOne(umsAdmin);
    }

    @Override
    public int update(UmsAdmin umsAdmin) {
        // 获取原始用户信息
        UmsAdmin oldAdmin = get(umsAdmin.getUsername());

        // 仅更新 邮箱、昵称、备注、状态
        oldAdmin.setEmail(umsAdmin.getEmail());
        oldAdmin.setNickName(umsAdmin.getNickName());
        oldAdmin.setNote(umsAdmin.getNote());
        oldAdmin.setStatus(umsAdmin.getStatus());

        return umsAdminMapper.updateByPrimaryKey(oldAdmin);
    }

    @Override
    public int modifyPassword(String username, String password) {
        UmsAdmin umsAdmin = get(username);
        umsAdmin.setPassword(passwordEncoder.encode(password));
        return umsAdminMapper.updateByPrimaryKey(umsAdmin);
    }

    @Override
    public int modifyIcon(String username, String path) {
        UmsAdmin umsAdmin = get(username);
        umsAdmin.setIcon(path);
        return umsAdminMapper.updateByPrimaryKey(umsAdmin);
    }

    /**
     * 初始化用户对象
     * @param umsAdmin {@link UmsAdmin}
     */
    private void initUmsAdmin(UmsAdmin umsAdmin) {
        //初始化创建时间
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setLoginTime(new Date());

        //初始化状态
        if (umsAdmin.getStatus() == null) {
            umsAdmin.setStatus(0);
        }

        //密码加密
        umsAdmin.setPassword(passwordEncoder.encode(umsAdmin.getPassword()));
    }
}
