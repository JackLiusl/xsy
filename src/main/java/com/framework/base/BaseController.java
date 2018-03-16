package com.framework.base;

import org.apache.commons.lang.math.NumberUtils;

import com.framework.pagehelper.Page;

/**
 * @author jiangjie
 * @date 2017年3月10日10:31:05
 */
public class BaseController<E> {
	// 获取分页对象
	protected Page<E> getPageObject(String pageNum, String pageSize) {
		Page<E> page = new Page<E>();
		// 获取记录开始行数
		if (NumberUtils.isDigits(pageNum)) {
			page.setPageNum(NumberUtils.toInt(pageNum));
		} else {
			page.setPageNum(1);
		}
		// 获取每页显示的行数
		if (NumberUtils.isDigits(pageSize)) {
			page.setPageSize(NumberUtils.toInt(pageSize));
		} else {
			page.setPageSize(0);
		}
		return page;
	}
}