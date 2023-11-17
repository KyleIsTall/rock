public class Weapon {

    String weaponName = "weapon";
    int damage = 1;
    int cost;
    boolean owned = false;

    // new Weapon("Sword", 10);
    public Weapon(String weaponName, int damage, int cost) {
       this.weaponName = weaponName;
       this.damage = damage;
       this.cost = cost;
    }
}
