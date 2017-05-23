import javax.swing.*;
import java.awt.*;

public class Bullet {
   private ImageIcon mySprite;
   private int myDamage;
   private double myX;
   private double myY;
   private double mySpeed;   
   private double myAngle;
   private final double originX;
   private final double originY;

   public Bullet(double x, double y, int damage, double speed, double angle, ImageIcon sprite) {
      myX = x;
      myY = y;
      originX = x;
      originY = y;
      myDamage = damage;
      mySprite = sprite;
      mySpeed = speed;
      myAngle = angle;
   }
   public int getDamage() {
      return myDamage;
   }
   public double getX() {
      return myX;
   }
   public double getY() {
      return myY;
   }
   public double getSpeed() { 
      return mySpeed;
   }
   public double getSpeedY() { 
      return myAngle;
   }
   public Image getSprite() {
      return mySprite.getImage();
   }
   public void setDamage(int dmg) {
      myDamage = dmg;
   }
   public void setSpeed(double spd) {
      mySpeed = spd;
   }
   public void setAngle(double ang) {
      myAngle = ang;
   }
   public void setX(double x) {
      myX = x;
   }
   public void setY(double y) {
      myY = y;
   }
   public void move(int pattern) {
      if(pattern == 0) { //for the player
         setY(getY() - getSpeed());
      }
   }
   public void draw(Graphics myBuffer) {
      myBuffer.drawImage(getSprite(), (int) getX(),(int) getY(), 10, 20, null);
   }
}