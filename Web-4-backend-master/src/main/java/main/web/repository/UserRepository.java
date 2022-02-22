package main.web.repository;

import main.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/* репозитории Spring Data JPA - интерфейсы для дотсупа к данным
 * запросы JPA создаются автоматически из имен методов */
public interface UserRepository extends JpaRepository<User, Long> {
    /* метод для получения юзера по его имени (при логине/регистрации) */
    User findByUsername(String username);
}
