package com.ray.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 扩展StringUtils
 *
 * @author ray
 */
public class ExStringUtils extends StringUtils {
	
	/**
	 * 邮箱验证
	 *
	 * @return
	 */
	public static boolean isEmail(String email) {
		if (StringUtils.isBlank(email)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
		return pattern.matcher(email).matches();
	}
	
	/**
	 * 验证电话座机
	 *
	 * @return
	 */
	public static boolean isPhone(String str) {
		if (StringUtils.isBlank(str)) {
			return false;
		}
		Pattern p1, p2;
		p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");  // 验证带区号的
		p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");         // 验证没有区号的
		if (str.length() > 9) {
			return p1.matcher(str).matches();
		} else {
			return p2.matcher(str).matches();
		}
	}
	
	/**
	 * 验证手机号码
	 *
	 * @return
	 */
	public static boolean isMobile(String mobiles) {
		Pattern pattern = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
		return pattern.matcher(mobiles).matches();
	}
	
	/**
	 * 网络地址验证
	 *
	 * @return boolean
	 *
	 * @since 1.0.0
	 */
	public static boolean isHomepage(String str) {
		Pattern pattern = Pattern.compile("^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~/])+$");
		return pattern.matcher(str).matches();
	}
	
	/**
	 * 判断字符串是否都是英文字母组成（大小写都算）
	 *
	 * @return
	 */
	public static boolean isEnglish(String string) {
		return isAlpha(string);
	}
	
	/**
	 * 判断字符串是否有特殊字符
	 *
	 * @return
	 */
	public static boolean hasSpecialChar(String str) {
		return ! isAlphanumeric(str);
	}
	
	/**
	 * 单个字符是否汉字
	 *
	 * @return
	 */
	private static boolean hasChinese(char c) {
		return c >= 0x4E00 && c <= 0x9FA5;// 根据字节码判断
	}
	
	/**
	 * 字符串是否包含汉字
	 *
	 * @return
	 */
	public static boolean hasChinese(String str) {
		if (StringUtils.isBlank(str)) {
			return false;
		}
		for (char c : str.toCharArray()) {
			if (hasChinese(c)) return true;// 有一个中文字符就返回
		}
		return false;
	}
	
	/**
	 * 是否全由汉字组成
	 *
	 * @return
	 */
	public static boolean isAllChinese(String str) {
		if (StringUtils.isBlank(str)) {
			return false;
		}
		for (char c : str.toCharArray()) {
			if (! hasChinese(c)) return false;
		}
		return true;
	}
	
	/**
	 * 统计字符串中的中文个数
	 *
	 * @return
	 */
	public static int getChineseCount(String s) {
		if (StringUtils.isBlank(s)) {
			return 0;
		}
		char c;
		int chineseCount = 0;
		s = new String(s.getBytes(), StandardCharsets.UTF_8);
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (hasChinese(c)) {
				chineseCount++;
			}
		}
		return chineseCount;
	}
	
	/**
	 * byte数组转换成二进制
	 *
	 * @return
	 */
	public static String byteToBinary(byte[] bs) {
		if (bs == null) {
			return "";
		}
		char[] cs = new char[bs.length * 9];
		for (int i = 0; i < bs.length; ++ i) {
			byte b = bs[i];
			int j = i * 9;
			cs[j] = (((b >>> 7 & 0x1) == 1) ? 49 : '0');
			cs[(j + 1)] = (((b >>> 6 & 0x1) == 1) ? 49 : '0');
			cs[(j + 2)] = (((b >>> 5 & 0x1) == 1) ? 49 : '0');
			cs[(j + 3)] = (((b >>> 4 & 0x1) == 1) ? 49 : '0');
			cs[(j + 4)] = (((b >>> 3 & 0x1) == 1) ? 49 : '0');
			cs[(j + 5)] = (((b >>> 2 & 0x1) == 1) ? 49 : '0');
			cs[(j + 6)] = (((b >>> 1 & 0x1) == 1) ? 49 : '0');
			cs[(j + 7)] = (((b & 0x1) == 1) ? 49 : '0');
			cs[(j + 8)] = ',';
		}
		return new String(cs);
	}
	
	/**
	 * 将字符串转换成大写英文字母
	 *
	 * @return
	 */
	public static String upperCaseAll(final String str) {
		if (StringUtils.isBlank(str)) {
			return "";
		}
		final char[] buffer = str.toCharArray();
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = Character.toUpperCase(buffer[i]);
		}
		return new String(buffer);
	}
	
	/**
	 * 将字符串转换成小写英文字母
	 *
	 * @return
	 */
	public static String lowerCaseAll(final String str) {
		if (StringUtils.isBlank(str)) {
			return "";
		}
		final char[] buffer = str.toCharArray();
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = Character.toLowerCase(buffer[i]);
		}
		return new String(buffer);
	}
	
	/**
	 * 生成一个范围内的随机数
	 *
	 * @return
	 */
	public static int randomInt(int from, int to) {
		Random random = new Random();
		int temp = random.nextInt(to - from) + (from);
		return temp;
	}
	
	/**
	 * 根据内容判断真假
	 *
	 * @return
	 */
	public static boolean parseBoolean(Object obj) {
		if (obj == null) {
			return false;
		} else {
			String str = obj.toString().toLowerCase();
			if ("y".equals(str) || "yes".equals(str) || "true".equals(str) || "t".equals(str) || "1".equals(str)) {
				return true;
			} else return false;
		}
	}
	
	/**
	 * 根据请求头类型的值判断是否是一个ajax请求
	 *
	 * @return
	 */
	public static boolean isAjax(HttpServletRequest request) {
		String requestHeadType = request.getHeader("X-Requested-With");
		if (! "XMLHttpRequest".equalsIgnoreCase(requestHeadType)) {
			return false;
		} else return true;
	}
	
	/**
	 * 转换成html编码
	 *
	 * @return
	 */
	public static String htmlEncode(String txt) {
		if (StringUtils.isBlank(txt)) {
			return "";
		}
		return txt.replace("&", "&amp;").replace("&amp;amp;", "&amp;").replace("&amp;quot;", "&quot;").replace("\"", "&quot;").replace("&amp;lt;", "&lt;").replace("<", "&lt;").replace("&amp;gt;", "&gt;").replace(">", "&gt;").replace("&amp;nbsp;", "&nbsp;");
	}
	
	/**
	 * 去除html编码
	 *
	 * @return
	 */
	public static String unHtmlEncode(String txt) {
		return txt.replace("&amp;", "&").replace("&quot;", "\"").replace("&lt;", "<").replace("&gt;", ">").replace("&nbsp;", " ");
	}
	
	/**
	 * 根据文件名判断是否是图片格式
	 *
	 * @return
	 */
	public static boolean isImage(String fileName) {
		if (StringUtils.isBlank(fileName)) {
			return false;
		}
		String prefix = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
		if ("jpg".equals(prefix) || "jpeg".equals(prefix) || "png".equals(prefix) || "gif".equals(prefix) || "bmp".equals(prefix)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 根据文件名判断是否是文档格式
	 *
	 * @return
	 */
	public static boolean isDoc(String fileName) {
		if (StringUtils.isBlank(fileName)) {
			return false;
		}
		String prefix = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
		if ("doc".equals(prefix) || "docx".equals(prefix) || "xls".equals(prefix) || "xlsx".equals(prefix) || "pdf".equals(prefix) || "txt".equals(prefix) || "ppt".equals(prefix) || "pptx".equals(prefix)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 根据文件名判断是否是视频/音频格式
	 *
	 * @return
	 */
	public static boolean isVideo(String fileName) {
		if (StringUtils.isBlank(fileName)) {
			return false;
		}
		String prefix = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
		return "mp4".equals(prefix) || "avi".equals(prefix) || "mp3".equals(prefix) || "rmvb".equals(prefix) || "wmv".equals(prefix) || "flv".equals(prefix) || "mov".equals(prefix) || "mkv".equals(prefix) || "asf".equals(prefix);
	}
	
	/**
	 * 根据文件名返回mime类型
	 *
	 * @return
	 */
	public static String getMimeType(String fileName) {
		FileNameMap fileNameMap = URLConnection.getFileNameMap();
		String type = fileNameMap.getContentTypeFor(fileName);
		return type;
	}
	
	/**
	 * 按字母排序
	 *
	 * @return
	 */
	public static String wordSort(String str) {
		if (StringUtils.isBlank(str)) {
			return "";
		}
		char[] chr = str.toCharArray();
		Arrays.sort(chr);
		return String.valueOf(chr);
	}
	
	/**
	 * 获取项目根目录
	 *
	 * @return
	 */
	public static String getUserDir() {
		String dir = System.getProperty("user.dir");
		return conversionSpecialCharacters(dir);
	}
	
	/**
	 * 替换路径的反斜杠
	 *
	 * @return
	 */
	public static String conversionSpecialCharacters(String string) {
		if (StringUtils.isBlank(string)) {
			return "";
		}
		return string.replaceAll("\\\\", "/");
	}
	
	/**
	 * 统计字符串中的空白数，字母，数字
	 *
	 * @return
	 */
	public static String getBlankNumCharacter(String s) {
		char ch;
		int character = 0, blank = 0, number = 0, other = 0;
		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
				character++;
			} else if (ch == ' ') {
				blank++;
			} else if (ch >= '0' && ch <= '9') {
				number++;
			}
		}
		return "字符串共有:" + character + "个字母," + blank + "个空格," + number + "个数字,其他字符占有:" + other;
	}
	
	/**
	 * 将数组转换成List
	 *
	 * @return
	 */
	public static <U> List<U> arrayToList(U u[]) {
		return new ArrayList<>(Arrays.asList(u));
	}
	
	/**
	 * 生成UUID
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}
	
	/**
	 * 驼峰命名转为下划线命名
	 * @param str
	 * @return
	 */
	public static String camelToUnderline(String str) {
		if (StringUtils.isBlank(str)){
			return "";
		}
		int len = str.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = str.charAt(i);
			if (Character.isUpperCase(c)){
				sb.append("_");
				sb.append(Character.toLowerCase(c));
			}else{
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	/**
	 * 生成范围区间的边界
	 * @param size 共多少个
	 * @param page 每页分割多少个
	 * @return 返回开始和结束的下标list
	 */
	public static List<int[]> getDividedRange(int size, int page) {
		if (size < 1 || page < 1) {
			throw new RuntimeException("size or page < 1");
		}
		int batch = size / page;
		List<int[]> list = new ArrayList<>(batch);
		int begin = 0;
		int end = 0;
		for (int i = 1; i <= batch; i++) {
			end = i * page - 1;
			int[] arr = {begin, end};
			list.add(arr);
			begin = end + 1;
		}
		if (begin < size) {
			end = size - 1;
			int[] arr = {begin, end};
			list.add(arr);
		}
		return list;
	}
	
	public static void main(String[] args) {
		System.out.println(camelToUnderline("ChenRui"));
	}
}
