package com.liquor.java8.demo.test2;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author Liquor.Huang
 * @Date 2020/12/28 16:34
 * To change this template use File | Settings | File Templates.
 */
public class TestLocalDateTime {
    //1.LocalDate、LocalTime、LocalDateTime
    @Test
    public void test1() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ld2 = LocalDateTime.of(2020, 12, 28, 16, 36, 45);
        System.out.println(ld2);

        LocalDateTime ldt3 = ld2.plusYears(20);//加上二十年
        System.out.println(ldt3);

        LocalDateTime ldt4 = ld2.minusMonths(2);//减去两个月
        System.out.println(ldt4);

        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonth());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getHour());
        System.out.println(ldt.getMinute());
        System.out.println(ldt.getSecond());
    }

    //2. Instant : 时间戳。 （使用 Unix 元年  1970年1月1日 00:00:00 所经历的毫秒值）
    @Test
    public void test2() {
        Instant ins = Instant.now();    //默认使用UTC时区
        System.out.println(ins);

        OffsetDateTime odt = ins.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);

        System.out.println(ins.getNano());

        Instant ins2 = Instant.ofEpochSecond(5);
        System.out.println(ins2);
    }

    //3.
    //Duration : 用于计算两个“时间”间隔
    //Period : 用于计算两个“日期”间隔
    @Test
    public void test3() {
        Instant ins1 = Instant.now();
        System.out.println(ins1);

        System.out.println("-----------------------");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        Instant ins2 = Instant.now();
        System.out.println(ins2);

        System.out.println("所耗费时间为：" + Duration.between(ins1, ins2));

        System.out.println("--------------------------------");

        LocalDate ld1 = LocalDate.now();
        LocalDate ld2 = LocalDate.of(2011, 1, 1);

        Period pe = Period.between(ld1, ld2);
        System.out.println(pe.getYears());
        System.out.println(pe.getMonths());
        System.out.println(pe.getDays());
    }

    //4. TemporalAdjuster : 时间校正器
    @Test
    public void test4() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = ldt.withDayOfMonth(10);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt3);

        //自定义：下一个工作日
        LocalDateTime ldt5 = ldt.with((l) -> {
            LocalDateTime ldt4 = (LocalDateTime) l;

            DayOfWeek dow = ldt4.getDayOfWeek();

            if (dow.equals(DayOfWeek.FRIDAY)) {
                return ldt4.plusDays(3);
            } else if (dow.equals(DayOfWeek.SATURDAY)) {
                return ldt4.plusDays(2);
            } else {
                return ldt4.plusDays(1);
            }
        });
        System.out.println(ldt5);
    }

    //5. DateTimeFormatter : 解析和格式化日期或时间
    @Test
    public void test() {
//        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss E");

        LocalDateTime ldt = LocalDateTime.now();
        String strDate = ldt.format(dtf);

        System.out.println(strDate);

        LocalDateTime newLdt = ldt.parse(strDate, dtf);
        System.out.println(newLdt);
    }

    @Test
    public void test6() {
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);
    }

    //6.ZonedDate、ZonedTime、ZonedDateTime ： 带时区的时间或日期
    @Test
    public void test7() {
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(ldt);

        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("US/Pacific"));
        System.out.println(zdt);
    }


}
