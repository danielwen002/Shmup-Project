import javax.swing.JFrame;
public class TestDriver {
   public static void main(String[] args) {
      JFrame frame = new JFrame("test");
      frame.setSize(400, 400);
      frame.setLocation(100, 50);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new GameBoard());
      frame.setVisible(true);
   }
}