package com.funtl.myshop.plus.provider.tests;
import java.util.Date;

import com.funtl.myshop.plus.provider.api.UmsAdminService;
import com.funtl.myshop.plus.provider.domain.UmsAdmin;
import com.funtl.myshop.plus.provider.mapper.UmsAdminMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UmsAdminTests
 * @Description TODO
 * @Author Scorpio
 * @Date 2019/11/29 20:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class UmsAdminTests {

    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @Resource
    private UmsAdminService umsAdminService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void testSelectAll() {
        List<UmsAdmin> umsAdmins = umsAdminMapper.selectAll();
        umsAdmins.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setUsername("Scorpio");
        umsAdmin.setPassword(passwordEncoder.encode("123456"));
        umsAdmin.setIcon("");
        umsAdmin.setEmail("");
        umsAdmin.setNickName("");
        umsAdmin.setNote("");
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setLoginTime(new Date());
        umsAdmin.setStatus(0);

        int result = umsAdminService.insert(umsAdmin);
        Assert.assertEquals(result,1);
    }
}
