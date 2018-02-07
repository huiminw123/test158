package com.iftest.day2;

import java.util.Set;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JSONTTest {
	public static void main(String[] args) {
		JSONObject obj1 = new JSONObject();

		obj1.put("key1", "value1");
		obj1.put("key2", 123);
		obj1.put("key3", 12.34);
		System.out.println(obj1);

		String value1 = obj1.getString("key1");
		System.out.println(value1);
		int value2 = obj1.getIntValue("key2");
		System.out.println(value2);
		float value3 = obj1.getFloatValue("key3");
		System.out.println(value3);

		String str1 = obj1.toString();
		System.out.println(str1);

		JSONObject obj2 = JSONObject.parseObject(str1);
		System.out.println(obj2);

		Set<String> keySet = obj1.keySet();
		for (String key : keySet) {
			System.out.println(obj1.get(key));

			if (key.equals("key2")) {
				if (obj1.get(key).toString().equals("123")) {
					System.out.println("SUCCESS");
				} else {
					System.out.println("FAIL");
				}
			}
		}

		JSONArray arr1 = new JSONArray();
		arr1.add("element1");
		arr1.add(123);
		arr1.add(12.34);
		arr1.add(obj1);
		System.out.println(arr1);

		String ele1 = arr1.getString(0);
		System.out.println(ele1);
		int ele2 = arr1.getIntValue(1);	
		System.out.println(ele2);
		float ele3 = arr1.getFloatValue(2);
		System.out.println(ele3);
		JSONObject ele4 = arr1.getJSONObject(3);
		System.out.println(ele4);

		for (int i = 0; i > arr1.size(); i++) {
			System.out.println(arr1.get(i));
		}
		for(Object object : arr1){
			System.out.println(object);
		}
		String str2 = arr1.toString();
		System.out.println(str2);
		
		JSONArray arr2 = JSONArray.parseArray(str2);
		System.out.println(arr2);

	}

}
