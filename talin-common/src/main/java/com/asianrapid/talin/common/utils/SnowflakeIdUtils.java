package com.asianrapid.talin.common.utils;

public class SnowflakeIdUtils {
	private static SnowflakeIdWorker idWorker;
	static {
		// 使用静态代码块初始化 SnowflakeIdWorker
		idWorker = new SnowflakeIdWorker(1, 1);
	}

	public static String nextId() {
		return idWorker.nextId() + "";
	}

}
