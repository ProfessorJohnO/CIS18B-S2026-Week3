package edu.norco.cis18b.week3.coffeeshop;

public class App {

    public static void main(String[] args) {
        System.out.println("Coffee Shop App Running!");

        Latte latte = new Latte(Beverage.Size.MEDIUM);
        ColdBrew coldBrew = new ColdBrew(Beverage.Size.LARGE);

        System.out.println("Latte price: " + latte.getPrice());
        System.out.println("Cold brew price: " + coldBrew.getPrice());

        CustomDrink drink = new CustomDrink.Builder()
                .size(Beverage.Size.MEDIUM)
                .milk(CustomDrink.Milk.OAT)
                .syrup(CustomDrink.Syrup.VANILLA)
                .espressoShots(2)
                .addExtra("cinnamon")
                .build();

        System.out.println("Custom drink price: " + drink.getPrice());
    }
}