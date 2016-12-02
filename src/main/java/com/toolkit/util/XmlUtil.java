package com.toolkit.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.SingleValueConverter;

/*
 * XML序列化与反序列化工具类
 * File name   : XStreamUtil.java
 * @Copyright  : www.quancheng-ec.com
 * Description : qcFinancialPay
 * Author      : Robert
 * CreateTime  : 2016年4月15日
 */
public final class XmlUtil {

    public static String toXml(Object obj) {
        XStream xstream = new XStream();
        // 处理XML中的下划线
        // XStream xstream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));
        xstream.autodetectAnnotations(true);
        return xstream.toXML(obj);
    }

    @SuppressWarnings("unchecked")
    public static <T> T xmlToBean(String xml) {
        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        xstream.registerConverter(new NumberConverter());
        xstream.ignoreUnknownElements(); // 忽略掉XML中多余的字段
        return (T) xstream.fromXML(xml);
    }

    @SuppressWarnings("unchecked")
    public static <T> T xmlToBean(String xml, String aliasName, Class<?> classType) {
        XStream xstream = new XStream();
        xstream.alias(aliasName, classType);
        xstream.autodetectAnnotations(true);
        xstream.ignoreUnknownElements(); // 忽略掉XML中多余的字段
        xstream.registerConverter(new NumberConverter());
        return (T) xstream.fromXML(xml);
    }

    static class NumberConverter implements SingleValueConverter {

        public boolean canConvert(@SuppressWarnings("rawtypes") Class type) {
            return type.equals(int.class) || type.equals(Integer.class);
        }

        public Object fromString(String str) {
            /* If empty tag. */
            if (null == str || "".equals(str)) {
                str = "0";
            }
            return Integer.decode(str);
        }

        public String toString(Object obj) {
            return obj.toString();
        }
    }
}