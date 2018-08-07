package com.github.zhuyizhuo.generator.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * class: GeneratorStringUtils <br>
 * description: 字符串工具类 <br>
 * time: 2018/7/27 11:35
 *
 * @author yizhuo <br>
 * @version 1.0
 */
public class GeneratorStringUtils {

    /**
     * 获取传入文件全路径的路径信息
     * @param fileFullpath d:/e/a/1.txt
     * @return d:/e/a/
     */
    public static String getFrontPath(String fileFullpath){
        if (StringUtils.isBlank(fileFullpath)){
            return "";
        }
        String fullPath = fileFullpath.replaceAll("\\\\","/");
        return fullPath.substring(0,fullPath.lastIndexOf("/") + 1);
    }

    /**
     * 获取传入文件全路径的文件名称
     * @param fileFullpath d:/e/a/1.txt
     * @return 1.txt
     */
    public static String getFileName(String fileFullpath){
        if (StringUtils.isBlank(fileFullpath)){
            return "";
        }
        String fullPath = fileFullpath.replaceAll("\\\\","/");
        return fullPath.substring(fullPath.lastIndexOf("/") + 1);
    }

    /**
     * 表名转java驼峰命名(首字母小写)
     * @param tableName  e.g mybatis_user_info
     * @return mybatisUserInfo
     */
    public static String changeTableName2Java(String tableName,String tableRegex) {
        String[] split = tableName.split(tableRegex);
        StringBuffer s = new StringBuffer(split[0]);
        for (int i = 1; i < split.length; i++) {
            s.append(firstUpper(split[i]));
        }
        return s.toString();
    }

    /**
     * 表名转java驼峰命名(首字母大写)
     * @param tableName  e.g mybatis_user_info
     * @return MybatisUserInfo
     */
    public static String changeTableName2JavaFirstUpper(String tableName, String tableRegex) {
        String[] split = tableName.split(tableRegex);
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < split.length; i++) {
            s.append(firstUpper(split[i]));
        }
        return s.toString();
    }

    /**
     * 数据库字段名转java驼峰命名(首字母小写 驼峰处转大写)  连接符colmRegex可指定  默认为_
     * @param columnName
     * @return java驼峰命名
     */
    public static String changeColmName2Java(String columnName,String colmRegex) {
        String[] split = columnName.split(colmRegex);
        StringBuffer s = new StringBuffer();
        char[] charArray = split[0].toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            s.append(toL(charArray[i]));
        }
        for (int i = 1; i < split.length; i++) {
            s.append(firstUpper(split[i]));
        }
        return s.toString();
    }

    /**
     * 首字母大写 其他字母小写
     * @param str 传入纯字母字符串
     * @return 首字母大写 其他字母小写
     */
    public static String firstUpper(String str) {
        char[] cs = str.toCharArray();
        cs[0] = toU(cs[0]);
        for (int i = 1; i < cs.length; i++) {
            cs[i] = toL(cs[i]);
        }
        return String.valueOf(cs);
    }

    /**
     * 首字母小写
     * @param str 传入纯字母字符串
     * @return 将首字母小写后返回
     */
    public static String firstLower(String str) {
        char[] cs = str.toCharArray();
        cs[0] = toL(cs[0]);
        return String.valueOf(cs);
    }

    /**
     * 字母转大写
     * @param c a-z
     * @return A-Z
     */
    public static char toU(char c) {
        if (c >= 'a' && c <= 'z') {
            return (char)(c - 32);
        }
        return c;
    }

    /**
     * 字母转小写
     * @param c A-Z
     * @return a-z
     */
    public static char toL(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char)(c + 32);
        }
        return c;
    }

}