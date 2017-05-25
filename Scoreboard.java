import javax.swing.*;
import java.awt.*;

public class Scoreboard extends JPanel
{
   private JLabel healthBar, scoreTitle;
   private int score, health;
   public Scoreboard()
   {
      setLayout(new GridLayout(1, 2));
      score = 0;
      health = 200;
      scoreTitle = new JLabel("Score: " + score);
      healthBar = new JLabel("HP: " + health + "/200");
   }
   public void updatehealthBar(int healths)
   {
      health = healths;
      if(health > 200)
      {
         health = 200;
      }
      else if(health < 50)
      {
         healthBar.setForeground(Color.RED);
      }
      healthBar.setText("HP: " + health + "/200");
   }
   public void updateScore(int reward)
   {
      score = score + reward;
      scoreTitle.setText("Score: " + score);
   }
}