package com.sys.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.framework.utils.DateUtil;
import com.framework.utils.MD5Util;
import com.framework.utils.SysStringUtils;
import com.sys.constant.ErrorEnum;
import com.sys.constant.SystemConstant;
import com.sys.dao.SysUserInfoMapper;
import com.sys.exception.ServiceException;
import com.sys.model.SysUserInfo;
import com.sys.service.SysUserInfoService;

/**
 * @describe 系统用户处理Service
 * @author by - 吥悔
 * @date 2017年4月4日 下午11:10:50
 * @email Java_zlm@163.com
 * @qq 379839355
 * @website http://www.javazlm.com/
 */
@Service
public class SysUserInfoServiceImpl implements SysUserInfoService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SysUserInfoServiceImpl.class);
	
	@Autowired
	private SysUserInfoMapper sysUserInfoMapper;

	@Override
	public int deleteByPrimaryKey(String userid) {
		return sysUserInfoMapper.deleteByPrimaryKey(userid);
	}

	@Override
	public int insert(SysUserInfo record) {
		return sysUserInfoMapper.insert(record);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = ServiceException.class)
	public int insertSelective(SysUserInfo record) throws ServiceException {
		try {
			// TODO 临时加密策略
//			String temp = MD5Util.encrypSysMD5(record.getPassword());
//			String password = MD5Util.decryptSysMd5(temp);
			// 自定义MD5解密方式
			String password = MD5Util.decryptSysMd5(record.getPassword());
			record.setPassword(password);
			// 查询当前最大编号
			String no = this.selectMaxId();
			// 生成ID
			String id = SysStringUtils.nextStringNumber(no.substring(1), SystemConstant.SYS_ID_MAX);
			record.setUserid(SystemConstant.USRE_ID_PREFIX + id);
			// 格式化日期
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			record.setRegisterdate(sdf.parse(DateUtil.getCurrentTime()));
			return sysUserInfoMapper.insertSelective(record);
		} catch (ParseException e) {
			LOGGER.error("用户注册日期格式转换异常：{}", e.getMessage());
			ErrorEnum errorEnum = ErrorEnum.DATE_READ_ERROR;
			errorEnum.setUserDefined("SysUserInfo[注册日期] - ");
			throw new ServiceException(errorEnum, e);
		} catch (Exception e) {
			ErrorEnum errorEnum = ErrorEnum.INSECT_ERROR;
			errorEnum.setUserDefined("SysUserInfo[用户信息] - ");
			throw new ServiceException(errorEnum, e);
		}
	}

	@Override
	public SysUserInfo selectByPrimaryKey(String userid) {
		return sysUserInfoMapper.selectByPrimaryKey(userid);
	}

	@Override
	public int updateByPrimaryKeySelective(SysUserInfo record) {
		return sysUserInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysUserInfo record) {
		return sysUserInfoMapper.updateByPrimaryKey(record);
	}

	/**
	 * 根据手机号和密码查询用户信息
	 * 
	 * TODO 检验手机号和密码是否正确
	 * 
	 * @param userInfo 用户信息
	 * @return SysUserInfo 当前用户信息
	 * @throws ServiceException 自定义异常
	 */
	@Override
	public SysUserInfo selectUsreInfoByPhonenumberAndPassword(SysUserInfo userInfo) throws ServiceException {
		try {
			// TODO 临时加密策略
//			String temp = MD5Util.encrypSysMD5(userInfo.getPassword());
//			String password = MD5Util.decryptSysMd5(temp);
			// 自定义MD5解密方式
			String password = MD5Util.decryptSysMd5(userInfo.getPassword());
			userInfo.setPassword(password);
			return sysUserInfoMapper.selectUsreInfoByPhonenumberAndPassword(userInfo);
		} catch (Exception e) {
			ErrorEnum errorEnum = ErrorEnum.QUERY_ERROR;
			errorEnum.setUserDefined("SysUserInfo[用户信息] - ");
			throw new ServiceException(errorEnum, e);
		}
	}

	/**
	 * 查询当前最大编号
	 * 
	 * @return String 当前最大编号
	 */
	@Override
	public String selectMaxId() throws ServiceException {
		try {
			String maxId = sysUserInfoMapper.selectMaxId();
			if(StringUtils.isBlank(maxId)) {
				maxId = "Y00000000";
			}
			return maxId;
		} catch (Exception e) {
			ErrorEnum errorEnum = ErrorEnum.QUERY_ERROR;
			errorEnum.setUserDefined("SysUserInfo[用户当前最大编号信息] - ");
			throw new ServiceException(errorEnum, e);
		}
	}
}