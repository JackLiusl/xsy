package xxsystem.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @describe 
 * @author by - 吥悔
 * @date 2017年3月28日 下午9:58:24
 * @email Java_zlm@163.com
 * @qq 379839355
 * @website http://www.javazlm.com/
 */
public class Test {
	public static int sum(String str) {
		int sum = 0;
		Pattern pattern = Pattern.compile("\\d*");
		Matcher matcher = pattern.matcher(str);
		while(matcher.find()) {
			String group = matcher.group();
			System.out.println("__" + group);
			if(group.length() == 0) {
				continue;
			}
			sum += Integer.parseInt(group);
		}
		return sum;
	}
	
	public static int sum2(String str) {
		int sum = 0;
		StringBuffer sb = new StringBuffer();
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if(String.valueOf(c[i]).matches("\\d*")) {
				sb.append(c[i]);
				if(i == (c.length - 1)) {
					System.out.println("sb = " + sb);
					sum += Integer.parseInt(sb.toString());
				}
				continue;
			}
			if(sb.toString().length() == 0) {
				continue;
			}
			System.out.println("sb -" + sb);
			sum += Integer.parseInt(sb.toString());
			sb = new StringBuffer();
		}
		return sum;
	}
	
	public static void main(String[] args) {
		String str = "abc123def1jkj1";
		System.out.println(sum2(str));
	}
}