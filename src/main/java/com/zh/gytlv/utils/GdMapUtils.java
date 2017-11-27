package com.zh.gytlv.utils;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;
import net.sf.jsqlparser.parser.ParseException;

public class GdMapUtils {
	private static final String URL = "http://restapi.amap.com/v3/geocode/geo?address=ADDRESS&output=JSON&key=0c63dc7ea7c8d503f5b889b08574184e";

	public static String doGetStr(String pointName) throws ParseException, IOException {
		DefaultHttpClient client = new DefaultHttpClient();
		String newUrl = URL.replace("ADDRESS", pointName);
		HttpGet httpGet = new HttpGet(newUrl);
		JSONObject jsonObject = null;
		HttpResponse httpResponse = client.execute(httpGet);
		HttpEntity entity = httpResponse.getEntity();
		if (entity != null) {
			String result = EntityUtils.toString(entity, "UTF-8");
			jsonObject = JSONObject.fromObject(result);
		}
		JSONObject jNode=null;
		String location="0";
		if (jsonObject.get("status").equals("1")) {
			if(!jsonObject.getJSONArray("geocodes").isEmpty()){
				jNode = (JSONObject) jsonObject.getJSONArray("geocodes").get(0);
				location=jNode.getString("location");
			}
		}
		System.out.println(pointName);
		System.out.println(location);
		return location;
	}

	public static void main(String[] args) throws ParseException, IOException {
		doGetStr("城区客服中心营业厅");
	}
}
