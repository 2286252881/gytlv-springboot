package com.zh.gytlv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zh.gytlv.mapper.KstoreMapper;
import com.zh.gytlv.service.KstoreService;
import com.zh.gytlv.utils.parseExcel.City;
import com.zh.gytlv.utils.parseExcel.Province;
import com.zh.gytlv.utils.parseExcel.SellArea;
@Service("kstoreService")
public class KstoreServiceImpl implements KstoreService {
	
	@Autowired
	private KstoreMapper kstoreMapper;
	
	
	@Override
	public int addSellArea(SellArea sellArea) {
		return kstoreMapper.addSellArea(sellArea);
	}


	@Override
	public List<Province> getProvince() {
		return kstoreMapper.getProvince();
	}


	@Override
	public List<City> getCity() {
		return kstoreMapper.getCity();
	}
	
}
