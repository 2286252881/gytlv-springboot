package com.zh.gytlv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zh.gytlv.utils.parseExcel.City;
import com.zh.gytlv.utils.parseExcel.Province;
import com.zh.gytlv.utils.parseExcel.SellArea;

public interface KstoreMapper {
	/**
	 * kstore
	 * @param sellArea
	 * @return
	 */
	@Insert("insert into np_sell_area(sell_id,sell_name,sell_tell,sell_address,sell_remark,province_id,city_id,sell_map,province_name,city_name) values(#{sellarea.sellId},#{sellarea.sellName},#{sellarea.sellTell},#{sellarea.sellAddress},#{sellarea.sellRemark},#{sellarea.provinceId},#{sellarea.cityId},#{sellarea.sellMap},#{sellarea.provinceName},#{sellarea.cityName})")
	public int addSellArea(@Param("sellarea")SellArea sellArea);
	
	@Select("select * from np_sys_province")
	@Results({ @Result(column = "province_id", property = "provinceId"), @Result(column = "province_name", property = "provinceName")})
	public List<Province> getProvince();
	
	@Select("select * from np_sys_city")
	@Results({ @Result(column = "city_id", property = "cityId"), @Result(column = "city_name", property = "cityName")})
	public List<City> getCity();
}
