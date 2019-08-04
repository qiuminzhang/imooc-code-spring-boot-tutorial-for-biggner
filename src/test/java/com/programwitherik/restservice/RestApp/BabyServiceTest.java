package com.programwitherik.restservice.RestApp;

import com.programwitherik.restservice.RestApp.Domain.Baby;
import com.programwitherik.restservice.RestApp.Service.BabyService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) // Indicates that we're gonna run project in the test environment
@SpringBootTest // 启动整个spring boot工程
public class BabyServiceTest {

    @Autowired
    private BabyService babyService;

    @Test
    public void findOneTest() {
        Baby baby = babyService.findOne(12);
        // Assert.assertEquals(Object, Object)
        Assert.assertEquals(new Integer(18), new Integer(baby.getAge()));
    }
}
