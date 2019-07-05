package com.dy.cache.util;

import com.dy.cache.entity.User;

import java.util.*;

public class InstallmentRepaymentDate {

	/**
	 * 根据签约日期，拼接出还款日期
	 * 2017年07月30日 | 2017年08月30日 | 2017年09月30日 | 2017年10月30日 | 2017年11月30日
	 * 
	 * @param signDate
	 * @return
	 */
	public static String getDateStr(String signDate,Integer n) {
		String dateInfo = "";
		try {
			Date d = DatetimeUtil.dateFormatTransfer(signDate);
			Calendar cld = Calendar.getInstance();
			for (int i = 1; i <= n; i++) {
				cld.setTime(d);
				cld.add(Calendar.MONTH, i);
				cld.set(Calendar.DAY_OF_MONTH,15);
				Date d2 = cld.getTime();
				if (i == 1) {
					dateInfo = DatetimeUtil.formatOfDate(d2);
					continue;
				}
				dateInfo += " | " + DatetimeUtil.formatOfDate(d2);
			}
			System.out.println(dateInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateInfo;
	}

	public static void main(String[] args) {
		//String dateStr = getDateStr("2019-07-15", 3);
		//System.out.println(dateStr);
		User user1=new User(1,"dy",21);
		User user2=new User(1,"dl",23);
		User user3=new User(1,"lx",22);
		User user4=new User(1,"zcq",20);


		//对map进行排序 不拆分键值对
		Map<String,User> map=new HashMap<>();
		map.put("1",user1);
		map.put("2",user2);
		map.put("3",user3);
		map.put("4",user4);
		//获取map的键值对
		Set<Map.Entry<String, User>> entries = map.entrySet();
		//将set集合转换为list集合
		List<Map.Entry<String,User>> list=new ArrayList<Map.Entry<String,User>>(entries);

		//利用集合工具类进行排序
		Collections.sort(list, new Comparator<Map.Entry<String, User>>() {
			@Override
			public int compare(Map.Entry<String, User> o1, Map.Entry<String, User> o2) {
				return  o1.getValue().getAge().compareTo(o2.getValue().getAge());
			}
		});

		//使用lambda表达式
		//Collections.sort(list,(s1,s2)->(s1.getValue().getAge()-s2.getValue().getAge()));

		LinkedHashMap<String,User> linkedHashMap=new LinkedHashMap<String,User>();
		//将list集合存储到map钟
		for (Map.Entry<String,User> entry:list){
			linkedHashMap.put(entry.getKey(),entry.getValue());
		}

		System.out.println(linkedHashMap);

	}
}
