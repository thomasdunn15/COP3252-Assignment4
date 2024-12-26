import java.util.Scanner;
public class KnightDriver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char playAgain = 'n';
        int enemyHealth = 100;

        //do while function to keep player playing after game is over
        do {
            Knight Knight = new Knight();
            Knight autoGenerated = new Knight();
            Knight userDefined = new Knight();

            System.out.println("Welcome to Knight Fight!");
            System.out.print("Enter the name of your Knight: ");
            String name = input.next();

            Knight.setName(name);

            System.out.println("Now select your weapon! (Choose number)");
            System.out.println("1) Long Sword");
            System.out.println("2) Battle Axe");
            System.out.println("3) Spear");
            System.out.println("4) Warhammer");

            System.out.print("Your choice my liege? : ");
            int weaponOption = input.nextInt();

            //switch case to choose weapon
            switch (weaponOption) {
                case 1 -> Knight.setWeapon("Long Sword");
                case 2 -> Knight.setWeapon("Battle Axe");
                case 3 -> Knight.setWeapon("Spear");
                case 4 -> Knight.setWeapon("Warhammer");
            }

            //ask if user wants knight auto generated or not
            System.out.print("Would you like to auto generate your opponent? (y|n): ");
            char autoGenerate = input.next().charAt(0);

            //auto generates new knight
            if (autoGenerate == 'y') {

                //prints out stats
                System.out.println();
                System.out.println("Your Knight: ");
                System.out.println(Knight.Stats());

                System.out.println("Opponents Knight: ");
                System.out.println(autoGenerated.Stats());

                //press any key to begin function
                System.out.print("Press any key to begin battle: ");
                try {
                    System.in.read();
                    input.nextLine();
                } catch (Exception ignored) {
                }

                System.out.println();
                System.out.println("Begin!" + "\n");

                int round = 1;

                //while a knight is not dead fight function is called
                while (Knight.getHP() > 0 || autoGenerated.getHP() > 0) {

                    System.out.println("Round " + round);
                    Knight.fight(autoGenerated);
                    autoGenerated.fight(Knight);
                    System.out.println("Your Knight: ");
                    System.out.println(Knight.Stats());

                    if (Knight.getHP() <= 0) {
                        System.out.println(Knight.getName() + " died!");
                        break;
                    }

                    System.out.println("Opponents Knight: ");
                    System.out.println(autoGenerated.Stats());

                    if (autoGenerated.getHP() <= 0) {
                        System.out.println(autoGenerated.getName() + " died!");
                        enemyHealth = autoGenerated.getHP();
                        break;
                    }

                    round++;
                }


            } else if (autoGenerate == 'n') {

                System.out.print("Enter the name of your Opponent: ");
                String opponentName = input.next();

                System.out.println("Now select your opponents weapon! (Choose number)");
                System.out.println("1) Long Sword");
                System.out.println("2) Battle Axe");
                System.out.println("3) Spear");
                System.out.println("4) Warhammer");

                System.out.print("Your choice my liege? : ");
                int opponentWeapon = input.nextInt();

                userDefined.setName(opponentName);

                switch (opponentWeapon) {
                    case 1 -> userDefined.setWeapon("Long Sword");
                    case 2 -> userDefined.setWeapon("Battle Axe");
                    case 3 -> userDefined.setWeapon("Spear");
                    case 4 -> userDefined.setWeapon("Warhammer");
                }

                System.out.println();
                System.out.println("Your Knight: ");
                System.out.println(Knight.Stats());

                System.out.println("Opponents Knight: ");
                System.out.println(userDefined.Stats());

                System.out.print("Press any key to begin battle: ");
                try {
                    System.in.read();
                    input.nextLine();
                } catch (Exception ignored) {
                }

                System.out.println();
                System.out.println("Begin!" + "\n");

                int round = 1;

                while (Knight.getHP() > 0 || userDefined.getHP() > 0) {

                    System.out.println("Round " + round);
                    Knight.fight(userDefined);
                    userDefined.fight(Knight);
                    System.out.println("Your Knight: ");
                    System.out.println(Knight.Stats());

                    if (Knight.getHP() <= 0) {
                        System.out.println(Knight.getName() + " died!");
                        break;
                    }

                    System.out.println("Opponents Knight: ");
                    System.out.println(userDefined.Stats());

                    if (userDefined.getHP() <= 0) {
                        System.out.println(userDefined.getName() + " died!");
                        System.out.println("");
                        enemyHealth = userDefined.getHP();
                        break;
                    }

                    round++;
                }

            } else {
                System.out.print("Invalid option, goodbye!\n");
            }

            if (Knight.getHP() <= 0){
            System.out.print("Would you like to play again? (y|n): ");
            playAgain = input.next().charAt(0);
            }
        } while (playAgain == 'y' || enemyHealth > 0);


        System.out.println("");
        System.out.println("Your Knight has survived! However, now they have to pass through " +
                "the JavaBean Forest to get to their final destination.");
        System.out.println("Unfortunately for your knight, its midnight. Visibility is " +
                "zero and JavaBean forest is full of the most evil characters.");

        
        //System.out.print("Goodbye!");
    }
}
