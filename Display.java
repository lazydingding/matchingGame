/* This class is responsible for displaying the GUI of this game. To set up the
GUI properly, a couple of support classes such as Grid, Audio, Clock, Image have
been attached to this class. */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.miginfocom.swing.MigLayout;

class Display extends JPanel {
   private Timer timer;
   private Grid grid;
   private Audio audio;
   private Clock clock;
   private Image image;
   private int level;
   private String background;
   private JLabel t;

   // Initialization.
   Display() {
      grid = new Grid();
      audio = new Audio();
      clock = new Clock();
      image = new Image();
      timer = new Timer(10, this::tick);
      background = "Ha";
      startMenu();
   }

   /* This methods is responsible for background image setup. We have two kinds
   of background, image background and gradient paint background */
   protected void paintComponent(Graphics g1) {
      Graphics2D g = (Graphics2D) g1;
      if (background.equals("Gradient")) {
         GradientPaint paint = new GradientPaint(0, 0, new Color(200,100,255), 0, getHeight(), new Color(50,200,255));
         g.setPaint(paint);
         g.fillRect(0, 0, getWidth(), getHeight());
      }
      else g.drawImage((image.getBG(background)).getImage(), 0, 0, getWidth(), getHeight(), this);
   }

   // Set up start menu.
   private void startMenu() {
      this.removeAll();
      this.setLayout(new MigLayout("fill, insets 10 10 2 10", "center"));
      addGameTitle();
      addLevelSelectButtons();
      this.updateUI();
   }

   // Add title to the start menu layout.
   private void addGameTitle() {
      JLabel title = new JLabel("Matching Game: Memory Challenge");
      title.setFont(new Font("Arial", 1, 40));
      this.add(title, "wrap");
   }

   // Add level select buttons to the start menu layout.
   private void addLevelSelectButtons() {
      JButton b1 = new JButton("Level 1: Easy");
      JButton b2 = new JButton("Level 2: Middle");
      JButton b3 = new JButton("Level 3: Hard");
      JButton b4 = new JButton("About Game");
      b1.addActionListener(this::listenLevelSelectButtons);
      b2.addActionListener(this::listenLevelSelectButtons);
      b3.addActionListener(this::listenLevelSelectButtons);
      b4.addActionListener(this::listenLevelSelectButtons);
      this.add(b1, "split 4, flowy, top, w 100:200:300");
      this.add(b2, "w 100:200:300");
      this.add(b3, "w 100:200:300");
      this.add(b4, "w 100:200:300");
      this.updateUI();
   }

   // Action listen of level select buttons.
   private void listenLevelSelectButtons(ActionEvent e) {
      String s = ((JButton)e.getSource()).getText();
      if(s.equals("About Game")) {
         s = "It's time to challenge your memory! " +
         "Matching all the pairs of icons to win the game!\n" +
         "Level 1: Matching Websites' logo.\n" +
         "Level 2: Matching The Premier League clubs' logo.\n" +
         "Level 3: Matching Bottle icons.\n" +
         "Good luck, Enjoy! @Copyright: Luping Yu";
         JOptionPane.showMessageDialog(this, s, "Matching Game", JOptionPane.PLAIN_MESSAGE);
      }
      else {
         try {
             if (s.equals("Level 1: Easy")) level = 1;
             if (s.equals("Level 2: Middle")) level = 2;
             if (s.equals("Level 3: Hard")) level = 3;
         } catch (Exception e0) { throw new Error(e0); }
         reload();
      }
   }

   // Reload the Game
   private void reload() {
      grid.initGrid();
      clock.reset();
      refresh();
   }

   // Refresh the currect GUI
   private void refresh() {
      this.removeAll();
      this.setLayout(new MigLayout("fill, insets 10 10 2 10", "[]20[]20[]", "center"));
      addTitle();
      addMenu();
      addIcons();
      addReminder();
      addTime();
      this.updateUI();
   }

   // Add title to the game layout.
   private void addTitle() {
      JLabel title = new JLabel("Matching Game - Level " + level);
      title.setFont(new Font("Black", 1, 30));
      this.add(title, "spanx 6, h 50::, center");
   }

   // Add menu to the game layout.
   private void addMenu() {
      addAudioButton();
      addBackgroundSelectButtons();
      addTimeControlButton();
      addReloadButton();
      addBackButton();
      addRecordLabels();
   }

   // Add audio button to the game layout.
   private void addAudioButton() {
      String s;
      if (audio.state()) s = "On ";
      else s = "Off";
      JButton b = new JButton(s, image.getButton(s));
      b.setFont(new Font("Arial", 1, 15));
      b.addActionListener(this::listenAudioButton);
      this.add(b, "growx, spany 5, split 11, flowy, top");
   }

   // Action listen of audio buttons.
   private void listenAudioButton(ActionEvent e) {
      String s = ((JButton)e.getSource()).getText();
      try {
         if (s.equals("On ")) audio.stop();
         if (s.equals("Off")) audio.play();
      } catch (Exception e0) { throw new Error(e0); }
      refresh();
   }

   // Add background select radio buttons to the game layout.
   private void addBackgroundSelectButtons() {
      boolean bg1;
      boolean bg2;
      boolean bg3;
      boolean bg4;
      boolean bg5;
      if (background.equals("Ha")) bg1 = true;
      else bg1 = false;
      if (background.equals("Ci")) bg2 = true;
      else bg2 = false;
      if (background.equals("Ga")) bg3 = true;
      else bg3 = false;
      if (background.equals("Sh")) bg4 = true;
      else bg4 = false;
      if (background.equals("Gradient")) bg5 = true;
      else bg5 = false;
      JRadioButton rb1 = new JRadioButton("Hawaiian Print", bg1);
      JRadioButton rb2 = new JRadioButton("Circles", bg2);
      JRadioButton rb3 = new JRadioButton("Galaxy", bg3);
      JRadioButton rb4 = new JRadioButton("Shapes", bg4);
      JRadioButton rb5 = new JRadioButton("Gradient Colour", bg5);
      rb1.addActionListener(this::listenBackgroundSelectButtons);
      rb2.addActionListener(this::listenBackgroundSelectButtons);
      rb3.addActionListener(this::listenBackgroundSelectButtons);
      rb4.addActionListener(this::listenBackgroundSelectButtons);
      rb5.addActionListener(this::listenBackgroundSelectButtons);
      this.add(rb1);
      this.add(rb2);
      this.add(rb3);
      this.add(rb4);
      this.add(rb5, "gapbottom 70");
   }

   // Action listen of background select buttons.
   private void listenBackgroundSelectButtons(ActionEvent e) {
      String s = ((JRadioButton)e.getSource()).getText();
      try {
         if (s.equals("Hawaiian Print")) background = "Ha";
         if (s.equals("Circles")) background = "Ci";
         if (s.equals("Galaxy")) background = "Ga";
         if (s.equals("Shapes")) background = "Sh";
         if (s.equals("Gradient Colour")) background = "Gradient";
      } catch (Exception e0) { throw new Error(e0); }
      refresh();
   }

   // Add filps and matchs record labels to the game layout.
   private void addRecordLabels() {
      JLabel l1 = new JLabel("Flips: " + grid.getflips());
      JLabel l2 = new JLabel("Matchs: " + grid.getmatchs());
      l1.setFont(new Font("Arial", 1, 20));
      l2.setFont(new Font("Arial", 1, 20));
      l1.setForeground(Color.white);
      l2.setForeground(Color.white);
      this.add(l1, "center");
      this.add(l2, "center, wrap");
   }

   // Add time control button to the game layout.
   private void addTimeControlButton() {
      String s;
      if (grid.state()) s = "Next Level";
      else if (timer.isRunning()) s = "Pause";
      else if (!clock.state()) s ="Start";
      else s = "Continue";
      JButton b = new JButton(s);
      b.addActionListener(this::listenTimeControlButton);
      this.add(b, "growx");
   }

   // Action listen of time control buttons.
   private void listenTimeControlButton(ActionEvent e) {
      String s = ((JButton)e.getSource()).getText();
      try {
          if (s.equals("Pause")) timer.stop();
          if (s.equals("Start") || s.equals("Continue")) {
             clock.tick();
             timer.start();
          }
          if (s.equals("Next Level")) {
             level++;
             if (level > 3) level = 1;
             reload();
          }
      } catch (Exception e0) { throw new Error(e0); }
      refresh();
   }

   // Add reload button to the game layout.
   private void addReloadButton() {
      JButton reload = new JButton("New Game");
      reload.addActionListener(this::listenReloadButton);
      this.add(reload, "growx, center");
   }

   // Action listen of reload buttons.
   private void listenReloadButton(ActionEvent e) {
      timer.stop();
      int flag = JOptionPane.showConfirmDialog(this, "Reload?", "Matching Game", JOptionPane.YES_NO_OPTION);
      if (flag == JOptionPane.YES_OPTION) reload();
      refresh();
   }

   // Add back button to the game layout.
   private void addBackButton() {
      JButton b = new JButton("Back");
      b.addActionListener(this::listenBackButton);
      this.add(b, "growx, center, gapbottom 70");
   }

   // Action listen of back buttons.
   private void listenBackButton(ActionEvent e) {
      timer.stop();
      int flag = JOptionPane.showConfirmDialog(this, "Go back?", "Matching Game", JOptionPane.YES_NO_OPTION);
      if (flag == JOptionPane.YES_OPTION) startMenu();
      else refresh();
   }

   // Add icons grid to the game layout.
   private void addIcons() {
      for (int x = 0, y = 0; y < grid.row;) {
         int i = grid.get(x, y);
         MyLabel l = new MyLabel(image.getIcon(i, level), x, y);
         l.addMouseListener((MouseClicker)this::click);
         if (x == grid.col - 1) {
            this.add(l, "gaptop 20, wrap");
            x = 0;
            y++;
         }
         else {
            this.add(l, "gaptop 20");
            x++;
         }
      }
   }

   // Action listen of click.
   private void click(MouseEvent e) {
      if (timer.isRunning()) {
         MyLabel l;
         l = (MyLabel)e.getSource();
         grid.turn(l.getx(), l.gety());
         refresh();
         checkState();
      }
   }

   // Check the game state.
   private void checkState() {
      if (grid.state()) {
         timer.stop();
         String s = "Congratulation! You Win!\nTime: " + clock.get() +
         "\nFlips:  " + grid.getflips();
         JOptionPane.showMessageDialog(this, s, "Matching Game", JOptionPane.PLAIN_MESSAGE);
      }
   }

   // Add reminder to remaind player click start button.
   private void addReminder() {
      if(!clock.state()) {
         JLabel l = new JLabel("Click <Start> to start the Game");
         l.setFont(new Font("Arial", 1, 20));
         l.setForeground(Color.white);
         this.add(l, "spanx6, flowx");
      }
      else this.add(new JSeparator(), "spanx6");
   }

   // Add timer to the game layout.
   private void addTime() {
      t = new JLabel(clock.get());
      t.setFont(new Font("Arial", 1, 20));
      t.setForeground(Color.white);
      this.add(t, "center");
   }

   // Refresh time
   private void tick(ActionEvent e) {
      clock.tick();
      if (timer.isRunning() && level!= 0) {
         this.remove(t);
         addTime();
         this.updateUI();
      }
   }
}
