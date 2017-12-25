public class Results {
    private double totalPoints;
    private double pointsInCircle;

    public Results() {
        totalPoints = 0;
        pointsInCircle = 0;
    }

    public void incrementTotalPoints() {
        totalPoints++;
    }

    public void incrementPointsInCircle() {
        pointsInCircle++;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

    public double getPointsInCircle() {
        return pointsInCircle;
    }
}
