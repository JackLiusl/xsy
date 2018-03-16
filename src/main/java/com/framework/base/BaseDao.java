package com.framework.base;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;

import com.framework.pagehelper.Page;

/**
 * @author jiangjie
 * @date 2017年3月10日10:31:16
 */
public abstract class BaseDao<T> extends SqlSessionDaoSupport {
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	/**
	 * 分页查询
	 * 
	 * @param name
	 *            mapper中的查询语句的id
	 * @param param
	 *            查询需要的参数
	 * @param pageNum
	 *            分页页数
	 * @param pageSize
	 *            每页条数
	 * @return
	 */
	protected Page<?> selectPage(String name, Object param, int pageNum, int pageSize) {
		return (Page<?>) getSqlSession().selectList(name, param, new RowBounds(pageNum, pageSize));
	}

	/**
	 * 查询一个
	 * 
	 * @param name
	 *            mapper中的查询语句的id
	 * @param param
	 *            查询需要的参数
	 * @return
	 */
	protected Object selectOne(String name, Object param) {
		List<Object> list = getSqlSession().selectList(name, param);
		if (list != null && list.size() == 1) {
			return list.get(0);
		} else if (list != null && list.size() == 0) {
			return null;
		} else if (list == null) {
			return null;
		} else {
			throw new IncorrectResultSizeDataAccessException(list.size());
		}
	}

	/**
	 * 无参数的分页查询
	 * 
	 * @param name
	 *            mapper中的查询语句的id
	 * @param pageNum
	 *            分页页数
	 * @param pageSize
	 *            每页条数
	 * @return
	 */
	protected Page<?> selectPage(String name, int pageNum, int pageSize) {
		return selectPage(name, null, pageNum, pageSize);
	}

	/**
	 * 查询单记录
	 * 
	 * @param name
	 *            mapper中的查询语句的id
	 * @param param
	 *            查询需要的参数
	 * @return Object 查询的结果
	 * @throws IncorrectResultSizeDataAccessException【查询到多条记录时抛次异常】
	 */
	protected Object selectOnlyOne(String name, Object param) throws IncorrectResultSizeDataAccessException {
		List<Object> list = getSqlSession().selectList(name, param);
		if (list != null) {
			if (list.size() > 1) { // 查询到多条数据
				throw new IncorrectResultSizeDataAccessException(list.size());
			} else {
				return list.get(0);
			}
		} else { // 未查询到
			return null;
		}
	}
}