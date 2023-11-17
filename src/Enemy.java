public class Enemy {
    String name;
    int health;

    int rewards;

    // new Enemy("rock"          ,10)
    public Enemy(String name,int health,int rewards) {
        this.name = name;
        this.health = health;
        this.rewards = rewards;
    }

    void takeDamage(Weapon weapon) {
        if (health > 0) {
            System.out.println(name + " took " + weapon.damage + " damage from " + weapon.weaponName + ".");
            this.health -= weapon.damage;
        }
    }

    void takeDamage(int damage) {
        if (health > 0) {
            System.out.println(name + " took " + damage + " damage.");
            this.health -= damage;
        }
    }

    void outputHealth() {
        System.out.println(name + "'s health is " + health + ".");
    }
}
