package com.asgarov.spring_jdbc;

import com.asgarov.spring_jdbc.config.Config;
import com.asgarov.spring_jdbc.dao.SingerDao;
import com.asgarov.spring_jdbc.entity.Singer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class SpringJdbcDemo {
    private static SingerDao singerDao;

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(Config.class);
        singerDao = ctx.getBean(SingerDao.class);

        System.out.println("Listing initial singer data: ");

        listAllSingers();

        System.out.println("-------------");
        System.out.println("Insert a  new singer");
        Singer singer = new Singer();
        singer.setFirstName("Ed");
        singer.setLastName("Sheeran");
        singer.setBirthDate(new Date
                ((new GregorianCalendar(1991, 2, 1991)).getTime().getTime()));
        singerDao.insert(singer);
        System.out.println("Listing singer data after new singer created:");

        listAllSingers();
        System.out.println("-------------");
        System.out.println("Deleting the previous created singer");
        singerDao.delete(singer.getId());
        System.out.println("Listing singer data after new singer deleted:");
        listAllSingers();
    }

    private static void listAllSingers() {
        List<Singer> singers = singerDao.findAll();
        for (Singer singer : singers) {
            System.out.println(singer.toString());
        }
    }
}
