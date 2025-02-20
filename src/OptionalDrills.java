
import utilities.Car;
import utilities.Dish;
import utilities.Insurance;

import java.util.List;
import java.util.Optional;

public class OptionalDrills {

    /**
     * Print out the name of a dish that is vegetarian. If there is no vegetarian dish, do nothing.
     * @param menu - the list of dishes to look through
     */
    public static void printOutExampleVegetarianDish(List<Dish> menu) {
        menu.stream()
                .filter(Dish::isVegetarian)
                .findFirst()
                .ifPresent(dish -> System.out.println("Vegetarian dish: " + dish.getName()));
        //este metodo findFirst() retorna Optional<Dish> que se puede luego usar con ifPresent()

    }

    /**
     * Return the name of the dish. There is a good chance the utilities.Dish coming in is null.
     * @param dish A dish (maybe null...)
     * @return the name of the dish if it exists
     */
    public static Optional<String> getDishName(Dish dish) {
        return Optional.ofNullable(dish).map(Dish::getName);//.orElse(null);
        //este metodo map retorna Optional<String> que se puede luego usar con ifPresent()
        // para validar si el Optional es presente y ejecutar una accion en caso afirmativo.
    }

    /**
     * Return the name of the insurance for this car.
     * @param car A car
     * @return The name of the insurance if it exists
     */
    public static Optional<String> getExistingInsuranceName(Car car) {
        return Optional.ofNullable(car).flatMap(Car::getInsurance).map(Insurance::getName);
        // este metodo flatMap retorna Optional<Insurance> que se puede luego usar con ifPresent()
        // para validar si el Optional es presente y luego aplicar una transformacion en caso afirmativo.





    }

    /**
     * Use the private 'otherService' method below to find the name of the
     * insurance that will be cheapest for me.  Be careful!
     * @param car A car
     * @return the name of the cheapest insurance if it exists
     */
    public static Optional<String> findCheapestInsuranceName(Car car) {

        // TODO: Use otherService to find the cheapest insurance for the car
        // and return it as an Optional<String>
        // Be careful with null return values!
        return Optional.ofNullable(car).flatMap(car -> Optional.ofNullable(safeOtherService(car)))
               .map(Insurance::getName);
        // este metodo flatMap retorna Optional<Insurance> que se puede luego usar con ifPresent()
        // para validar si el Optional es presente y luego aplicar una transformacion en caso afirmativo.
    }

    /**
     * Cool!  I wrote a new version of 'otherService' called
     * 'safeOtherService' that will never return null!  But now
     * the car being passed in is an Optional... what do I do???
     * @param car maybe a car?
     * @return the name of the car's cheapest insurance if it and the car exist
     */
    public static Optional<String> findCheapestInsuranceName(Optional<Car> car) {
        return car.flatMap(car -> Optional.ofNullable(safeOtherService(car)))
               .map(Insurance::getName);
        // este metodo flatMap retorna Optional<Insurance> que se puede luego usar con ifPresent()
        // para validar si el Optional es presente y luego aplicar una transformacion en caso afirmativo.
    }

    /**
     * Tries to find the cheapest insurance, may be null.
     */
    private static Insurance otherService(Car car) {


    }

    /**
     * Tries to find the cheapest insurance, may be null.
     */
    private static Insurance safeOtherService(Car car) {
        // TODO: Implement a safer version of 'otherService' that returns a default Insurance
        // if car is null.
        // Be careful with null return values!
       /* if (car == null) {
            return new Insurance("Default Insurance");
        } else {
            return otherService(car);
        }*/
        return car.map(Car::getInsurance).orElseGet(OptionalDrills::defaultInsurance);

    }
}
