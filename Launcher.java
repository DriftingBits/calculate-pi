import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Launcher {
    public static void main(String[] args) {
        //number of threads, time to execute
        //String[] parameters = args;
        String[] parameters = {"6", "120"};
        launch(parameters);
    }

    public static void launch(String[] args) {
        int numThreads = Integer.parseInt(args[0]);
        int runTime = Integer.parseInt(args[1]);

        ExecutorService threadpool = Executors.newFixedThreadPool(numThreads);
        Future<Results>[] results = new Future[numThreads];
        for(int i = 0; i < numThreads; i++) {
            results[i] = threadpool.submit(new Calculator(runTime));
        }
        calculatePi(results);
    }

    public static void calculatePi(Future<Results>[] results) {
        double totalPoints = 0;
        double pointsInCircle = 0;
        double pi;

        try {
            for (int i = 0; i < results.length; i++) {
                totalPoints += results[i].get().getTotalPoints();
                pointsInCircle += results[i].get().getPointsInCircle();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        pi = 4 * (pointsInCircle / totalPoints);

        System.out.println("The program has done " + totalPoints + " calculations.");
        System.out.println(pointsInCircle + " of those where in the circle");
        System.out.println("Pi is estimated to be " + pi);
    }
}
