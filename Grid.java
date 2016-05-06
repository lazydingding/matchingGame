/* This class is responsible for building the logic grid behind the GUI */

import java.util.*;

class Grid {
   public final int row = 4;
   public final int col = 6;
   private int[][] cells0 = new int[col][row];
   private int[][] cells = new int[col][row];
   private int x1, y1, x2, y2, flips, matchs;

   // Initialization
   Grid() {
      initGrid();
   }

   // Randomly generate a 2d integer array.
   void initGrid() {
      x1 = 0;
      y1 = 0;
      x2 = 0;
      y2 = 0;
      flips = 0;
      matchs = 0;
      // Generate a random list range form 1 to 12, each number appears twice.
      List<Integer> list = new ArrayList<Integer>();
      for (int i = 1; i <= row * col; i++) {
         if (i <= row * col / 2) list.add(i);
         else list.add(i - row * col / 2);
      }
      Collections.shuffle(list);

      // Transfer this random list to integer array
      for (int x = 0, y = 0, i = 0; y < row; i++) {
         cells[x][y] = 0;
         cells0[x][y] = list.get(i);
         if (x == col - 1) {
            x = 0;
            y++;
         }
         else x++;
      }
   }

   // Check icons, if two icons are same, hold them
   void turn(int x, int y) {
      if (cells[x][y] != cells0[x][y]) {
         flips++;
         if (flips % 2 == 1) {
            if (cells[x1][y1] != cells[x2][y2]) {
               cells[x1][y1] = 0;
               cells[x2][y2] = 0;
            }
            x1 = x;
            y1 = y;
            cells[x][y] = cells0[x][y];
         }
         else {
            x2 = x;
            y2 = y;
            cells[x][y] = cells0[x][y];
            if (x1 == x2 && y1 == y2) flips--;
            else if (cells[x1][y1] == cells[x2][y2]) matchs++;
         }
      }
   }

   int getflips() {
      return flips;
   }

   int getmatchs() {
      return matchs;
   }

   boolean state() {
      if (matchs == row * col / 2) return true;
      else return false;
   }

   int get(int x, int y) {
      return cells[x][y];
   }
}
