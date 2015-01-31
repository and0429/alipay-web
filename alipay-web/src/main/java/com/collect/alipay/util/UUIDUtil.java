package com.collect.alipay.util;

import java.util.UUID;

public class UUIDUtil {

	public static String randomUUID() {
		String uuid = UUID.randomUUID().toString();
		return uuid.replace("-", "");
	}
}
