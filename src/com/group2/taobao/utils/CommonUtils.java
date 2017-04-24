package com.group2.taobao.utils;

import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;



public class CommonUtils {

	/*
	 * ���ɲ��ظ���32λ���Ĵ�д�ַ���
	 */
	public static String uuid(){
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	
	public static <T> T toBean(Map map,Class<T> clazz){
		try {
			/*
			 * 1.����ָ�����͵�javabean����
			 */
			T bean = clazz.newInstance();
			/*
			 * 2.�����ݷ�װ��javabean��
			 */
			BeanUtils.populate(bean, map);
			/*
			 * �Ż�javabean����
			 */
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		
	}
}
