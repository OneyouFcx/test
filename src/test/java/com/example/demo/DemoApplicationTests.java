package com.example.demo;

import com.alibaba.druid.support.json.JSONUtils;
import com.example.demo.dom.Persion;
import com.example.demo.util.DateUtil;
import lombok.Cleanup;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toList;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DemoApplicationTests {












    @Test
    public void test(){
        String result2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(DateUtil.getTimeMillis("14:00:00"));

        String result3= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
        System.out.println(result2);
        System.out.println(result3);

        //2018-12-18 14:00:00
        //2018-12-18 15:51:00
    }

























    @Test
    public void Testdelete() throws Exception {
        Persion p = new Persion();
        p.setMoney(123);
        p.setLike("嘻嘻哈哈");
        p.setAge(2);
        p.setName("LL");
        Map<String, Object> map = object2Map(p);
        System.out.println(JSONUtils.toJSONString(map));
        Persion ps = new Persion();
        BeanUtils.populate(ps, map);
        System.out.println(ps);
    }


    public static Object map2OJavaBean(Map<String, Object> map, Class<?> bean) {
        if (map == null) {
            return null;
        }
        Object obj = null;
        try {
            obj = bean.newInstance();
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field == null)
                    break;
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }
                field.setAccessible(true);
                field.set(obj, map.get(field.getName()));
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * Bean 转 Map
     *
     * @param obj
     * @return
     */
    public static Map<String, Object> object2Map(Object obj) {
        Map<String, Object> reMap = new HashMap<String, Object>();
        if (obj == null)
            return null;
        try {
            Class<?> objClass = obj.getClass();
            while (objClass != null) {
                Field[] fields = objClass.getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    try {
                        Field f = objClass.getDeclaredField(fields[i].getName());
                        f.setAccessible(true);
                        Object o = f.get(obj);
                        reMap.put(fields[i].getName(), o);
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                objClass = objClass.getSuperclass();
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return reMap;
    }

  /*  @Test
    public void TestDateTimes() {
        Date curDate = DateUtil.parseToDate(DateUtil.formatDate());
        Date qryDate = DateUtil.parseToDate(DateUtil.getAfterDateByFmt(curDate, -1 * 60 * 15, "yyyy-MM-dd HH:mm:ss"));
        log.info("当前时间：{},偏移时间值为:{}", curDate, DateUtil.parseToDate(DateUtil.getAfterDateByFmt(curDate, -1 * 60 * 15, "yyyy-MM-dd HH:mm:ss")));
    }*/


    public static AtomicInteger flag = new AtomicInteger(0);

    @Test
    public void AddTest() {
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread() {
                public void run() {
                    tests();
                }
            };
        }
    }

    public void tests() {

    }

   /* @Test
    public void NameTest() {
        try {
            Date curDate = DateUtil.parseToDate(DateUtil.formatDate());

            log.info("代理/集团间隔时间为:{}", DateUtil.parseToDate(DateUtil.getAfterDateByFmt(curDate, 60, "yyyy-MM-dd HH:mm:ss")));
            int initialDelay = 3600;
            Date last = DateUtil.parseToDate("2018-10-12 15:51:36");
            Date times = DateUtil.getTime("2018-10-12 10:09:56", "yyyy-MM-dd HH:mm:ss");
            log.info("times:{}", times);
            long timeSub = (curDate.getTime() - times.getTime()) / 1000;
            log.info("-------------2018-10-12 15:51:36-------timeSub:{}", timeSub);
            Object step = timeSub;
            int diff = 3600;//Integer.valueOf(step+"");
            Date qryDate = null;
            qryDate = DateUtil.parseToDate(DateUtil.getAfterDateByFmt(curDate, -1 * initialDelay, "yyyy-MM-dd HH:mm:ss"));
            log.info("sss{}", qryDate);
            log.info("查询范围为" + diff + "秒内的数据,当前查询数据的条件范围是[" + DateUtil.getAfterDateByFmt(curDate, -1 * diff, "yyyy-MM-dd HH:mm:ss") + "<----->" + DateUtil.getAfterDateByFmt(qryDate, 0, "yyyy-MM-dd HH:mm:ss"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/


    @Test
    public void HashMapTestLabda() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            entry.setValue(entry.getValue().toUpperCase());
        }
        map.forEach((k, v) -> System.out.println(k + "=" + v));
    }

    @Test
    public void lamdbaTest() {
        String[] atp = {"s1", "s2", "s3"};
        List<String> players = Arrays.asList(atp);
        for (String player : players) {
            System.out.print(player + ";");
        }
        System.out.println();
        players.forEach((i) -> System.out.print(i + ";"));
        System.out.println();
        players.forEach(System.out::print);
    }

    @Test
    public void ControstMoneyTest() {
        List<Persion> listPersion = PersionMsg();
        System.out.println("Money超过 $100  从大到小:");
        List<Persion> se = listPersion.stream()
                .filter((p) -> (p.getMoney() > 100))//过滤数据
                .sorted((p, p2) -> (p2.getMoney() - p.getMoney()))//从大到小
                .limit(4)           //返回四条数据
                .collect(toList());//返回类型
        se.forEach((sa) -> System.out.println(sa.getMoney()));
    }


    @Test
    public void StreamsListLambda() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //使用summaryStatistics方法获得stream 中元素的各种汇总数据
        IntSummaryStatistics stats = numbers
                .stream()
                .mapToInt((z) -> z)
                .summaryStatistics();
        //直接根据汇总数据进行求值
        System.out.println("List中最大的数字 : " + stats.getMax());
        System.out.println("List中最小的数字 : " + stats.getMin());
        System.out.println("所有数字的总和   : " + stats.getSum());
        System.out.println("所有数字的平均值 : " + stats.getAverage());
    }

    @Test
    public void StreamsOrder() {
        List<Persion> listPersion = PersionMsg();
        System.out.println("根据 name 排序,并显示前5个 Java listPersion:");
        List<Persion> sortedJavaProgrammers = listPersion
                .stream()
                .sorted((p, p2) -> (p.getName().compareTo(p2.getName())))
                .limit(4)
                .collect(toList());

        sortedJavaProgrammers.forEach((p) -> System.out.printf("%s %s; %n", p.getName(), p.getName()));

        System.out.println("根据 Money 排序 Java listPersion:");
        sortedJavaProgrammers = listPersion
                .stream()
                .sorted((p, p2) -> (p.getMoney() - p2.getMoney()))
                .collect(toList());
        sortedJavaProgrammers.forEach((p) -> System.out.printf("%s %s; %n", p.getName(), p.getName()));
    }

    @Test
    public void lamdbTestRunnable() {
        new Thread(() -> System.out.println("Hello word")).start();

    }

    public static void main(String[] args) throws IOException {
        @Cleanup InputStream in = new FileInputStream(args[0]);
        @Cleanup OutputStream out = new FileOutputStream(args[1]);
        byte[] b = new byte[10000];
        while (true) {
            int r = in.read(b);
            if (r == -1) break;
            out.write(b, 0, r);
        }
     /*   InputStream in = new FileInputStream(args[0]);
        try {
            OutputStream out = new FileOutputStream(args[1]);
            try {
                byte[] b = new byte[10000];
                while (true) {
                    int r = in.read(b);
                    if (r == -1) break;
                    out.write(b, 0, r);
                }
            } finally {
                if (out != null) {
                    out.close();
                }
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }*/
    }


    @Test
    public void persionTests() {
        Persion persion = new Persion();
        persion.setName("小明");
        persion.setAge(15);
        persion.setLike("是个小弟");
        //实体类上面+@ToString(callSuper=true, includeFieldNames=true)抵消原ToString.
        log.info("psersion-ToString:{}", persion.toString());
    }

    public List<Persion> PersionMsg() {
        List<Persion> list = new ArrayList<>();
        Persion persion = new Persion();
        persion.setName("小明");
        persion.setAge(15);
        persion.setLike("是个小弟");
        persion.setMoney(15);
        Persion persion1 = new Persion();
        persion1.setName("小明1");
        persion1.setAge(15);
        persion1.setLike("是个小弟");
        persion1.setMoney(132);
        Persion persion2 = new Persion();
        persion2.setName("小明3");
        persion2.setAge(15);
        persion2.setLike("是个小弟");
        persion2.setMoney(133);
        Persion persion3 = new Persion();
        persion3.setName("小明2");
        persion3.setAge(15);
        persion3.setLike("是个小弟");
        persion3.setMoney(1355);
        list.add(persion1);
        list.add(persion2);
        list.add(persion3);
        list.add(persion);
        return list;
    }

    @Test
    public void lombokTest() {
        lombokMsg(null);
    }

    //空字符串可以通过  null 不可以通过
    public String lombokMsg(@NonNull String name) {
        return name;
    }

    @Test
    public void sexec() {

    }


/*    @Test
    public void contextLoads() {
        Calendar calendar = DateUtils.toCalendar(new Date());
        try {
        } catch (Exception e) {
            log.info("错误{}", e.getCause());
        }
        log.info("获取年信息【{}】", calendar.getFirstDayOfWeek());
        //获取当前月份
        log.info("测试内容：【{}】", EntityEnum.ADJUST_AMOUNT.getCode());

        log.info("测试内容描述：【{}】", EntityEnum.ADJUST_AMOUNT.getDesc());
    }

    @Test
    public void TestDate() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        String mystrdate = myFormat.format(calendar.getTime());
        log.info("当日期：【{}】", Timestamp.valueOf(mystrdate));
        log.info("当前日期：【{}】", DateUtil.getSunday());
    }*/

    @Test
    public void HashMapTest() {
    }

    @Test
    public void SubTest() {
        String name = "张三";
        String ase = name.substring(0, 2) + "0000";
        log.info("结果{}", ase);
    }

    @Test
    public void BigDecimalget() {
        /*相加*/
        BigDecimal add = objectToBigDecimal(2.2).add(objectToBigDecimal(1.1));
        /*相减*/
        BigDecimal subtract = objectToBigDecimal(2.2).subtract(objectToBigDecimal(1.1));
        /*相乘*/
        BigDecimal multiply = objectToBigDecimal(2.2).multiply(objectToBigDecimal(1.1));
        /*相除*/
        BigDecimal divide = objectToBigDecimal(2.2).divide(objectToBigDecimal(1.1));

        log.info("add：【{}】", add);
        log.info("subtract：【{}】", subtract);
        log.info("multiply：【{}】", multiply);
        log.info("divide：【{}】", divide);
    }


    public static BigDecimal objectToBigDecimal(Object param) {
        if (null == param || "".equals(param)) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(String.valueOf(param));
    }
}
