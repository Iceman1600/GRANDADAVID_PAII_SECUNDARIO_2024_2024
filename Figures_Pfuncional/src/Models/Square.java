package Models;

import Interfaces.IDrawable;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class Square implements IDrawable {
    List<int[]> puntos = Arrays.<int[]>asList(
            new int[]{100, 17, 200, 200}
    );

    // Interfaz funcional para operaciones de dibujo
    @Override
    public void Draw(Graphics g, BiConsumer<Graphics, List<int[]>> operacionDeDibujo) {
        operacionDeDibujo.accept(g, puntos);
    }
}
