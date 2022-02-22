package main.web.service;

import main.web.WebApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class Initializer extends SpringBootServletInitializer {

    /*  Чтобы быть более практичным, мы покажем пример основного класса, который расширяет класс Initializer .
Наш  класс @SpringBootApplication под названием WarInitializerApplication расширяет SpringBootServletInitializer и
переопределяет метод configure () . Этот метод использует SpringApplicationBuilder, чтобы просто зарегистрировать
 наш класс как класс конфигурации приложения:

 Старые контейнеры сервлетов не поддерживают процесс начальной загрузки ServletContextInitializer, используемый в
 сервлете 3.0. Вы все еще можете использовать Spring и Spring Boot в этих контейнерах, но вам нужно будет добавить
  web.xml в ваше приложение и настроить его для загрузки ApplicationContext через DispatcherServlet .
Для создания развертываемого файла war необходимо предоставить подкласс SpringBootServletInitializer и
 переопределить его метод configure . Это позволяет использовать поддержку Spring Framework Servlet 3.0 и
  позволяет настраивать приложение при его запуске контейнером сервлетов. Как правило, вы обновляете основной класс
   приложения, чтобы расширить SpringBootServletInitializer .*/

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }
}