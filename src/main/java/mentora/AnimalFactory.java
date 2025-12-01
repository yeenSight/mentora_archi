package mentora;

import mentora.animals.Chien;
import mentora.animals.Lapin;

/**
 * Factory pour la création d'animaux.
 *
 * <p>Le pattern Factory Method encapsule la logique de création des objets Animal.
 * Il permet de créer différents types d'animaux sans que le code client ait besoin
 * de connaître les classes concrètes (Chien, Chat, Oiseau, etc.).</p>
 *
 * <h2>Avantages du pattern Factory :</h2>
 * <ul>
 *   <li>Centralise la logique de création en un seul endroit</li>
 *   <li>Réduit le couplage entre le code client et les classes concrètes</li>
 *   <li>Facilite l'ajout de nouveaux types d'animaux sans modifier le code existant</li>
 *   <li>Respecte le principe Open/Closed (ouvert à l'extension, fermé à la modification)</li>
 * </ul>
 *
 * <h2>Fonctionnement :</h2>
 * <p>Au lieu d'instancier directement les classes concrètes avec {@code new Chien()},
 * le client appelle {@code AnimalFactory.creerAnimal(TypeAnimal.CHIEN)} et reçoit
 * une instance d'Animal. La factory se charge de déterminer quelle classe concrète
 * instancier en fonction du type demandé.</p>
 *
 * @see LivingBeingInterface
 * @see Chien
 * @see Lapin
 */
public class AnimalFactory {

    /**
     * Énumération des types d'animaux disponibles.
     * Utilisée pour garantir la sécurité des types lors de la création.
     */
    public enum TypeAnimal {
        /** Représente un chien */
        CHIEN,
        /** Représente un chat */
        LAPIN,
    }

    /**
     * Crée un animal en fonction du type spécifié via l'énumération.
     *
     * <p>Cette méthode est statique car elle n'a pas besoin d'état d'instance.
     * Elle agit comme un point d'entrée unique pour la création d'animaux.</p>
     *
     * @param type Le type d'animal à créer (CHIEN, CHAT ou OISEAU)
     * @return Une nouvelle instance de l'animal demandé
     * @throws IllegalArgumentException si le type est null ou non reconnu
     *
     * @example
     * <pre>
     * Animal monChien = AnimalFactory.creerAnimal(TypeAnimal.CHIEN);
     * monChien.faireDuBruit(); // Woof! Woof!
     * </pre>
     */
    public static LivingBeingInterface creerAnimal(TypeAnimal type) {
        switch (type) {
            case CHIEN:
                Chien chien = new Chien();
                chien.setNumberPaw(4);
                return chien;
            case LAPIN:
                return new Lapin();
            default:
                throw new IllegalArgumentException("Type d'animal inconnu : " + type);
        }
    }

    /**
     * Crée un animal en fonction d'une chaîne de caractères représentant le type.
     *
     * <p>Alternative pratique à la méthode avec enum, utile quand le type provient
     * d'une source externe (fichier de configuration, entrée utilisateur, etc.).
     * La comparaison est insensible à la casse.</p>
     *
     * @param type Le nom du type d'animal ("chien", "chat" ou "oiseau")
     * @return Une nouvelle instance de l'animal demandé
     * @throws IllegalArgumentException si le type est null, vide ou non reconnu
     *
     * @example
     * <pre>
     * Animal monChat = AnimalFactory.creerAnimal("chat");
     * monChat.seDeplacer(); // Le chat marche silencieusement
     * </pre>
     */
    public static LivingBeingInterface creerAnimal(String type) {
        switch (type.toLowerCase()) {
            case "chien":
                return new Chien();
            case "lapin":
                return new Lapin();
            default:
                throw new IllegalArgumentException("Type d'animal inconnu : " + type);
        }
    }
}