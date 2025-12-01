package mentora.animals;

import mentora.AbstractLivingBeing;
import mentora.LivingBeingInterface;

import java.util.List;

public class Chien extends AbstractLivingBeing {

    /**
     * impmlémentation obligatoire de la méthode venant de l'interface
     * @return
     */
    @Override
    public List<String> getFoodHabits() {
        return List.of("viande", "croquettes", "os");
    }

    /**
     * impmlémentation obligatoire de la méthode venant de l'interface
     * @param age
     * @return
     */
    @Override
    public int getAge(int age) {
        return 7*age;
    }

    /**
     * implémentation obligatoire venant de la classe abstraite
     * @param distance
     */
    @Override
    protected void jump(int distance) {
        System.out.println("Le chien saute de " + distance + " mètres.");
    }
}
