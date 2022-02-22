package main.web.controllers;

import main.web.entity.User;
import main.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class UserController {
    /* @Autowired - Используя эту аннотацию, не нужно заботиться о том, как лучше всего передать классу
     или bean'у экземпляр другого bean'a. Фреймворк Spring сам найдет нужный bean и подставит
      его значение в свойство, которое отмечено аннотацией @Autowired.
       */
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserService userService;

    /* Аннотация @RequestMapping используется для мапинга (связывания) с URL для
     всего класса или для конкретного метода обработчика.
     ResponseEntity - Это специальный класс, который представляет http-ответ.
      Он содержит тело ответа, код состояния, заголовки. Мы можем использовать его
      для более тонкой настройки http-ответа.
    Он является универсальным типом, и можно использовать любой объект в качестве тела:*/
    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            System.out.println(user.getUsername() + "- That's login already existed");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        System.out.println(user + " registered");
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
//        return new ResponseEntity<>("ok", HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping(value = "/login")
    public Principal user(Principal principal) {
        System.out.println(principal.getName() + " is logined");
        return principal;
    }
}

