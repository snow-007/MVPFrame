package com.dqm.mvpframe.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 */
public class StringUtil {
    /**
     * 判断非空
     *
     * @param str
     * @return
     */
    public static String isEmpty(String str) {
        String result = TextUtils.isEmpty(str) ? "" : str;
        return result;
    }
    /**
     * 将价格中间添加逗号
     *
     * @param number
     * @return
     */
    public static String saveComma(Float number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(number);
    }
    /**
     * 四舍五入
     *
     * @return
     */
    public static String saveFour(String number) {
        BigDecimal decimalFormat = new BigDecimal(number).setScale(0, BigDecimal.ROUND_HALF_UP);
        return decimalFormat.toString();
    }
    /**
     * 保留0位小数
     *
     * @param number
     * @return
     */
    public static String savePointNumber(Float number) {
        DecimalFormat decimalFormat = new DecimalFormat("0");
        return decimalFormat.format(number);
    }
    /**
     * 保留2位小数
     *
     * @param number
     * @return
     */
    public static String saveTwoPointNumber(Float number) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");// 构造方法的字符格式这里如果小数不足2位,会以0补足.
        return decimalFormat.format(number);
    }
    /**
     * 将list<String> 集合转化为String
     *
     * @param stringList
     * @return
     */
    public static String listToString(List<String> stringList) {
        if (stringList == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        for (String string : stringList) {
            if (flag) {
                result.append(",");
            } else {
                flag = true;
            }
            result.append(string);
        }
        return result.toString();
    }
    /**
     * 判断是不是一个合法的电子邮件地址
     * @param email
     * @return
     */
    public static boolean isEmail(String email){
        Pattern emailer = Pattern.compile("^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$");
        if(email == null || email.trim().length()==0)
            return false;
        return emailer.matcher(email).matches();
    }
    /**
     * 判断是不是一个合法的电话号码包含座机方式
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone){
        Pattern emailer = Pattern.compile("[1][3578]\\d{9}|[0]{1}[0-9]{2,3}-[0-9]{7,8}|[0]{1}[0-9]{2,3}[0-9]{7,8}");
        if(phone == null || phone.trim().length()==0)
            return false;
        return emailer.matcher(phone).matches();
    }
    /**
     * 校验是否是一个合法的身份证
     * @param msg 身份证号码
     * @param context 上下文
     * @return 合法返回true，不合法返回false
     */
    public static boolean checkIdCard(String msg,Context context){
        //号码的长度 15位或18位
        if(msg.length() != 15 && msg.length() != 18){
            Toast.makeText(context, "身份证号码长度应该为15位或18位。", Toast.LENGTH_SHORT).show();
            return false;
        }
        //数字 除最后以为都为数字
        if (msg.length() == 18) {
            Pattern pattern = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$");
            Matcher isNum = pattern.matcher(msg);
            if(!isNum.matches()){
                Toast.makeText(context, "身份证输入有误", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else if (msg.length() == 15) {
            Pattern pattern = Pattern.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");
            Matcher isNum = pattern.matcher(msg);
            if(!isNum.matches()){
                Toast.makeText(context, "身份证输入有误", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }
}
