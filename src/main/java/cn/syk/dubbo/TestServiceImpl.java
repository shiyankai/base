package cn.syk.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
 
@Service(version = "1.0.0",timeout = 3000)
public class TestServiceImpl implements TestService{
 
    @Override
    public void testDubbo() {

    }
}