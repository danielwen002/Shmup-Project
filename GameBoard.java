import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;

public class GameBoard extends JPanel {

   private static final Color BACKGROUND = new Color(204, 204, 204);

   private Point mouse;
   private Graphics myBuffer;
   private BufferedImage myImage;
   private Player player;
   private ArrayList<Bullet> bulletsOnScreen;
   
   public GameBoard() {
      myImage =  new BufferedImage(350, 500, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
      Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
      setCursor(blankCursor);
      
      bulletsOnScreen = new ArrayList<Bullet>();
      
      myBuffer.setColor(BACKGROUND);  
      myBuffer.fillRect(0, 0, 350, 500);
         
      player = new Player();
      player.draw(myBuffer);
      
      
      Timer shoot = new Timer(100, new ShootListener());
      shoot.start();
      
      Timer runGame = new Timer(15, new GameListener());
      runGame.start();   
   }
  
   private class GameListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         myBuffer.setColor(BACKGROUND);  
         myBuffer.fillRect(0, 0, 350, 500);
         
         mouse = getMousePosition();
         
         if(mouse != null) {
            player.setX(mouse.x - 25);
            player.setY(mouse.y);
            
            if(player.getX() < 0) {
               player.setX(0);
            }
            if(player.getX() > 325) {
               player.setX(325);
            }
         }
         player.draw(myBuffer);  
         
         
         for(int i = 0; i < bulletsOnScreen.size(); i++) {
            bulletsOnScreen.get(i).move(0);
            bulletsOnScreen.get(i).draw(myBuffer);
            if(isOffScreen(bulletsOnScreen.get(i))) {
               bulletsOnScreen.remove(i);
            }
         }
         
          
         repaint();
      }
   }
   public boolean isOffScreen(Bullet bullet) {
      return bullet.getY() < -30 || bullet.getY() > 530 || bullet.getX() < -30 || bullet.getX() > 380;
   }
   private class ShootListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         playerAttack();
      }
   } 
   public void paintComponent(Graphics g)
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }
   public void playerAttack() {
      bulletsOnScreen.add(new Bullet(player.getX() + 13, player.getY() + 10, 10, 18, 0, new ImageIcon("Sprites/enemy_bolt1.png")));
      bulletsOnScreen.add(new Bullet(player.getX() + 26, player.getY() + 10, 10, 18, 0, new ImageIcon("Sprites/enemy_bolt1.png")));
   }
}