package com.example.springlearndomain.com.type;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: yanglijun
 * @Date: 2021/8/8 22:23
 * @Version: 1.0
 * @Description:
 */

public class ParameterizedTypeTest {
    /**
     * 1、map: 获取ParameterizedType:class java.lang.String
     * 2、map: 获取ParameterizedType:class com.wangji.demo.ParameterizedTypeTest
     * 3、map:getOwnerType is null
     * 4、map:getRawType:interface java.util.Map
     */
    private Map<String, ParameterizedTypeTest> map;
    /**
     * 1、set1: 获取ParameterizedType:class java.lang.String
     * 2、set1:getOwnerType is null
     * 3、set1:getRawType:interface java.util.Set
     */
    private Set<String> set1;
    /**
     * 1、 clz: 获取ParameterizedType:?
     * 2、 clz:getOwnerType is null
     * 3、clz:getRawType:class java.lang.Class
     */
    private Class<?> clz;
    /**
     * 1、holder: 获取ParameterizedType:class java.lang.String
     * 2、holder:getOwnerType:class com.wangji.demo.ParameterizedTypeTest
     * 3、holder:getRawType:class com.wangji.demo.ParameterizedTypeTest$Holder
     */
    private Holder<String> holder;

    /**
     * 1、list: 获取ParameterizedType:class java.lang.String
     * 2、list:getOwnerType is null
     * 3、list:getRawType:interface java.util.List
     */
    private List<String> list;
    /**
     * str:is not ParameterizedType
     */
    private String str;
    /**
     * i:is not ParameterizedType
     */
    private Integer i;
    /**
     * set:is not ParameterizedType
     */
    private Set set;
    /**
     *  aList:is not ParameterizedType
     */
    private List aList;
    /**
     * 1、entry: 获取ParameterizedType:class java.lang.String
     * 2、entry: 获取ParameterizedType:class java.lang.String
     * 3、entry:getOwnerType:interface java.util.Map
     * 4、entry:getRawType:interface java.util.Map$Entry
     */
    private Map.Entry<String, String> entry;


    static class Holder<V> {

    }

    public static void main(String[] args) {
        Field[] declaredFields = ParameterizedTypeTest.class.getDeclaredFields();
        Class<ParameterizedTypeTest> parameterizedTypeTestClass = ParameterizedTypeTest.class;
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            if (declaredField.getGenericType() instanceof ParameterizedType){
                ParameterizedType genericType = (ParameterizedType) declaredField.getGenericType();
                System.out.println(genericType.getActualTypeArguments());
                for (Type actualTypeArgument : genericType.getActualTypeArguments()) {
                    System.out.println(actualTypeArgument.getTypeName()+"                 "+actualTypeArgument);
                }

            }
        }

    }


}
