/* This class is responsible for reading audio file, then receive commands to
control play or stop it */

import java.net.*;
import java.applet.*;

class Audio{
   private AudioClip audio;
   private boolean flag;

   // Initialization.
   Audio() {
      audio = Applet.newAudioClip(getClass().getResource("audio/AngryBirds.mid"));
   }

   void play() {
      audio.loop();
      flag = true;
   }

   void stop() {
      audio.stop();
      flag = false;
   }

   boolean state() {
      return flag;
   }
}
