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
	private static final String URL = "http://restapi.amap.com/v3/geocode/geo?address=ADDRESS&output=JSON&key=e4d87142e4ffd9533c3a3487eec2fa8f";

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
			jNode = (JSONObject) jsonObject.getJSONArray("geocodes").get(0);
			location=(String) jNode.get("location");
		}
		System.out.println(location);
		return location;
	}

	public static void main(String[] args) throws ParseException, IOException {
		doGetStr("北京城区客服中心营业厅");
	}
}
