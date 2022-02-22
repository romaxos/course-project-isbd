package main.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



/*
* Многим разработчикам Spring Boot нравится, когда их приложения
*  используют автоконфигурацию, сканирование компонентов и могут
*  определять дополнительную конфигурацию в своем "application class".
*  Одну аннотацию @SpringBootApplication можно использовать для включения
* этих трех функций, а именно:

@EnableAutoConfiguration: включить механизм автоконфигурации Spring Boot
@ComponentScan: включить сканирование @Component для пакета, в котором находится приложение
@Configuration: позволяет регистрировать дополнительные компоненты (beans) в
*  контексте или импортировать дополнительные классы конфигурации
* КАРОЧЕ - ДЛЯ АВТОКОНФИГУРАЦИИ*/
@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer {

    /* инфа касательно SpringApplication.run
    * Класс, который можно использовать для начальной загрузки и запуска приложения Spring из основного метода Java.
    * для чего он нужен:
    * Создайте соответствующий ApplicationContextэкземпляр (в зависимости от вашего пути к классам)
* Зарегистрируйте a, CommandLinePropertySourceчтобы предоставить аргументы командной строки как свойства Spring
Обновите контекст приложения, загрузив все одноэлементные bean-компоненты
Запуск любых CommandLineRunnerбобов*/
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
