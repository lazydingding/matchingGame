/* This class is responsible for recording time. Centisecond will tick if the
Timer thread in display class enable */

class Clock{
   private int minute;
   private int second;
   private int centisecond;

   void tick() {
      centisecond++;
      if(centisecond == 100) {
         centisecond = 0;
         second++;
      }
      if (second == 60) {
         second = 0;
         minute++;
      }
   }

   void reset() {
      centisecond = 0;
      second = 0;
      minute = 0;
   }

   // Get the current time represented by string.
   String get() {
      String s = " " + minute + ":";
      if (second < 10) s = s + "0" + second + ":";
      else s = s + second + ":";
      if (centisecond < 10) s = s + "0" + centisecond;
      else s = s + centisecond;
      return s;
   }

   boolean state() {
      if(minute == 0 && second == 0 && centisecond == 0) return false;
      else return true;
   }
}
