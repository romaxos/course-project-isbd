package main.web.service;

import main.web.entity.User;
import main.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/*  юзердетэйлссервис - Основной интерфейс, загружающий пользовательские данные.*/
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /*@Transactional - настройка управления транзакциями
    * http://akorsa.ru/2016/08/kak-na-samom-dele-rabotaet-transactional-spring/
    * транзакция это набор операций, которые могут быть либо целиком и успешно выполнены,
    *  либо полностью не выполнены. В IBM DB2 транзакции называют более логично Unit of Work (UoW) — единица работы.
    * https://easyjava.ru/data/jdbc/jdbc-tranzakcii/ */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        /* берем юзера из репозитория  */
        User user = userRepository.findByUsername(username);
        /* относится к spring sequrity - какая то херня которая выбрасывает это не ебу что */
        if (user == null) throw new UsernameNotFoundException(username);
        /* GrantedAuthority - Представляет полномочия, предоставленные Authenticationобъекту.- Представляет токен для запроса аутентификации или для аутентифицированного
        участника после того, как запрос был обработан AuthenticationManager.authenticate(Authentication)методом.
После аутентификации запроса аутентификация обычно сохраняется в локальном для потока SecurityContext,
 управляемом SecurityContextHolderиспользуемым механизмом аутентификации. Явная аутентификация может быть
  достигнута без использования одного из механизмов аутентификации Spring Security, путем создания экземпляра
  аутентификации и использования кода:
    2 версия - Подумайте о GrantedAuthority как о "permission" или "right". Эти "permissions" (обычно) выражаются
     в виде строк (с помощью метода getAuthority() ). Эти строки позволяют вам идентифицировать разрешения и
      позволяют вашим избирателям решать, предоставляют ли они доступ к чему-либо.
Вы можете предоставить пользователям различные GrantedAuthoritys (разрешения), поместив их в контекст безопасности.
Обычно вы делаете это, реализуя свой собственный UserDetailsService, который возвращает реализацию UserDetails, которая
возвращает необходимый GrantedAuthorities.*/
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        /* Базовая конкретная реализация a GrantedAuthority.
Хранит Stringпредставление полномочий, предоставленных Authenticationобъекту.
 --- Представляет полномочия, предоставленные Authenticationобъекту.*/
        grantedAuthorities.add(new SimpleGrantedAuthority("user"));
        /* Моделирует базовую информацию о пользователе, полученную с помощью файла UserDetailsService.
Разработчики могут использовать этот класс напрямую, создать подкласс или написать свою собственную UserDetailsреализацию с нуля.
 */
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}