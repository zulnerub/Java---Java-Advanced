package WORKSHOPS.heroRepository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HeroRepository {
    private Map<String, Hero> heroes;

    public HeroRepository() {
        this.heroes = new LinkedHashMap<String, Hero>();
    }

    public void add(Hero hero){
        this.heroes.put(hero.getName(), hero);
    }

    public void remove(String name){
        this.heroes.remove(name);

    }

    public Hero getHeroWithHighestStrength(){
        return this.heroes.values()
                .stream()
                .sorted((e1, e2) -> e2.getItem().getStrength() - e1.getItem().getStrength())
                .collect(Collectors.toList())
                .get(0);
    }

    public Hero getHeroWithHighestAgility(){
        return this.heroes.values()
                .stream()
                .sorted((e1, e2) -> e2.getItem().getAgility() - e1.getItem().getAgility())
                .collect(Collectors.toList())
                .get(0);
    }

    public Hero getHeroWithHighestIntelligence(){
        return this.heroes.values()
                .stream()
                .sorted((e1, e2) -> e2.getItem().getIntelligence() - e1.getItem().getIntelligence())
                .collect(Collectors.toList())
                .get(0);
    }

    public int getCount(){
        return this.heroes.size();
    }

    @Override
    public String toString() {
        return String.join("\n",
                this.heroes.values().stream()
                .map(Hero::toString)
                .collect(Collectors.toList()));
    }
}
