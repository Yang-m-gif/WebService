package com.slk.web.webservice.Test;

import com.slk.web.module.test.mapper.TestMapper;
import com.slk.web.module.test.po.Test;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by 杨明 2019/6/24 0024 下午 16:10
 */
@WebService
@SOAPBinding(style = Style.RPC)
public class TestWsImpl implements TestWs {

    @Autowired
    private TestMapper testMapper;

    @Override
    public String selectTest() {
        Map<String,Object> map = new HashMap<String,Object>();
        boolean flag = false;
        List<Test> tests = testMapper.selectTest();
        if(tests.size()>0){
            flag = true;
            map.put("testList",tests);
        }
        map.put("flag",flag);
        map.put("message",flag?"获取成功":"暂无数据");
        return JSONObject.fromObject(map).toString();
    }
}
