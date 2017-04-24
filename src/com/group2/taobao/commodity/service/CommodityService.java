package com.group2.taobao.commodity.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.group2.taobao.commodity.dao.CommodityDao;
import com.group2.taobao.commodity.domain.Commodity;

import net.sf.json.JSONArray;

public class CommodityService {
	CommodityDao dao = new CommodityDao();

	//搜索商品
	public String search(String keyword){
		try {
			if(!keyword.trim().isEmpty()){
				List<Commodity> list = dao.findByName(keyword);
				if(list!=null){
					JSONArray jsonArray = JSONArray.fromObject(list);
					return jsonArray.toString();
				}else{
					return null;
				}
			}else{
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	//全部商品
	public List<Commodity> allCommodity(){
		try {
			List<Commodity> list = dao.findAllCommodity();
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

	//通过ID搜索商品
	public Commodity findCommodity(String commodity_id){
		try {
			Commodity commodity = dao.findById(commodity_id);
			return commodity;
		} catch (SQLException e) {
			return null;
		}
	}
	
	@Test
	public void fun(){
		String s = search("菜");
		System.out.println(s);
	}

}
