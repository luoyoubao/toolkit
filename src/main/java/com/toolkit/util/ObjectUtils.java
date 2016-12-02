package com.toolkit.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ObjectUtils {

    /**
     * 复制JavaBean <strong>描述：</strong> 描述 <br>
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
     * @param sourceObj
     * @param targetObj
     * @param clazz
     * @throws Exception
     * @author Robert 2016年11月28日 上午10:42:45
     */
    public static void copyAttribute(Object sourceObj, Object targetObj, Class<?> clazz) throws Exception {
        if (sourceObj == null || targetObj == null) {
            throw new Exception("Source object and target object cannot be null");
        }
        if (targetObj.getClass().getSuperclass() != sourceObj.getClass()) {
            throw new Exception("Child is not a subclass of father");
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            int modify = field.getModifiers();
            // 忽略final&static属性
            if (Modifier.isFinal(modify) || Modifier.isStatic(modify)) {
                continue;
            }
            field.setAccessible(true);
            Object sourceValue = field.get(sourceObj);
            if (null != sourceValue && isBeanField(sourceValue)) {
                field.set(targetObj, sourceValue);
            }
        }
    }

    private static boolean isBeanField(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        if (obj instanceof Integer) {
            return true;
        }
        if (obj instanceof Double) {
            return true;
        }
        if (obj instanceof Float) {
            return true;
        }
        if (obj instanceof Long) {
            return true;
        }
        if (obj instanceof Boolean) {
            return true;
        }
        return false;
    }
}