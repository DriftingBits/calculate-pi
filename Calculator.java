import java.util.Random;
import java.util.concurrent.Callable;

public class Calculator implements Callable<Results> {
    private int runTime;
    private long endTime;
    private Results results;

    public Calculator(int runTime) {
        this.runTime = runTime * 1000;
        endTime = System.currentTimeMillis() + this.runTime;
        results = new Results();
    }

    @Override
    public Results call() {
        Random rng = new Random();
        double x;
        double y;

        while(System.currentTimeMillis() < this.endTime) {
            x = rng.nextDouble();
            y = rng.nextDouble();

            results.incrementTotalPoints();
            if(Math.sqrt(x*x + y*y) < 1) {
                results.incrementPointsInCircle();
            }
        }

        return results;
    }
}
