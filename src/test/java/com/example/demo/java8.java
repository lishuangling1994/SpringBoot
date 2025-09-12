package com.example.demo;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Auror : lsl
 * @Date: 2025-09-01 16:58
 */
public class java8 {
    @Test
    public void lambda1(){
        /** 原始写法**/
        Runnable r1=new Runnable() {
            @Override
            public void run() {
                System.out.println("线程执行了"+Thread.currentThread().getName());
            }
        };
        new Thread(r1).start();

        Runnable r2=()->System.out.println("线程执行了"+Thread.currentThread().getName());
        new Thread(r2).start();
        new Thread(()->System.out.println("线程执行了"+Thread.currentThread().getName())).start();
    }
    /*创建一个Compertor比较器*/
    public void lambda2(){
        Comparator comparator=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
        Set s=new TreeSet(comparator);
        Set s1=new HashSet();

        Comparator comparator1=(o1, o2) -> {return o1.hashCode()-o2.hashCode();};
    }
    /*stream流的测试*/
    @Test
    public void StreamTest(){
        List<Integer> list=new ArrayList<Integer>();
        for (int i=0;i<10;i++){
            list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(list);
        System.out.println(list.stream().count());

    }
    @Test
    public void StreamTeat01(){
        List<String> as=new ArrayList<>();
        as.add("双岭");
        as.add("凯子2");
        as.add("张东34");
        System.out.println("=======过滤======");
        as.stream().filter(s->s.length()==2).forEach(s -> System.out.println(s));
        System.out.println("=========限制=====");
        as.stream().limit(2).forEach(System.out::println);
        System.out.println("=======排序=====");
        as.stream().sorted().forEach(System.out::println);
        System.out.println("=======跳过=====");
        as.parallelStream().skip(1).forEach(System.out::println);
        System.out.println("=======排序2=====");
        as.stream()
                .sorted((s1,s2)->s2.length()-s1.length())
                .forEach(s->System.out.println(s));
    }

    /*验证SimpleDateForat的线程不安全*/
    @Test
    public void Date8Test() throws Exception{
        ExecutorService es= Executors.newFixedThreadPool(10);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Callable<Date> ca=()->{
            synchronized(sdf){
                return sdf.parse("2025-09-09");
            }
        };
        List<Future<Date> > ls=new ArrayList<Future<Date> >();
        for (int i = 0; i < 10; i++) {
            Future<Date> futureTask=es.submit(ca);
            ls.add(futureTask);
        }
        for(Future<Date> l : ls ){
            System.out.println(l.get());
        }

       es.shutdown();

    }

    /*使用java8线程安全的方法解决问题*/
    @Test
    public void localDate8Test() throws Exception{
        ExecutorService executorService=Executors.newFixedThreadPool(10);
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyyMMdd");
        List<Future<LocalDate>> ls=new ArrayList();
        Callable<LocalDate> callable=new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("20250306",dateTimeFormatter);
            }
        };
        for (int i = 0; i <10 ; i++) {
            Future<LocalDate> future=executorService.submit(callable);
            ls.add(future);
        }
        for (Future<LocalDate> f:
             ls) {
            System.out.println(f.get()
            );
        }

    }

    /*获取两个字符串日期之间的天数，月数*/
    @Test
    public void getDays(){
        String begin="1994-12-31";
        String end="2025-09-03";
        String end1="1970-01-02";
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate lBeginDate=LocalDate.parse(begin,dateTimeFormatter);
        LocalDate lEndDate=LocalDate.parse(end,dateTimeFormatter);
        LocalDate lEndDate1=LocalDate.parse(end1,dateTimeFormatter);
        long l1=lEndDate1.toEpochDay();
        long l2=lEndDate.toEpochDay();
        long l3=lBeginDate.toEpochDay();
        long days=lEndDate.toEpochDay()-lBeginDate.toEpochDay();
        long day2=ChronoUnit.DAYS.between(lBeginDate,lEndDate);
        long day3=Duration.between(lBeginDate.atTime(00,00),lEndDate.atTime(00,00)).toDays();
        System.out.println(days);
        System.out.println(day2);
        System.out.println(day3);

    }
}
