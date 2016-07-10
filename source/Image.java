/* This class is responsible for reading image files, and sent ImageIcon back
to display class in order */

import javax.swing.*;
import java.awt.*;
import java.net.*;

class Image {
   private ImageIcon bg1;
   private ImageIcon bg2;
   private ImageIcon bg3;
   private ImageIcon bg4;
   private ImageIcon audion;
   private ImageIcon audioff;
   private ImageIcon questionmark;
   private ImageIcon club1;
   private ImageIcon club2;
   private ImageIcon club3;
   private ImageIcon club4;
   private ImageIcon club5;
   private ImageIcon club6;
   private ImageIcon club7;
   private ImageIcon club8;
   private ImageIcon club9;
   private ImageIcon club10;
   private ImageIcon club11;
   private ImageIcon club12;
   private ImageIcon web1;
   private ImageIcon web2;
   private ImageIcon web3;
   private ImageIcon web4;
   private ImageIcon web5;
   private ImageIcon web6;
   private ImageIcon web7;
   private ImageIcon web8;
   private ImageIcon web9;
   private ImageIcon web10;
   private ImageIcon web11;
   private ImageIcon web12;
   private ImageIcon bottle1;
   private ImageIcon bottle2;
   private ImageIcon bottle3;
   private ImageIcon bottle4;
   private ImageIcon bottle5;
   private ImageIcon bottle6;
   private ImageIcon bottle7;
   private ImageIcon bottle8;
   private ImageIcon bottle9;
   private ImageIcon bottle10;
   private ImageIcon bottle11;
   private ImageIcon bottle12;

   // Initialization, read image files.
   Image() {
      bg1 = new ImageIcon(getClass().getResource("image/background/Circles.png"));
      bg2 = new ImageIcon(getClass().getResource("image/background/Hawaiian Print.png"));
      bg3 = new ImageIcon(getClass().getResource("image/background/Galaxy.png"));
      bg4 = new ImageIcon(getClass().getResource("image/background/Shapes.png"));
      audion = new ImageIcon(getClass().getResource("image/icon/Audio On.png"));
      audioff = new ImageIcon(getClass().getResource("image/icon/Audio Off.png"));
      questionmark = new ImageIcon(getClass().getResource("/image/icon/Question Mark.png"));
      club1 = new ImageIcon(getClass().getResource("/image/club/Arsenal.png"));
      club2 = new ImageIcon(getClass().getResource("/image/club/Chelsea.png"));
      club3 = new ImageIcon(getClass().getResource("/image/club/Everton.png"));
      club4 = new ImageIcon(getClass().getResource("/image/club/Leicester City.png"));
      club5 = new ImageIcon(getClass().getResource("/image/club/Liverpool FC.png"));
      club6 = new ImageIcon(getClass().getResource("/image/club/Manchester City.png"));
      club7 = new ImageIcon(getClass().getResource("/image/club/Manchester United.png"));
      club8 = new ImageIcon(getClass().getResource("/image/club/Tottenham Hotspur.png"));
      club9 = new ImageIcon(getClass().getResource("/image/club/Aston Villa.png"));
      club10 = new ImageIcon(getClass().getResource("/image/club/Leeds United.png"));
      club11 = new ImageIcon(getClass().getResource("/image/club/Queens Park Rangers.png"));
      club12 = new ImageIcon(getClass().getResource("/image/club/Watford FC.png"));
      web1 = new ImageIcon(getClass().getResource("/image/web/1.png"));
      web2 = new ImageIcon(getClass().getResource("/image/web/2.png"));
      web3 = new ImageIcon(getClass().getResource("/image/web/3.png"));
      web4 = new ImageIcon(getClass().getResource("/image/web/4.png"));
      web5 = new ImageIcon(getClass().getResource("/image/web/5.png"));
      web6 = new ImageIcon(getClass().getResource("/image/web/6.png"));
      web7 = new ImageIcon(getClass().getResource("/image/web/7.png"));
      web8 = new ImageIcon(getClass().getResource("/image/web/8.png"));
      web9 = new ImageIcon(getClass().getResource("/image/web/9.png"));
      web10 = new ImageIcon(getClass().getResource("/image/web/10.png"));
      web11 = new ImageIcon(getClass().getResource("/image/web/11.png"));
      web12 = new ImageIcon(getClass().getResource("/image/web/12.png"));
      bottle1 = new ImageIcon(getClass().getResource("/image/bottle/1.png"));
      bottle2 = new ImageIcon(getClass().getResource("/image/bottle/2.png"));
      bottle3 = new ImageIcon(getClass().getResource("/image/bottle/3.png"));
      bottle4 = new ImageIcon(getClass().getResource("/image/bottle/4.png"));
      bottle5 = new ImageIcon(getClass().getResource("/image/bottle/5.png"));
      bottle6 = new ImageIcon(getClass().getResource("/image/bottle/6.png"));
      bottle7 = new ImageIcon(getClass().getResource("/image/bottle/7.png"));
      bottle8 = new ImageIcon(getClass().getResource("/image/bottle/8.png"));
      bottle9 = new ImageIcon(getClass().getResource("/image/bottle/9.png"));
      bottle10 = new ImageIcon(getClass().getResource("/image/bottle/10.png"));
      bottle11 = new ImageIcon(getClass().getResource("/image/bottle/11.png"));
      bottle12 = new ImageIcon(getClass().getResource("/image/bottle/12.png"));
   }

   ImageIcon getButton(String s) {
      if (s.equals("On ")) return audion;
      else return audioff;
   }

   ImageIcon getBG(String s) {
      if (s.equals("Ci")) return bg1;
      else if (s.equals("Ha")) return bg2;
      else if (s.equals("Ga")) return bg3;
      else return bg4;
   }

   ImageIcon getIcon(int i, int level) {
      if (level == 1) return getWeb(i);
      else if (level == 2) return getClub(i);
      else return getBottle(i);
   }

   ImageIcon getClub(int i) {
      switch(i) {
         case 1: return club1;
         case 2: return club2;
         case 3: return club3;
         case 4: return club4;
         case 5: return club5;
         case 6: return club6;
         case 7: return club7;
         case 8: return club8;
         case 9: return club9;
         case 10: return club10;
         case 11: return club11;
         case 12: return club12;
         default: return questionmark;
      }
   }

   ImageIcon getWeb(int i) {
      switch(i) {
         case 1: return web1;
         case 2: return web2;
         case 3: return web3;
         case 4: return web4;
         case 5: return web5;
         case 6: return web6;
         case 7: return web7;
         case 8: return web8;
         case 9: return web9;
         case 10: return web10;
         case 11: return web11;
         case 12: return web12;
         default: return questionmark;
      }
   }

   ImageIcon getBottle(int i) {
      switch(i) {
         case 1: return bottle1;
         case 2: return bottle2;
         case 3: return bottle3;
         case 4: return bottle4;
         case 5: return bottle5;
         case 6: return bottle6;
         case 7: return bottle7;
         case 8: return bottle8;
         case 9: return bottle9;
         case 10: return bottle10;
         case 11: return bottle11;
         case 12: return bottle12;
         default: return questionmark;
      }
   }
}
