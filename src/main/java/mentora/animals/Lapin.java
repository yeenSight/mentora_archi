package mentora.animals;

import mentora.AbstractLivingBeing;

import java.util.List;


public class Lapin extends AbstractLivingBeing {

    /**
     * impmlémentation obligatoire de la méthode venant de l'interface
     * @return
     */
    @Override
    public List<String> getFoodHabits() {
        return List.of("herbes", "légumes", "fruits");
    }

    /**
     * impmlémentation obligatoire de la méthode venant de l'interface
     * @param age
     * @return
     */
    @Override
    public int getAge(int age) {
        return 3*age;
    }

    /**
     * implémentation obligatoire venant de la classe abstraite
     * @param distance
     */
    @Override
    protected void jump(int distance) {
        System.out.println("Le lapin saute de " + distance + " mètres.");
    }
}
