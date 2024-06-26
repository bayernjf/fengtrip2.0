/**
 * 
 */
package org.feng.test;

import org.feng.FengApp_8080;
import org.feng.bean.JingFengTrip;
import org.feng.dao.JingFengTripJpaSpecificationExecutor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 姜峰
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={FengApp_8080.class})
public class JingFengTripJpaSpecificationExecutorTest {

	@Autowired
	private JingFengTripJpaSpecificationExecutor repository;
	
	@Test
	public void test() {
		JingFengTrip jft = this.repository.findOne(1);
		System.out.println("test()================jft: " + jft);
	}
	
	@Test
	public void test2() {
		JingFengTrip jft = new JingFengTrip();
		jft.setLocation("龙子湖公园");
		jft.setActivity("走马观花");
		jft.setTransportation("步行、自行车");
		jft.setTime("傍晚");
		JingFengTrip result = this.repository.save(jft);
		System.out.println("test2()================result: " + result);
	}
	
}
