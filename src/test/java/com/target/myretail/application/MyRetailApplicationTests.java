package com.target.myretail.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyRetailApplication.class)
@WebAppConfiguration
public class MyRetailApplicationTests {

	@Test
	public void contextLoads() {
	}

}

