import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class GameBoard extends JPanel {

   private static final Color BACKGROUND = new Color(204, 204, 204);

   private int mouseX;
   private int mouseY;
   private Graphics myBuffer;
   private BufferedImage myImage;
   private Player player;
   
   public GameBoard() {
      myImage =  new BufferedImage(350, 500, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
      Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
      setCursor(blankCursor);
      
      player = new Player();
      player.draw(myBuffer);
   
      addMouseMotionListener(new MouseListener());
      
      Timer runGame = new Timer(17, new GameListener());
      runGame.start();
   }
  
   private class GameListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         player.setX(mouseX - 25);
         player.setY(mouseY - 25);
         player.draw(myBuffer);   
      }
   }
   private class MouseListener extends MouseMotionAdapter {
      public void mouseMoved(MouseEvent e) {
         mouseX = e.getX();
         mouseY = e.getY();
         
         System.out.println("X: " + mouseX + "\tY: " + mouseY);
      }
   }
}