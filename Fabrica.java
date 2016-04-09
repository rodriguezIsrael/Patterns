package Patterns;

/**
 * User: Litovka Serg
 * Date: 09.04.2016
 * Time: 23:07
 */
public class Fabrica {
    public static void main(String[] args) {

        DetalCreator detalCreator = getDetalCreator("shaft");
        detalCreator.createDetal().showDetal();


    }

    public static DetalCreator getDetalCreator(String detal) {
        if (detal.equals("shaft")) {
            return new ShaftCreator();
        } else if (detal.equals("engine")) {
            return new EngineCreator();
        }

        throw new RuntimeException("there is not such detal " + detal);
    }
}

interface Detal {
    public void showDetal();
}

class Shaft implements Detal {

    public void showDetal() {
        System.out.println("Create shaft");
    }
}


class Engine implements Detal {

    public void showDetal() {
        System.out.println("Create engine");
    }
}

interface DetalCreator {
    public Detal createDetal();
}

class ShaftCreator implements DetalCreator {

    public Detal createDetal() {
        return new Shaft();
    }
}

class EngineCreator implements DetalCreator {

    public Detal createDetal() {
        return new Engine();
    }
}
