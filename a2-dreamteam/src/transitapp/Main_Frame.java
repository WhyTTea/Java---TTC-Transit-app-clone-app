// These is a placeholder package and placeholder class
// Feel free to rename or remove these when you add in your own code (just make sure to add/commit/push any changes made,
//		and let your teammates know to pull the changes. Follow the workflow in the a2 instructions)

package transitapp;

import java.util.ArrayList;

public class Main_Frame {

    private static ArrayList<Cardholder> cardholders;
    private static ArrayList<Admin> admins;

    public static Cardholder checkUser(String name, String lastname, String email, String cardn){
        if (cardholders != null){
            for (Cardholder c : cardholders){
                if (c.getName().equals(name + " " + lastname) && c.email.equals(email)){
                    return c;
                }
            }
        }

        Cardholder cardholder = new Cardholder(name, lastname, email);
        Card card = new Card(cardn, cardholder);
        cardholder.addCard(card);

        cardholders.add(cardholder);

        return cardholder;
    }

    public boolean cardholderExists(Cardholder user){
        return cardholders.contains(user);
    }

    public boolean adminExists(Admin user){
        return admins.contains(user);
    }
}
