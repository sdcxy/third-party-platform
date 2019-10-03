package com.github.sdcxy.util;


import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * @ClassName CheckObjectIsNullUtils
 * @Description TODO
 * @Author lxx
 * @Date 2019/9/29 10:06
 **/
public class CheckObjectIsNullUtils {

    /**
     * 判断对象属性是否存在一个不为null 返回true 否则返回false
     * @param object
     * @return
     */
    public static boolean isNotEmpty(Object object) {
        // 获取类对象
        Class<?>  clazz = (Class)object.getClass();

        // 得到所有属性
        Field[] fields = clazz.getDeclaredFields();

        boolean resultFlag = false;

        for (Field field : fields) {
            // 设置属性可见
            field.setAccessible(true);
            Object fieldValue = null;
            try {
                // 得到属性值
                fieldValue = field.get(object);
                //得到属性类型
                //Type fieldType = field.getGenericType();
                // 得到属性名
                //String fieldName = field.getName();
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
            //只要有一个属性值不为null 就返回false 表示对象不为null
            if (fieldValue != null) {
                resultFlag =  true;
                break;
            }
        }
        return resultFlag;
    }
}
