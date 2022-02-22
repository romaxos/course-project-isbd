package main.web.controllers;

import main.web.entity.Point;
import main.web.entity.AnswerPoint;
import main.web.repository.PointRepository;
import main.web.repository.UserRepository;
import main.web.service.Checker;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

@RestController
public class PointController {

    /* объявляем объекты интерфейсов репозиториев */
    private final PointRepository pointRepository;
    private final UserRepository userRepository;


    /* обыяный конструктор с параметрами */
    PointController(PointRepository pointRepository, UserRepository userRepository) {
        this.pointRepository = pointRepository;
        this.userRepository = userRepository;
    }


    /* @CrossOrigin - Cross-Origin Resource Sharing (CORS) — это концепция безопасности,
     которая позволяет ограничивать ресурсы, реализованные в веб-браузерах. Это предотвращает
      создание или использование кода JavaScript запросов различного происхождения.
      @PostMapping - @PostMapping -это составная аннотация, которая действует как ярлык для
      @RequestMapping(method = RequestMethod.POST) .@PostMapping аннотированные методы
      обрабатывают запросы HTTP POST, соответствующие заданным URI expression. , например
      Principal - это пользователь, вошедший в систему в данный момент. Однако вы извлекаете
       его через контекст безопасности, который привязан к текущему потоку, и как таковой он
       также привязан к текущему запросу и его сеансу.*/
    @CrossOrigin
    @PostMapping("/result")
    Collection<AnswerPoint> allPoints(Principal user) {             // метод для получение инфы о точках пользователя (таблица)
        System.out.println("Get point of user: "+user.getName());
        Collection<AnswerPoint> collection = new ArrayList<>();
        for (Point point:pointRepository.findByUser(userRepository.findByUsername(user.getName()))) {
            collection.add(point.convertToSimplePoint());
        }
        return collection;
    }

    @CrossOrigin
    @PostMapping("/table")
    AnswerPoint newPoint(@RequestBody Point newPoint, Principal user) {
        Checker.hit(newPoint);
//        newPoint.setHit(Checker.inArea(newPoint.getX(),newPoint.getY(),newPoint.getR()));
//        System.out.println(newPoint.getHit());
        newPoint.setUser(userRepository.findByUsername(user.getName()));
        System.out.println("Created new point: " +newPoint);
        return pointRepository.save(newPoint).convertToSimplePoint();
    }
}