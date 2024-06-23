package Interfaces;

import java.awt.*;
import java.util.List;
import java.util.function.BiConsumer;

@FunctionalInterface
public interface IDrawable {

 public void Draw(Graphics g, BiConsumer<Graphics, List<int[]>> operacionDeDibujo);
}
