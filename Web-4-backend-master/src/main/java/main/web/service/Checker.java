package main.web.service;

import main.web.entity.Point;

/* базовый класс чека попадания в цель */
public class Checker {


    /* статический метод для проверки попадания в цель */
    public static void hit(Point point) {
        double x = point.getX();
        double y = point.getY();
        double r = point.getR();

        if (x > 0 && y > 0) point.setInArea(false);      // пустота
        else if (x < 0 && y > 0) {     // полукруг
            if (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r / 2, 2)) point.setInArea(true);
            else point.setInArea(false);
        }else if (x < 0 && y < 0) {     // прямоугольник
            if (Math.abs(x) < r && Math.abs(y) < (r / 2)) point.setInArea(true);
            else point.setInArea(false);
        }else if (x > 0 && y < 0) {       // треугольник
            if (x <= r && Math.abs(y) <= (r / 2) && y >= (x / 2) - (r / 2)) point.setInArea(true);
            else point.setInArea(false);
        }else {             // на осях координат
            if (x == 0) {
                if (y <= (r / 2) && Math.abs(y) <= (r / 2)) point.setInArea(true);
                else point.setInArea(false);
            }else {
                if (Math.abs(x) <= r) point.setInArea(true);
                else point.setInArea(false);
            }
        }
    }


}
