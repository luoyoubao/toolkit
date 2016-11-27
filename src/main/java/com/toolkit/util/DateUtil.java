package com.toolkit.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

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