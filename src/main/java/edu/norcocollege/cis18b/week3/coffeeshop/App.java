
package edu.norco.cis18b.coffeeshop;

public class App 
{

    public static void main(String[] args) 
    {

        Latte latte = new Latte(Beverage.Size.MEDIUM);
        ColdBrew cold = new ColdBrew(Beverage.Size.LARGE);

        CustomDrink drink = new CustomDrink.Builder()
                .size(Beverage.Size.LARGE)
                .syrup(CustomDrink.Syrup.VANILLA)
                .espressoShots(2)
                .addExtra("Cinnamon")
                .build();

        Order order = new Order("1001");

        order.addItem(latte);
        order.addItem(cold);
        order.addItem(drink);

        System.out.println(order.total());
    }
}