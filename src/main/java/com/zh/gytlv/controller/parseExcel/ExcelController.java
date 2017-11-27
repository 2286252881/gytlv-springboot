package com.zh.gytlv.controller.parseExcel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zh.gytlv.service.KstoreService;
import com.zh.gytlv.utils.GdMapUtils;
import com.zh.gytlv.utils.parseExcel.City;
import com.zh.gytlv.utils.parseExcel.ExcelFileParser;
import com.zh.gytlv.utils.parseExcel.Province;
import com.zh.gytlv.utils.parseExcel.SellArea;

import net.sf.jsqlparser.parser.ParseException;

@Controller
public class ExcelController {
	
	@Autowired
	private KstoreService kstoreService;
	
	@RequestMapping("/parseExcel")
	public void parseExcel() throws ParseException, IOException {
		String path = "C:/Users/Hiiso/Desktop/kstore/2017-11-22/营业厅信息表全国盖章的test.xlsx";
		Workbook wb = ExcelFileParser.getWb(path);
		List<List<String>> list = ExcelFileParser.getExcelRows(ExcelFileParser.getSheet(wb, 0), 1, -1);
		List<SellArea> sellAreas = new ArrayList<>();
		
		
		//省
		List<Province> provinces=kstoreService.getProvince();
		
		//市
		List<City> citys=kstoreService.getCity();
		
		SellArea s=null;
		int count=0;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).get(0)==null){
                continue;
            }
			s = new SellArea();
			s.setSellName(list.get(i).get(0));
			s.setSellAddress(list.get(i).get(1));
			s.setSellTell(list.get(i).get(2));
			s.setSellRemark(list.get(i).get(3));
			//(list.get(i).get(4));
			String excleP=list.get(i).get(4);
			s.setProvinceName(excleP);
			String sysP="";
			count++;
			for (Province p : provinces) {
				sysP=p.getProvinceName();
				if(excleP.trim().indexOf(sysP)!=-1){
					s.setProvinceId(p.getProvinceId());
					System.err.println(p.getProvinceName()+"==============省："+count+"===============================");
					continue;
				}
			}
			//(list.get(i).get(5));
			String excelC=list.get(i).get(5);
			s.setCityName(excelC);
			String sysC="";
			for (City c : citys) {
				sysC=c.getCityName();
				if(sysC.indexOf(excelC.trim())!=-1){
					s.setCityId(c.getCityId());
					System.out.println(c.getCityName()+"==============市："+count+"===============================");
					continue;
				}
			}
			sellAreas.add(s);
		}
		System.out.println(sellAreas.size());
		for (SellArea finalSell : sellAreas) {
			Integer id=sellAreas.lastIndexOf(finalSell)+1;
			finalSell.setSellId(id);
			finalSell.setSellMap(GdMapUtils.doGetStr(finalSell.getProvinceName()+finalSell.getSellAddress().replaceAll("\\s*","")));
			kstoreService.addSellArea(finalSell);
		}
	}
}
