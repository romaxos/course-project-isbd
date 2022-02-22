package main.web.service;

import main.web.entity.User;
import main.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/* @Service - (Сервис-слой приложения) Аннотация, объявляющая, что этот класс представляет
 собой сервис – компонент сервис-слоя. Сервис является подтипом класса @Component. Использование
  данной аннотации позволит искать бины-сервисы автоматически. */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /* Реализация PasswordEncoder, использующего функцию сильного хеширования BCrypt.
    Клиенты могут по желанию предоставить «силу» (также известную как циклы журналирования в BCrypt)
    и экземпляр SecureRandom. Чем больше параметр надежности, тем больше работы потребуется (в геометрической прогрессии)
     для хеширования паролей. Значение по умолчанию - 10.
     */
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /* method encode метод encode - Закодируйте необработанный пароль. Как правило, хороший алгоритм кодирования применяет хэш SHA-1 или
      больше в сочетании с 8-байтовым или большим значением случайно сгенерированной соли.*/
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    /* метод mathes - Убедитесь, что закодированный пароль, полученный из хранилища,
     совпадает с отправленным необработанным паролем после того, как он тоже закодирован.
      Возвращает true, если пароли совпадают, и false, если нет. Сам сохраненный пароль никогда не декодируется. */
    public boolean getMatch(String password, User user){
        return bCryptPasswordEncoder.matches(password, user.getPassword());
    }


    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}