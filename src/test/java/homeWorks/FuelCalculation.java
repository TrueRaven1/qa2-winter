package homeWorks;

import org.junit.jupiter.api.Test;

public class FuelCalculation {

    private float theAmountOfFuelForTheTrip(float a, float b) {

        return a * b / 100;
    }

    @Test
    public void test() {
        float a = theAmountOfFuelForTheTrip(7, 150);
        float b = theAmountOfFuelForTheTrip(8, 590);
        float c = theAmountOfFuelForTheTrip(4, 220);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
