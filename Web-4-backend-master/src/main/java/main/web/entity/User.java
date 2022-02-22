package main.web.entity;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/* аннотации, которые используются в стандарте JPA и в различных фреймворках вроде Hibernate(кроме).
* @Entity – Указывает, что данный бин (класс) является сущностью.
* @Table – указывает на имя таблицы, которая будет отображаться в этой сущности.
* @id - id колонки
* @Data - аннотация из lombook. Она на этапе компиляции сгенерирует геттеры\сеттеры
*  для всех полей, toString и переопределит equals и hashCode по стандартам. В IDE
*  можно установить плагин и он будет видеть все ещё не созданные методы.*/
@Data
@Entity
@Table(name = "usrs")
public class User {

    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    public User() {
    }

//    public User(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }
}
