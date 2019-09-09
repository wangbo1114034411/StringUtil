package com.bw.util;

import java.util.Random;

import org.junit.Test;

/**
 * @a作者wb
 *
 * @时间2019年9月5日
 */
public class StringUtil{
	private final static String letters="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
	private final static String number="1234567890";
	
	
	private StringUtil() {}
	
	//1判断源字符串是否有值，空引号也算没值
	public static boolean isEmpty(String str) {
		//"" 在内存开辟内存空间  null 没有开辟内存空间
		return str!=null&&!"".equals(str);
	}
	
	//2判断源字符串是否有值，空引号和空格也算没值
	public static boolean isEmptyandSpace(String str) {
		//"" 在内存开辟内存空间  null 没有开辟内存空间
		return str!=null&&!"".equals(str.trim());
	}
	
	//判断是否为手机号码
	public static boolean isPhoneNum(String phone) {
		if(!isEmpty(phone)) {
			return false;
		}
		String reg_phoneNum="^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
		// 正则验证   
		boolean matches = phone.matches(reg_phoneNum);
		return matches;
	}
	
	//判断是否为电子邮箱
	public static boolean isEmail(String email) {
		if(!isEmpty(email)) {
			return false;
		}
		String reg_email="^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		// 正则验证   
		boolean matches = email.matches(reg_email);
		return matches;
	}
	
	//判断是否全部为字母
	public static boolean isLetter(String letter) {
		if(!isEmpty(letter)) {
			return false;
		}
		String reg_letter="[a-zA-Z]+";
		boolean matches = letter.matches(reg_letter);
		return matches;
	}
	
	//获取n位随机英文字符串
	public static String getLetter(int length) {
		StringBuffer sb=new StringBuffer();
		char[] charArray = letters.toCharArray();
		// 0~51
		for(int i=0;i<length;i++) {
			int num=(int)(Math.random()*(charArray.length));
			sb.append(charArray[num]);
		}
		return sb.toString();
	}
	
	//获取n位随机英文和数字字符串
	public static String getLetterAndNum(int length) {
		StringBuffer sb=new StringBuffer();
		char[] charArray = (letters+number).toCharArray();
		// 0~51
		for(int i=0;i<length;i++) {
			int num=(int)(Math.random()*(charArray.length));
			sb.append(charArray[num]);
		}
		return sb.toString();
	}
	//	获取n个随机中文字符串
	public static String getWord(int length) {
//		4e00~9fa5
		StringBuffer sb=new StringBuffer();
		int parseInt1 = Integer.parseInt("4e00", 16);
		int parseInt2 = Integer.parseInt("9fa5", 16);
		for(int i=0;i<length;i++) {
			int num=(int)(Math.random()*(parseInt2-parseInt1+1)+parseInt1);
			sb.append((char)num);
		}
		return sb.toString();
	}
}
