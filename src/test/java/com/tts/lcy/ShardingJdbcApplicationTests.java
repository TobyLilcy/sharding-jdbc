package com.tts.lcy;

import com.tts.lcy.order.dao.OrderDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingJdbcApplication.class)
public class ShardingJdbcApplicationTests {

	@Autowired
	private OrderDao orderDao;

	@Test
	public void contextLoads() {
		for (int i = 0; i < 10; i++) {
			orderDao.insertOrder(new BigDecimal(i), 1L, "WAIT_PAY");
		}
	}

	@Test
	public void testSelectOrderIds(){
		List<Long> ids = new ArrayList<>();
		ids.add(494453816654036993L);
		ids.add(494453817203490816L);
        List<Map> maps = orderDao.selectOrderByIds(ids);
        System.out.println(maps);
    }

}
