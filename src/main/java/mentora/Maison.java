package mentora;

import java.util.Collections;
import java.util.List;

/**
 * exemple de singleton
 */
public class Maison {

    //instance unique
    private static Maison instance;
    List<LivingBeingInterface> animals = Collections.emptyList();
    List<Habitat> habitats = Collections.emptyList();

    private Maison() {
        // Constructeur privé pour empêcher l'instanciation externe
    }

    public static Maison getInstance() {
        if (instance == null) {
            instance = new Maison();
        }
        return instance;
    }

    public void addAnimal(String animal) {
        animals.add(AnimalFactory.creerAnimal(animal));
    }
    public List<LivingBeingInterface> getAnimals() {
        return animals;
    }

    public void addHabitat(String type, String nourriture, Habitat.Taille taille) {
        habitats.add(new Habitat.Builder()
            .typeHabitat(type)
            .nourriture(nourriture)
            .taille(taille)
            .build());
    }
}
