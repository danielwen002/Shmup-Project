import javax.swing.*;
import java.awt.*;

public class Player {
   private int myX;
   private int myY;
   private int myCurrentHealth;
   private ImageIcon sprite;
   
   public Player() {
      sprite = new ImageIcon("Sprites/Player.png");
      myCurrentHealth = 150;
      myX = 175;
      myY = 400;
   }
   public int getX() {
      return myX;
   }
   public int getY() {
      return myY;
   }
   public int getCurrentHealth() {
      return myCurrentHealth;
   }
   public Image getSprite() {
      return sprite.getImage();
   }
   public void setX(int x) {
      myX = x;
   }
   public void setY(int y) {
      myY = y;
   }
   public void setCurrentHealth(int hp) {
      myCurrentHealth = hp;
   }
   public void draw(Graphics myBuffer) {
      myBuffer.drawImage(getSprite(), getX() - 25, getY() - 25, 50, 50, null);
   }
   public void attack() {
   
   }
}