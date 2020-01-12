package WORKSHOPS.arena;

import java.util.LinkedHashMap;
import java.util.Map;


public class FightingArena {
    private String name;
    private Map<String, Gladiator> gladiators;

    public FightingArena(String name) {
        this.name = name;
        this.gladiators = new LinkedHashMap<>();
    }

    public void add(Gladiator gladiator){
        this.gladiators.put(gladiator.getName(), gladiator);
    }

    public void remove(String name){
        this.gladiators.remove(name);
    }

    public Gladiator getGladiatorWithHighestStatPower(){
        return this.gladiators.values().stream()
                .max((g1, g2) -> {
                    int result = 0;
            if (g1.getStatPower() >
                    g2.getStatPower()) {
                result = 1;
            } else if (g1.getStatPower() <
                    g2.getStatPower()){
                result =  -1;
            }
            return result;
        }).get();
    }

    public Gladiator getGladiatorWithHighestWeaponPower(){
        return this.gladiators.values().stream()
                .max((g1, g2) -> {
            int result = 0;
            if (g1.getWeaponPower() >
                    g2.getWeaponPower()) {
                result = 1;
            } else if (g1.getWeaponPower() <
                    g2.getWeaponPower()) {
                result = -1;
            }
            return result;
        }).get();
    }

    public Gladiator getGladiatorWithHighestTotalPower() {
        return this.gladiators.values().stream()
                .max((g1, g2) -> {
                    int result = 0;
                    if (g1.getTotalpower() >
                            g2.getTotalpower()) {
                        result = 1;
                    } else if (g1.getTotalpower() <
                            g2.getTotalpower()) {
                        result = -1;
                    }
                    return result;
                }).get();
    }

    public int getCount(){
       return this.gladiators.size();
    }

    @Override
    public String toString() {
        return String.format("%s - %d gladiators are participating.%n",
                this.name, getCount());
    }
}

