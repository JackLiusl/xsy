package com.framework.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @describe 工具类Properties
 * @author by - 吥悔
 * @date 2017年4月9日 下午5:40:18
 * @email Java_zlm@163.com
 * @qq 379839355
 * @website http://www.javazlm.com/
 */
public class PropertiesUtil {
	/**
	 * Properties
	 */
	private Properties props;
	
	/**
	 * 文件路径
	 */
	private String fileName;

	public PropertiesUtil(String fileName) {
		this.fileName = fileName;
		readProperties(fileName);
	}

	/**
	 * 加载属性文件
	 * 
	 * @param fileName 文件路径
	 */
	private void readProperties(String fileName) {
		try {
			props = new Properties();
			InputStreamReader fis = new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName));
			props.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取某个属性
	 */
	public String getProperty(String key) {
		return props.getProperty(key);
	}

	/**
	 * 获取所有属性，返回一个map,不常用 可以试试props.putAll(t)
	 */
	public Map<String, String> getAllProperty() {
		Map<String, String> map = new HashMap<String, String>();
		Enumeration<?> enu = props.propertyNames();
		while (enu.hasMoreElements()) {
			String key = (String) enu.nextElement();
			String value = props.getProperty(key);
			map.put(key, value);
		}
		return map;
	}

	/**
	 * 在控制台上打印出所有属性，调试时用。
	 */
	public void printProperties() {
		props.list(System.out);
	}

	/**
	 * 写入properties信息
	 */
	public void writeProperties(String key, String value) {
		try {
			OutputStream fos = new FileOutputStream(PropertiesUtil.class.getClassLoader().getResource(fileName).getPath());
			props.setProperty(key, value);
			// 将此 Properties 表中的属性列表（键和元素对）写入输出流
			props.store(fos, "『comments』Update key：" + key);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}