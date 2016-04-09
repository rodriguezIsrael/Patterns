package Patterns;

/**
 * User: Litovka Serg
 * Date: 08.04.2016
 * Time: 14:05
 */
public class Builder {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBenchBuilder(new LineBenchBuilder());
        Bench lineBench = director.constructBench();
        director.setBenchBuilder(new CircleBenchBuilder());
        Bench circleBench = director.constructBench();

        System.out.println(lineBench);
        System.out.println(circleBench);
    }
}

class Bench {
    String model;
    int speed;
    int numberSaw;

    public void setModel(String model) {
        this.model = model;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setNumberSaw(int numberSaw) {
        this.numberSaw = numberSaw;
    }

    @Override
    public String toString() {
        return "Bench{" +
                "model='" + model + '\'' +
                ", speed=" + speed +
                ", numberSaw=" + numberSaw +
                '}';
    }
}

abstract class BenchBuilder {
    protected Bench bench;

    public void createBench() {
        bench = new Bench();
    }

    public Bench getBench() {
        return bench;
    }

    abstract public void setModelBench();
    abstract public void setSpeedBench();
    abstract public void setNumberSawBench();

}

class LineBenchBuilder extends BenchBuilder {

    public void setModelBench() {
        bench.setModel("Line");
    }
    public void setSpeedBench() {
        bench.setSpeed(2000);
    }
    public void setNumberSawBench() {
        bench.setNumberSaw(3);
    }
}

class CircleBenchBuilder extends BenchBuilder {

    public void setModelBench() {
        bench.setModel("Circle");
    }
    public void setSpeedBench() {
        bench.setSpeed(1000);
    }
    public void setNumberSawBench() {
        bench.setNumberSaw(1);
    }
}

class Director {
    private BenchBuilder benchBuilder;

    public void setBenchBuilder(BenchBuilder b) {
        benchBuilder = b;
    }

    public Bench constructBench() {
        benchBuilder.createBench();
        benchBuilder.setModelBench();
        benchBuilder.setNumberSawBench();
        benchBuilder.setSpeedBench();
        Bench bench = benchBuilder.getBench();
        return bench;
    }

}
