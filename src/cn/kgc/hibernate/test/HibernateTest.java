package cn.kgc.hibernate.test;

import cn.kgc.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;
/**
 * @program: HibernateTest
 * @description: hibernate测试类
 * @author: LYH
 * @create: 2020-02-12 14:20
 **/
public class HibernateTest {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    @Before
    public void init() {
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
                .buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }
    @After
    public void destroy() {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    @Test
    public void test() {
        User user1 = (User) session.get(User.class, 1);
        System.out.println("user1 = " + user1);
        User user2 = (User) session.get(User.class, 1);
        System.out.println("user2 = " + user2);
    }
    @Test
    public void testFlush() {
        User user1 = (User) session.get(User.class, 1);
        user1.setPassword("123123");
        System.out.println("user1 = " + user1);
        User user2 = (User) session.get(User.class, 1);
        System.out.println("user2 = " + user2);
    }
    @Test
    public void testGet() {
        User user1 = (User) session.get(User.class, 10);
        System.out.println("user1 = " + user1);
    }
    @Test
    public void testLoad() {
        User user1 = (User) session.load(User.class, 10);
        System.out.println("user1 = " + user1);
    }
    @Test
    public void testSave() {
        User user = new User("大大", "44124", new Date());
        session.save(user);
    }
    @Test
    public void testPersist() {
        User user = new User("麻瓜", "1433223", new Date());
        session.persist(user);
    }
    @Test
    public void testClear() {
        User user1 = (User) session.get(User.class, 1);
        System.out.println("user1 = " + user1);
        //清理缓存
        session.clear();
        User user2 = (User) session.get(User.class, 1);
        System.out.println("user2 = " + user2);
    }
    @Test
    public void testUpdate() {
        User user = new User();
        user.setPassword("6566");
        user.setId(9);
        session.update(user);
    }
}
