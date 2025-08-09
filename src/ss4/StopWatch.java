package ss4;

public class StopWatch {
    private long startTime;
    private long endTime;
    private boolean running;
    public StopWatch() {
        this.running = false;
    }
    public void start() {
        this.startTime = System.currentTimeMillis();
        this.running = true;
    }
    public void stop() {
        if (running) {
            this.endTime = System.currentTimeMillis();
            this.running = false;
        }
    }
    public long getElapsedTime() {
        if (running) {
            return System.currentTimeMillis() - startTime;
        } else {
            return endTime - startTime;
        }
    }

}
