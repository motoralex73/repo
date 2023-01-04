package org.example;


import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
//1
//            Person person = session.get(Person.class,1);
//            System.out.println(person);
//
//            Item newItem = new Item("Playstation",person);
//            person.getItems().add(newItem);
//            session.save(newItem);
//
//            List<Item> items = person.getItems();
//            for (Item i : items) System.out.println(i);
//2
            //Person person = session.get(Person.class,3);
            //person.setName("Kirill");
            //session.delete(person);
//            Person person = new Person("Kirill",44);
//            session.save(person);
// 3.HQL
//            List<Person> list = session.createQuery("FROM Person where age < 41").getResultList();
//            for (Person p : list) System.out.println(p);
            //session.createQuery("delete from Person where age=44").executeUpdate();
//4.создание нового человека и товаров. Каскадирование - связь между сущностями, сохранив товар - сохраняем и владельца
//            Person person = new Person("Semen",12);
//            Item newItem = new Item("Nindendo",person);
//            person.setItems(new ArrayList<Item>(Collections.singletonList(newItem)));
//            session.save(person);
//            session.save(newItem);
//5.удаление всех заказов у человека
//            Person person = session.get(Person.class,4);
//            List<Item> items = person.getItems();
//            for (Item i : items) session.remove(i);
//            person.getItems().clear();
//6.удаление самого человека из базы данных, а заказаы его будут в null
//            Person person = session.get(Person.class,2);
//            session.remove(person);
//            //чтобы было правильное состояние Hibernate кэша
//            person.getItems().forEach(i -> i.setOwner(null));
//7.меняем владельца у товаров
            Person person = session.get(Person.class,1);
            Item item = session.get(Item.class,2);
            item.getOwner().getItems().remove(item);
            //SQL
            item.setOwner(person);
            person.getItems().add(item);

            session.getTransaction().commit();
            //System.out.println("id = "+person.getId());

        }
        finally {
            sessionFactory.close();
        }

    }
}
