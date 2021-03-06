package main.web.entity;

import lombok.Data;


/* класс обьект которого используется для отправки ответа на клиент */
@Data
public class AnswerPoint {

    private double x;
    private double y;
    private double r;
    private boolean isInArea;

    public AnswerPoint(double x, double y, double r, boolean isInArea) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.isInArea = isInArea;
    }
}
