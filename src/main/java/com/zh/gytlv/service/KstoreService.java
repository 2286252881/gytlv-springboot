package com.zh.gytlv.service;

import java.util.List;

import com.zh.gytlv.utils.parseExcel.City;
import com.zh.gytlv.utils.parseExcel.Province;
import com.zh.gytlv.utils.parseExcel.SellArea;

public interface KstoreService {
	/**
	 * ksotre
	 * @param sellArea
	 * @return
	 */
	public int addSellArea(SellArea sellArea);
	
	
	
	public List<Province> getProvince();
	
	public List<City> getCity();
	
}
