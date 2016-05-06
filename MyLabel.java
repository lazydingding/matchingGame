/* This class is responsible for recording the postion infomation of JLabel */

import javax.swing.*;
import java.awt.*;

class MyLabel extends JLabel{
   private int x;
   private int y;

   // Initialization, record the position of the specific JLabel.
   MyLabel(ImageIcon i, int x, int y) {
      setIcon(i);
      this.x = x;
      this.y = y;
   }

   int getx() {
      return x;
   }

   int gety() {
      return y;
   }

}
