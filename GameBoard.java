import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameBoard extends JPanel {
   public GameBoard() {
      addMouseListener(new MouseListener());
   }
   private class MouseListener extends MouseAdapter {
      public void mouseClicked(MouseEvent e) {
         int mouseX = e.getX();
         int mouseY = e.getY();
         
         System.out.println("X: " + mouseX + "\tY: " + mouseY);
      }
   }
}