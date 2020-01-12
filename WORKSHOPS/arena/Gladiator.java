package WORKSHOPS.arena;


public class Gladiator {
    private String name;
    private Weapon weapon;
    private Stat stat;

    public Gladiator(String name, Stat stat, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
        this.stat = stat;
    }

    public String getName() {
        return name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Stat getStat() {
        return stat;
    }

    public int getStatPower(){
        return this.stat.getAgility() +
                this.stat.getFlexibility() +
                this.stat.getIntelligence() +
                this.stat.getSkills() +
                this.stat.getStrength();
    }

    public int getWeaponPower(){
        return this.weapon.getSharpness() +
                this.weapon.getSize() +
                this.weapon.getSolidity();
    }

    public int getTotalpower(){
        return getStatPower() + getWeaponPower();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append(" - ").append(getTotalpower())
                .append(System.lineSeparator());
        sb.append("  Weapon Power: ").append(getWeaponPower())
                .append(System.lineSeparator());
        sb.append("  Stat Power: ").append(getStatPower());
        return sb.toString();
    }
}
