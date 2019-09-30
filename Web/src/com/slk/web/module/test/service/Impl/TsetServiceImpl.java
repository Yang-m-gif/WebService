package com.slk.web.module.test.service.Impl;

import com.slk.web.module.test.mapper.TestMapper;
import com.slk.web.module.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TsetServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;
}
