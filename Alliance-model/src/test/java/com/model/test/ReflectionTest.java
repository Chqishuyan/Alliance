package com.model.test;

import org.junit.Test;

import java.lang.reflect.Field;

/**  测试java反射类的api
 * Created by shuyan.qi on 2017/5/18.
 */
public class ReflectionTest {



    @Test
    public void test01(){
        Person person = null;
        try {
            Class<Person> personClass = Person.class;
            person =  personClass.newInstance();

            Field[] fields = personClass.getDeclaredFields();
            for (int i = 0 ; i < fields.length;i++){
               Field field =  fields[i];
                String name = field.getName();
                field.setAccessible(true);
                if("age".equals(name)){
                    field.set(person,6);
                }else if("name".equals(name)){
                    field.set(person,"xiaoming");
                }
            }

            System.out.println(person);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
