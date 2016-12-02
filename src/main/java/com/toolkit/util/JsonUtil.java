/**
 *
 */
package com.toolkit.util;

import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author jasontang
 */
public class JsonUtil {

    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    /**
     * String转换为JavaBean <strong>描述：</strong> 描述 <br>
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
     * @param json
     * @param classOfT
     * @return
     * @author Robert 2016年11月29日 下午2:27:52
     */
    public static <T> T stringToBean(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    /**
     * JavaBean转换为String <strong>描述：</strong> 描述 <br>
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
     * @param object
     * @return
     * @author Robert 2016年11月29日 下午2:28:50
     */
    public static String beanToString(Object object) {
        return gson.toJson(object);
    }

    /**
     * JavaBean转换为String <strong>描述：</strong> 描述 <br>
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
     * @param object
     * @param tokenType
     * @return
     * @author Robert 2016年11月29日 下午2:29:06
     */
    public static String beanToString(Object object, TypeToken<?> tokenType) {
        return gson.toJson(object, tokenType.getType());
    }

    /**
     * String转换为JavaBean <strong>描述：</strong> 描述 <br>
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
     * @param json
     * @param tokenType
     * @return
     * @author Robert 2016年11月29日 下午2:28:20
     */
    public static <T> T stringToBean(String json, TypeToken<?> tokenType) {
        return gson.fromJson(json, tokenType.getType());
    }

    /**
     * Json string转换为Java List <strong>描述：</strong> 描述 <br>
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
     * @param json
     * @param clazz
     * @return
     * @author Robert 2016年11月29日 下午2:29:14
     */
    public static <T> List<T> jsonToList(String json, Class<T[]> clazz) {
        T[] array = gson.fromJson(json, clazz);
        return Arrays.asList(array);
    }
}