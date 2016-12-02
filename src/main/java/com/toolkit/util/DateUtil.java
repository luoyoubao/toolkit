package com.toolkit.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private final static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取系统当前时间 <strong>描述：</strong> 描述 <br>
     * <strong>功能：</strong><br>
     * <strong>使用场景：</strong><br>
     * <strong>注意事项：</strong>
     * <ol>
     * <li></li>
     * </ol>
     * <strong>调用举例：</strong>
     *
     * <pre>
     * </pre>
     *
     * @return
     * @author Robert 2016年11月27日 下午5:05:41
     */
    public static Date getCurrentTime() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 时间字符串String转换为Date类型 <strong>描述：格式yyyy-MM-dd HH:mm:ss</strong> 描述 <br>
     * <strong>功能：</strong><br>
     * <strong>使用场景：</strong><br>
     * <strong>注意事项：</strong>
     * <ol>
     * <li></li>
     * </ol>
     * <strong>调用举例：</strong>
     *
     * <pre>
     * </pre>
     *
     * @param date
     * @return
     * @throws ParseException
     * @author Robert 2016年11月28日 上午10:38:11
     */
    public static Date getTime(String date) throws ParseException {
        return sdf.parse(date);
    }

    /**
     * 获取本周一的日期 <strong>描述：</strong> 描述 <br>
     * <strong>功能：</strong><br>
     * <strong>使用场景：</strong><br>
     * <strong>注意事项：</strong>
     * <ol>
     * <li></li>
     * </ol>
     * <strong>调用举例：</strong>
     *
     * <pre>
     * </pre>
     *
     * @return
     * @author Robert 2016年10月10日 下午3:08:24
     */
    public static Date getMondayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return calendar.getTime();
    }

    /**
     * 获取本周日的日期 <strong>描述：</strong> 描述 <br>
     * <strong>功能：</strong><br>
     * <strong>使用场景：</strong><br>
     * <strong>注意事项：</strong>
     * <ol>
     * <li></li>
     * </ol>
     * <strong>调用举例：</strong>
     *
     * <pre>
     * </pre>
     *
     * @return
     * @author Robert 2016年10月10日 下午3:13:34
     */
    public static Date getSundayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        calendar.add(Calendar.WEEK_OF_YEAR, 1);
        return calendar.getTime();
    }

    /**
     * 获取上周一日期 <strong>描述：</strong> 描述 <br>
     * <strong>功能：</strong><br>
     * <strong>使用场景：</strong><br>
     * <strong>注意事项：</strong>
     * <ol>
     * <li></li>
     * </ol>
     * <strong>调用举例：</strong>
     *
     * <pre>
     * </pre>
     *
     * @return
     * @author Robert 2016年10月10日 下午11:37:36
     */
    public static Date getLastMondayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        return calendar.getTime();
    }

    /**
     * 获取上周日日期 <strong>描述：</strong> 描述 <br>
     * <strong>功能：</strong><br>
     * <strong>使用场景：</strong><br>
     * <strong>注意事项：</strong>
     * <ol>
     * <li></li>
     * </ol>
     * <strong>调用举例：</strong>
     *
     * <pre>
     * </pre>
     *
     * @return
     * @author Robert 2016年10月10日 下午11:38:53
     */
    public static Date getLastSundayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return calendar.getTime();
    }

    /**
     * 获取某个季度的起始日
     *
     * @param quarter
     * @return
     */
    public static Date getCurrentQuarterStartTime(int quarter) {
        Calendar c = Calendar.getInstance();
        switch (quarter) {
            case 1:
                c.set(Calendar.MONTH, 0);
                break;
            case 2:
                c.set(Calendar.MONTH, 3);
                break;
            case 3:
                c.set(Calendar.MONTH, 6);
                break;
            case 4:
                c.set(Calendar.MONTH, 9);
                break;
            default:
                break;
        }
        c.set(Calendar.DATE, 1);
        return c.getTime();
    }

    /**
     * 获取某个季度的结束日
     *
     * @param quarter
     * @return
     */
    public static Date getCurrentQuarterEndTime(int quarter) {
        Calendar c = Calendar.getInstance();
        switch (quarter) {
            case 1:
                c.set(Calendar.MONTH, 2);
                c.set(Calendar.DATE, 31);
                break;
            case 2:
                c.set(Calendar.MONTH, 5);
                c.set(Calendar.DATE, 30);
                break;
            case 3:
                c.set(Calendar.MONTH, 8);
                c.set(Calendar.DATE, 30);
                break;
            case 4:
                c.set(Calendar.MONTH, 11);
                c.set(Calendar.DATE, 31);
                break;
            default:
                break;
        }
        return c.getTime();
    }
}