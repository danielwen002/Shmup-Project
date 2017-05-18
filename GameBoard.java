import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class GameBoard extends JPanel {

   private static final Color BACKGROUND = new Color(204, 204, 204);

   private Point mouse;
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
      
      myBuffer.setColor(BACKGROUND);  
      myBuffer.fillRect(0, 0, 350, 500);
         
      player = new Player();
      player.draw(myBuffer);
      
      Timer runGame = new Timer(5, new GameListener());
      runGame.start();
   }
  
   private class GameListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         myBuffer.setColor(BACKGROUND);  
         myBuffer.fillRect(0, 0, 350, 500);
         
         mouse = getMousePosition();
         
         if(mouse != null) {
            player.setX(mouse.x);
            player.setY(mouse.y);
            
            if(player.getX() < 25) {
               player.setX(25);
            }
            if(player.getX() > 325) {
               player.setX(325);
            }
            
            System.out.println("Mouse X: " + mouse.x + "\tMouse Y: " + mouse.y);
            System.out.println("Player X: " + player.getX() + "\tPlayer Y: " + player.getY());
         }
         player.draw(myBuffer);   
         repaint();
      }
   }
   public void paintComponent(Graphics g)
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }
}