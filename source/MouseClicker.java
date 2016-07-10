/* Converts MouseListener into a one-method interface by adding defaults for
everything except mouseReleased */

import java.awt.event.*;

interface MouseClicker extends MouseListener {
   @Override
   public default void mouseEntered(MouseEvent e) { }

   @Override
   public default void mouseExited(MouseEvent e) { }

   @Override
   public default void mousePressed(MouseEvent e) { }

   @Override
   public default void mouseClicked(MouseEvent e) { }
}
