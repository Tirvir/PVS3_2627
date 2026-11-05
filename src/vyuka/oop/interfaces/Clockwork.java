package vyuka.oop.interfaces;

public class Clockwork {
    public static void main(String[] args) {
    StopWatch watch = new StopWatch(0);
    watch.setStart();
    watch.addMiliseconds(5500);
    watch.setStop();
    watch.displayTime();


    }

}
    class DigitalClock implements TimeSupport{
        int year, month, day, hour, minute, second;

        public DigitalClock(int year, int month, int day, int hour, int minute, int second) {
            this.year = year;
            this.month = month;
            this.day = day;
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }

        @Override
        public void displayTime() {

        }
    }
    class StopWatch implements TimeSupport{
        long milliseconds;

        long start;
        long stop;

        void setStart(){
            start=milliseconds;
        }
        void addMiliseconds(long toAdd){
            milliseconds+=toAdd;
        }
        void setStop(){
            stop=milliseconds;
        }
        public StopWatch(long milliseconds){
            this.milliseconds=milliseconds;
        }

        @Override
        public void displayTime() {
            long duration = stop - start;
            double totalSeconds = duration/1000.0;
            int minutes = (int)(totalSeconds/60);
            double seconds = totalSeconds%60.0;
            System.out.println(minutes+":"+seconds);

        }
    }