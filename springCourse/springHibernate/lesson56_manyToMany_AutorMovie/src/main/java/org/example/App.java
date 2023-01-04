package org.example;


import org.example.model.Actor;
import org.example.model.Movie;
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
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Actor.class).addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try(sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
//1.создаем фильм и актеров к нему и пишем в БД
//            Movie movie = new Movie("Pulp fiction",1994);
//            Actor actor1 = new Actor("Samuel L.Jakson",72);
//            Actor actor2 = new Actor("Harvey Keitel",81);
//            movie.setActors(new ArrayList<>(List.of(actor1,actor2)));
//            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            session.save(movie);
//            session.save(actor1);
//            session.save(actor2);
//2.берем фильм из БД и отображаем его актеров (и актера - печатаем фильм)
//            Movie movie = session.get(Movie.class,1);
//            for (Actor a : movie.getActors()) System.out.println(a);
//              Actor actor = session.get(Actor.class,2);
//              for (Movie m : actor.getMovies()) System.out.println(m);
//3.добавим новый фильм и назначим туда актера
//            Movie movie = new Movie("Reservoir Dogs",1992);
//            Actor actor = session.get(Actor.class,1);
//            movie.setActors(new ArrayList<>(Collections.singletonList(actor)));
//            actor.getMovies().add(movie);
//            session.save(movie);
//4.удаляем актера из фильма
//            Actor actor = session.get(Actor.class,2);
//            System.out.println(actor.getMovies());
//            Movie removeMovie = actor.getMovies().get(0);
//            actor.getMovies().remove(0);
//            removeMovie.getActors().remove(actor);

            session.getTransaction().commit();
        }


    }
}
