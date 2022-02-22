package main.web.repository;

import main.web.entity.Point;
import main.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/* репозитории Spring Data JPA - интерфейсы для дотсупа к данным
* запросы JPA создаются автоматически из имен методов
* JPA - https://ru.wikipedia.org/wiki/Java_Persistence_API */
public interface PointRepository extends JpaRepository<Point, Long> {

    /* метод для получения коллекции выстрелов по юзеру */
    Collection<Point> findByUser(User user);
}