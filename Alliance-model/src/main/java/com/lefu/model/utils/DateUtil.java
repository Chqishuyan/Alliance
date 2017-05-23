package com.lefu.model.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by shuyan.qi on 2017/5/17.
 */
public class DateUtil {
        static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        /**
         * 获取前一个月的第一天
         * @param date 格式如yyyy-MM-dd
         * @return
         * @throws ParseException
         */
        public static String getfirstOfPrevMonth(String date) throws ParseException{
            Date date2 = sdf.parse(date);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date2);
            calendar.add(Calendar.MONTH, -1);//获取上个月
            calendar.set(Calendar.DAY_OF_MONTH, 1);//获取月份第一天

            return sdf.format(calendar.getTime());
        }

        /**
         * 获取当天
         * @return
         */
        public static String getToday()
        {
            return sdf.format(new Date());
        }

        /**
         *
         * 生成与某一天相差特定天数的日期
         *
         * @param date 如：2015-05-01
         * @param pattern 如：YYYY-MM-DD
         * @param days 0 为当天
         * @return
         * @see [类、类#方法、类#成员]
         */
        public static String getFixedDays(String date, String pattern, Integer days)
        {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            Date d = new Date();
            try
            {
                d = simpleDateFormat.parse(date);
            }
            catch (ParseException e)
            {
                System.out.println("日期格式不正确");
                e.printStackTrace();
                return null;
            }
            Calendar day = Calendar.getInstance();
            day.setTime(d);
            day.add(Calendar.DATE, days);
            String nextDay = simpleDateFormat.format(day.getTime());
            return nextDay;
        }

        /**
         * 计算两个日期的日差
         * @param smdate
         * @param bdate
         * @return
         * @throws Exception
         * @author ji.li
         */
        public static int daysBetween(String smdate,String bdate) throws Exception
        {
            Date newSmdate=sdf.parse(smdate);
            Date newBdate=sdf.parse(bdate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(newSmdate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(newBdate);
            long time2 = cal.getTimeInMillis();
            long between_days=(time2-time1)/(1000*3600*24);

            return Math.abs(Integer.parseInt(String.valueOf(between_days)));
        }
        /**
         * 迭代出两个时期间的所有日期
         * @param smdate
         * @param bdate
         * @return
         * @throws Exception
         * @author ji.li
         */
        public static String[] iteratorDate(String smdate,String bdate) throws Exception{
            int daysBetween = daysBetween(smdate,bdate);
            String[] dates = new String[daysBetween+1];
            dates[0] =smdate;
            for (int i = 1; i <= daysBetween; i++) {
                dates[i]=operDate(smdate,(i));
            }
            return dates;
        }
        /**
         * 按照DAY加减日期
         * @param date
         * @param oper
         * @return
         * @throws java.text.ParseException
         * @author ji.li
         */
        public static String operDate(String date,int oper) throws java.text.ParseException{
            Calendar calendar=Calendar.getInstance();
            calendar.setTime(sdf.parse(date));
            calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+oper);//让日期加1
            return sdf.format(calendar.getTime());
        }

        /**
         * 按照DAY加减日期（在当月内操作，最小日期为当月第一天）
         * @param date
         * @param oper
         * @return
         * @throws java.text.ParseException
         * @author chao.chen
         */
        public static String operDateInMonth(String date,int oper) throws java.text.ParseException{
            Calendar calendar=Calendar.getInstance();
            calendar.setTime(sdf.parse(date));
            calendar.set(Calendar.DAY_OF_MONTH,
                    (
                            1==calendar.get(Calendar.DAY_OF_MONTH)?
                                    1 :
                                    calendar.get(Calendar.DAY_OF_MONTH)+oper
                    )
            );
            return sdf.format(calendar.getTime());
        }



        /**
         * 当月第一天
         * @return
         * @throws ParseException
         */
        public static String getFirstDay(String date) throws ParseException {
            Date theDate = sdf.parse(date);
            GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
            gcLast.setTime(theDate);
            gcLast.set(Calendar.DAY_OF_MONTH, 1);
            String day_first = sdf.format(gcLast.getTime());
            return day_first;
        }


        /**
         * 当月最后一天
         * @return
         * @throws ParseException
         */
        public static String getLastDay(String date) throws ParseException {
            Date theDate = sdf.parse(date);
            GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
            gcLast.setTime(theDate);
            gcLast.set(Calendar.DAY_OF_MONTH, gcLast.getActualMaximum(Calendar.DAY_OF_MONTH));
            String day_first = sdf.format(gcLast.getTime());
            return day_first;
        }


        /**
         * 判断指定日期是当月第几天
         * @return
         * @throws ParseException
         */
        public static int getDayOfMonth(String date) throws ParseException {
            Date theDate = sdf.parse(date);
            GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
            gcLast.setTime(theDate);
            return gcLast.get(Calendar.DAY_OF_MONTH);
        }


        /**
         * 指定日期相差月份第一天
         * @Description  一句话描述方法用法
         * @param date
         * @param addMonth
         * @return
         * @throws ParseException
         * @see
         */
        public static String getMonthFirstDay(String date,int addMonth) throws ParseException {
            Date theDate = sdf.parse(date);
            GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
            gcLast.setTime(theDate);
            gcLast.add(Calendar.MONTH, addMonth);
            gcLast.set(Calendar.DAY_OF_MONTH, 1);
            String day_first = sdf.format(gcLast.getTime());
            return day_first;
        }

        /**
         * 指定日期相差月份最后一天
         * @Description  一句话描述方法用法
         * @param date
         * @param addMonth
         * @return
         * @throws ParseException
         * @see
         */
        public static String getMonthLastDay(String date,int addMonth) throws ParseException {
            Date theDate = sdf.parse(date);
            GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
            gcLast.setTime(theDate);
            gcLast.add(Calendar.MONTH, addMonth);
            gcLast.set(Calendar.DAY_OF_MONTH, gcLast.getActualMaximum(Calendar.DAY_OF_MONTH));
            String day_first = sdf.format(gcLast.getTime());
            return day_first;
        }

        public static void main(String[] args) {
            try {
                String today = "2016-10-06";
                int i = DateUtil.getDayOfMonth(today);
                // 当月第一天
                String currFirstDay = DateUtil.getFirstDay(today);
                // 昨天
                String yesterday = DateUtil.getFixedDays(today, "yyyy-MM-dd", -1);
                // 昨天所在的月份起始日期
                String starDate = DateUtil.getFirstDay(yesterday);
                // 下个月第一天
                String nextFirstDate = DateUtil.getMonthFirstDay(today, 1);
                if(i <=5 )
                {
                    // 查询上个月到5号之前的数据，5号之后只查询当月数据
                    // 上个月第1天
                    starDate = DateUtil.getMonthFirstDay(today,-1);
                }

                System.out.println("CrcmListTask 【"+starDate +"】至【"+yesterday+"】 " );
                String createTime = "2016-09-11";
                /**
                 * 2、缓存中存在的数据则覆盖更新
                 */
                if( i == 5 && createTime.compareTo(currFirstDay) < 0)
                {
                    System.out.println("111111111111" + nextFirstDate);
                }
                else
                {
                    System.out.println("222222");
                }


            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

}
