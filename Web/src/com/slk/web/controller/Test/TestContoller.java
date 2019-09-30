package com.slk.web.controller.Test;

import com.slk.web.framework.Cache.MemcachedUtil;
import com.slk.web.module.test.mapper.TestMapper;
import com.slk.web.module.test.po.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Create by 杨明 2019/6/20 0020 下午 16:56
 */
@Controller
@RequestMapping("/Test")
public class TestContoller {

    @Autowired
    private TestMapper mapper;


    @RequestMapping("/dome")
    @ResponseBody
    public boolean dome(HttpSession session) {


        List<Test> tests = mapper.selectTest();

        boolean flag = false;

        Object userId = session.getAttribute("userId");
        if (null == userId) {
            flag = true;
        } else if (null != userId && session.getId().equals(MemcachedUtil.get(session.getAttribute("userId").toString() + "UserSessionId"))) {
            flag = true;
        }
        return flag;
    }
}
