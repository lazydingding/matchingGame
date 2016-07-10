/* Matching Game, matching all the pairs of icons to win the game. */
/* Copyright @ Luping Yu */

import javax.swing.*;
import java.awt.*;

class Mgame {
   public static void main(String[] args) {
      Mgame program = new Mgame();
      SwingUtilities.invokeLater(program::run);
   }

   // Create the main window for the program.
   private void run() {
      Display d = new Display();
      JFrame w = new JFrame();
      w.setDefaultCloseOperation(w.EXIT_ON_CLOSE);
      w.setTitle("Matching Game");
      w.setMinimumSize(new Dimension(800,550));
      w.add(d);
      w.pack();
      w.setLocationByPlatform(true);
      w.setVisible(true);
   }
}
