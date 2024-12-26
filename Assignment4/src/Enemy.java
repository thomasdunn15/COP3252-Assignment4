import java.util.Random;

public class Enemy {
    int health;
    String enemy;

    public Enemy(){

    }

    int takeDamage(){
        return health;
    }

    void setHealth(){

    }

    int getHealth(){
        return health;
    }

    String getRandomEnemy(){
        String[] enemyTypes = {"Ogre", "Troll", "Sorcerer"};
        int index = new Random().nextInt(enemyTypes.length);
        return enemyTypes[index];
    }

}