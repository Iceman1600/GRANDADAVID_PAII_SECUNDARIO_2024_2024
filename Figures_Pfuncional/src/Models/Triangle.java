package Models;

import Interfaces.IDrawable;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class Triangle implements IDrawable {
    List<int[]> puntos = Arrays.<int[]>asList(

            new int[]{160,17,300, 17, 200, 200}
    );

    // Interfaz funcional para operaciones de dibujo
    @Override
    public void Draw(Graphics g, BiConsumer<Graphics, List<int[]>> operacionDeDibujo) {
        operacionDeDibujo.accept(g, puntos);
    }
}
