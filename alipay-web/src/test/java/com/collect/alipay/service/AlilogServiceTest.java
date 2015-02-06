package com.collect.alipay.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.collect.alipay.domain.Alilog;
import com.collect.alipay.util.UUIDUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class AlilogServiceTest {

	@Inject
	private AlilogService alilogService;

	@Test
	public void testSave() {

		Alilog ali = new Alilog();

		String id = UUIDUtil.randomUUID();

		ali.setId(id);
		ali.setOper(1);
		ali.setOperChannel(1);
		ali.setOperDate(new Date());
		ali.setOperUser("zhangkai");
		ali.setRemark("test");

		Alilog alifromdb = alilogService.getById(id);

		assertEquals(true, alifromdb != null);
		assertEquals("zhangkai", alifromdb.getOperUser());

	}

	@Test
	public void testGetById() {
//		Alilog log = alilogService.getById("1");
//		assertEquals("zhangkai", log.getOperUser());
	}

}
