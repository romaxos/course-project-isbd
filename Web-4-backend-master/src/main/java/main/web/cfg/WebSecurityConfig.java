package main.web.cfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/* @configuration и @Bean - Основными признаками и частями Java-конфигурации IoC контейнера являются классы
 с аннотацией @Configuration и методы с аннотацией @Bean. Аннотация @Bean используется для указания того,
  что метод создает, настраивает и инициализирует новый объект, управляемый Spring IoC контейнером. Такие
  методы можно использовать как в классах с аннотацией @Configuration, так и в классах с аннотацией
  @Component(или её наследниках). Класс с аннотацией @Configuration говорит о том, что он является источником
   определения бинов.
    @EnableWebSecutity - @EnableWebSecurity -это маркерная аннотация. Это позволяет Spring найти
    (это @Configuration и, следовательно, @Component ) и автоматически применить класс к глобальному WebSecurity .
    еще инфа - Если вы определяете @Configuration с @EnableWebSecurity любом месте приложения, он отключит настройки
     безопасности webapp по умолчанию в Spring Boot (но оставьте защиту Actuators включенной)*/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    /* @Qualifier - Используя аннотацию @Qualifier , мы можем устранить вопрос о том, какой bean-компонент необходимо внедрить
    . */
    @Autowired
    @Qualifier("userDetailServiceImpl")
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(8);
    }

    /* меннеджер аунтефикации
    * Обрабатывает Authentication запрос. --- Представляет токен для запроса аутентификации или для
    *  аутентифицированного участника после того, как запрос был обработан
    *  AuthenticationManager.authenticate(Authentication)методом. */
    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    /* HttpSecutity - A HttpSecurityпохож на элемент XML <http> Spring Security в конфигурации
    пространства имен. Он позволяет настраивать веб-безопасность для определенных HTTP-запросов.
     По умолчанию он будет применяться ко всем запросам, но может быть ограничен с помощью
      requestMatcher(RequestMatcher)или других аналогичных методов.
       пример - https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/builders/HttpSecurity.html*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .authorizeRequests()
                .antMatchers("/","/delete","/register", "/index*", "/static/**", "/*.js", "/*.json", "/*.ico", "/login", "/logout").permitAll()
                .anyRequest().fullyAuthenticated()
                .and()
                .csrf().disable()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                .permitAll()
                .and()
//                .formLogin().and()
                .httpBasic();
    }

    /* SecurityBuilderиспользуется для создания файла AuthenticationManager. Позволяет легко встраивать
    аутентификацию в памяти, аутентификацию LDAP, аутентификацию на основе JDBC, добавлять UserDetailsServiceи
     добавлять AuthenticationProvider.
     asswordEncoder - Сервисный интерфейс для кодирования паролей. Предпочтительная реализация BCryptPasswordEncoder. */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    /* WebSecurityСоздан , WebSecurityConfigurationчтобы создать FilterChainProxyизвестный как фильтр цепи Spring Security (springSecurityFilterChain). SpringSecurityFilterChain - это объект, Filterкоторому DelegatingFilterProxyделегаты.

Настройки WebSecurityмогут быть выполнены путем создания WebSecurityConfigurerили,
что более вероятно, путем переопределения WebSecurityConfigurerAdapter. */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    /* CorsRegistry Помогает с регистрацией глобальных сопоставлений на основе шаблонов URL CorsConfiguration.
    * WebMvcConfigerer */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

}