public abstract class Cat {
    private String name;
    private double skill;

    public Cat(String name, double skill) {
        this.name = name;
        this.skill = skill;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", this.name, this.skill);
    }
}
