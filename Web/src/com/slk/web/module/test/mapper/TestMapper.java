package com.slk.web.module.test.mapper;

import com.slk.web.module.test.po.Test;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TestMapper {

    public List<Test> selectTest();

}