package com.lefu.model.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by shuyan.qi on 2017/5/17.
 */
public class BeanUtil {
    private Logger logger  = LoggerFactory.getLogger(BeanUtil.class);

    /**
     *
     * @param map key为需要转换的bean的成员变量名
     * @param tClass 转换类型
     * @param <T> 返回bean
     * @return
     */
    public static <T> T map2Bean(Map<String,Object> map,Class tClass){
        T bean = null;

        try {
            bean = (T) tClass.newInstance();

            Iterator<Map.Entry<String, Object>> iterator =
                    map.entrySet().iterator();

            while (iterator.hasNext()){
                
            }
            Field[] fields = tClass.getDeclaredFields();

            for (int i = 0;i < fields.length;i++){
                Field field = fields[i];

                String fieldName = field.getName();
                Object value = map.get(fieldName);

                field.setAccessible(true);
                field.set(bean,value);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return bean;
    }

}
