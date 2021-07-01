package domain;

public class Roadplus {

    private String date;
    private int roadNumber;
    private String road;
    private String fromTo;
    private int fromToNumber;
    private String roadName;
    private int roadNameNumber;
    private double distance;
    private double speed;
    private String color;
    private String status;
    private String[] writeOnCSV;

    public Roadplus() {
           
        }

    public Roadplus(String date, int roadNumber, String road, String fromTo, int fromToNumber, String roadName,
                int roadNameNumber, double distance, double speed, String color, String status) {
            this.date = date;
            this.roadNumber = roadNumber;
            this.road = road;
            this.fromTo = fromTo;
            this.fromToNumber = fromToNumber;
            this.roadName = roadName;
            this.roadNameNumber = roadNameNumber;
            this.distance = distance;
            this.speed = speed;
            this.color = color;
            this.status = status;
        }

    public Roadplus(int roadNumber, String road, String fromTo, String roadName, double distance, double speed,
                String color) {
            this.roadNumber = roadNumber;
            this.road = road;
            this.fromTo = fromTo;
            this.roadName = roadName;
            this.distance = distance;
            this.speed = speed;
            this.color = color;
            setStatus(color);
        }

    public int getFromToNumber() {
        return fromToNumber;
    }

    public void setFromToNumber(int fromToNumber) {
        this.fromToNumber = fromToNumber;
    }

    public int getRoadNameNumber() {
        return roadNameNumber;
    }

    public void setRoadNameNumber(int roadNameNumber) {
        this.roadNameNumber = roadNameNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRoadNumber() {
        return roadNumber;
    }

    public void setRoadNumber(int roadNumber) {
        this.roadNumber = roadNumber;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getFromTo() {
        return fromTo;
    }

    public void setFromTo(String fromTo) {
        this.fromTo = fromTo;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getWriteOnCSV() {
        return writeOnCSV;
    }

    public void setWriteOnCSV(String date, int roadNumber, String road, String fromTo, int fromToNumber,
            String roadName, int roadNameNumber, double distance, double speed, String color) {
        this.writeOnCSV = new String[11];
        writeOnCSV[0] = date;
        writeOnCSV[1] = "" + roadNumber;
        writeOnCSV[2] = road;
        writeOnCSV[3] = fromTo;
        writeOnCSV[4] = "" + fromToNumber;
        writeOnCSV[5] = roadName;
        writeOnCSV[6] = "" + roadNameNumber;
        writeOnCSV[7] = "" + distance;
        writeOnCSV[8] = "" + speed;
        writeOnCSV[9] = color;
        writeOnCSV[10] = this.status;
    }

}
