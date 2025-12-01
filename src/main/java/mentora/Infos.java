package mentora;

import java.util.List;

public class Infos {
    List<LivingBeingInterface> livingBeings;

    /**
     * Permet de retourner un animal indépendement de son type.
     * Ceci permet lors de l'appel des méthodes de l'interface d'avoir
     * le résultat du tympe lapin ou chien par exemple
     *
     * Pour appeler les méhodes de la classe abstraite, il faudra faire un cast
     * Pour celles des méthodes lié au lapin par exemple il faudra aussi faire un cast
     * @param type
     * @return
     */
    public LivingBeingInterface getLivingBeingByType(String type) {
        for (LivingBeingInterface being : livingBeings) {
            if (being.getClass().getSimpleName().equalsIgnoreCase(type)) {
                return being;
            }
        }
        return null;
    }
}
