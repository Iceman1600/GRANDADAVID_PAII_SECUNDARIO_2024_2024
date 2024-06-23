package Controllers;
import java.util.List;
import java.awt.*;
import java.util.function.BiConsumer;

import Models.Circle;
import Models.Square;
import Models.Triangle;

public class Controller {

    Circle c = new Circle();
Square s = new Square();
Triangle t = new Triangle();
    public void DrawCircle(Graphics g ) {
        BiConsumer<Graphics, List<int[]>> drawcircle = (graficos, puntos) -> {
            graficos.setColor(Color.red);
            int x = puntos.get(0)[0];
            int y = puntos.get(0)[1];
            int x1 = puntos.get(0)[2];
            int y1 = puntos.get(0)[3];

            graficos.fillOval(x, y, x1, y1);
            graficos.drawOval(x, y, x1, y1);
        };
        c.Draw(g,drawcircle) ;

    }

    public void DrawSquare(Graphics g ) {
        BiConsumer<Graphics, List<int[]>> drawSquare = (graficos, puntos) -> {
            graficos.setColor(Color.green);

            int x = puntos.get(0)[0];
            int y = puntos.get(0)[1];
            int x1 = puntos.get(0)[2];
            int y1 = puntos.get(0)[3];

            graficos.fillRect(x, y, x1, y1);
            graficos.drawRect(x, y, x1, y1);
        };
        s.Draw(g, drawSquare);

    }

    public void DrawTriangle(Graphics g ) {
        BiConsumer<Graphics, List<int[]>> drawTriangle = (graficos, puntos) -> {
        graficos.setColor(Color.blue);

            int[] xPoints = { puntos.get(0)[0], puntos.get(0)[1], puntos.get(0)[2] };
            int[] yPoints = { puntos.get(0)[3], puntos.get(0)[4], puntos.get(0)[5] };


            graficos.fillPolygon(xPoints, yPoints, xPoints.length);
            graficos.drawPolygon(xPoints, yPoints, xPoints.length);
    };
        t.Draw(g, drawTriangle);

    }
}
