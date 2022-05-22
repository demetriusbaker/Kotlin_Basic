public class CarJava {
    private final String name;
    private double speed;

    public CarJava(String name, double speed) {
        this.name = name;
        this.speed = speed;
    }

    public double getSpeed(){
        return speed;
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }

    public String getName(){
        return name;
    }
}
