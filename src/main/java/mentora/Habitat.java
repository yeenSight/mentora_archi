package mentora;

/**
 * Représente un habitat pour animaux construit via le pattern Builder.
 *
 * <p>Cette classe est immuable (tous les attributs sont final) et ne peut être
 * instanciée que via son Builder interne. Cela garantit que l'objet est toujours
 * dans un état cohérent.</p>
 */
public class Habitat {
    private final String typeHabitat;
    private final String nourriture;
    private final Taille taille;

    /**
     * Énumération représentant les tailles disponibles pour un habitat.
     */
    public enum Taille {
        PETIT, MOYEN, GRAND
    }

    /**
     * Constructeur privé accessible uniquement par le Builder.
     *
     * @param builder Le builder contenant les paramètres de construction
     */
    private Habitat(Builder builder) {
        this.typeHabitat = builder.typeHabitat;
        this.nourriture = builder.nourriture;
        this.taille = builder.taille;
    }

    public String getTypeHabitat() {
        return typeHabitat;
    }

    public String getNourriture() {
        return nourriture;
    }

    public Taille getTaille() {
        return taille;
    }

    @Override
    public String toString() {
        return "Habitat{" +
                "type='" + typeHabitat + '\'' +
                ", nourriture='" + nourriture + '\'' +
                ", taille=" + taille +
                '}';
    }

    /**
     * Builder pour construire un Habitat de manière fluide et lisible.
     *
     * <p>Le pattern Builder résout plusieurs problèmes :</p>
     * <ul>
     *   <li>Évite les constructeurs avec trop de paramètres</li>
     *   <li>Permet de construire l'objet étape par étape</li>
     *   <li>Rend le code client plus lisible et maintenable</li>
     *   <li>Permet des paramètres optionnels avec des valeurs par défaut</li>
     * </ul>
     *
     * <h2>Fonctionnement :</h2>
     * <p>Le Builder accumule les paramètres via des méthodes chainées (fluent API),
     * puis construit l'objet final via la méthode {@code build()}. Chaque méthode
     * retourne le Builder lui-même pour permettre le chaînage.</p>
     *
     * @example
     * <pre>
     * Habitat habitat = new Habitat.Builder()
     *     .typeHabitat("Niche")
     *     .nourriture("Croquettes")
     *     .taille(Habitat.Taille.MOYEN)
     *     .build();
     * </pre>
     */
    public static class Builder {
        private String typeHabitat;
        private String nourriture;
        private Taille taille;

        /**
         * Constructeur du Builder avec des valeurs par défaut optionnelles.
         */
        public Builder() {
            // Valeurs par défaut
            this.typeHabitat = "Standard";
            this.nourriture = "Non spécifiée";
            this.taille = Taille.MOYEN;
        }

        /**
         * Définit le type d'habitat (niche, cage, enclos, aquarium, etc.).
         *
         * @param typeHabitat Le type d'habitat
         * @return Le Builder pour permettre le chaînage
         */
        public Builder typeHabitat(String typeHabitat) {
            this.typeHabitat = typeHabitat;
            return this;
        }

        /**
         * Définit le type de nourriture pour les animaux de cet habitat.
         *
         * @param nourriture Le type de nourriture
         * @return Le Builder pour permettre le chaînage
         */
        public Builder nourriture(String nourriture) {
            this.nourriture = nourriture;
            return this;
        }

        /**
         * Définit la taille de l'habitat (PETIT, MOYEN ou GRAND).
         *
         * @param taille La taille de l'habitat
         * @return Le Builder pour permettre le chaînage
         */
        public Builder taille(Taille taille) {
            this.taille = taille;
            return this;
        }

        /**
         * Construit l'objet Habitat final avec les paramètres accumulés.
         *
         * <p>Cette méthode valide que tous les paramètres obligatoires sont présents
         * et crée une instance immuable d'Habitat.</p>
         *
         * @return Une nouvelle instance d'Habitat
         * @throws IllegalStateException si des paramètres obligatoires sont manquants
         */
        public Habitat build() {
            // Validation optionnelle
            if (typeHabitat == null || typeHabitat.isEmpty()) {
                throw new IllegalStateException("Le type d'habitat est obligatoire");
            }
            return new Habitat(this);
        }
    }
}