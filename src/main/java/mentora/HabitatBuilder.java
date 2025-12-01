package mentora;

public class HabitatBuilder {
    private String typeHabitat;
    private String nourriture;
    private Habitat.Taille taille;

    /**
     * Constructeur du Builder avec des valeurs par défaut optionnelles.
     */
    public HabitatBuilder() {
        // Valeurs par défaut
        this.typeHabitat = "Standard";
        this.nourriture = "Non spécifiée";
        this.taille = Habitat.Taille.MOYEN;
    }

    /**
     * Définit le type d'habitat (niche, cage, enclos, aquarium, etc.).
     *
     * @param typeHabitat Le type d'habitat
     * @return Le Builder pour permettre le chaînage
     */
    public HabitatBuilder typeHabitat(String typeHabitat) {
        if(typeHabitat == null){
            this.typeHabitat = "Standard";
            return this;
        }
        this.typeHabitat = typeHabitat;
        return this;
    }

    /**
     * Définit le type de nourriture pour les animaux de cet habitat.
     *
     * @param nourriture Le type de nourriture
     * @return Le Builder pour permettre le chaînage
     */
    public HabitatBuilder nourriture(String nourriture) {
        if(nourriture == null){
            throw new RuntimeException("nourriture ne peut pas être null");
        }
        this.nourriture = nourriture;
        return this;
    }

    /**
     * Définit la taille de l'habitat (PETIT, MOYEN ou GRAND).
     *
     * @param taille La taille de l'habitat
     * @return Le Builder pour permettre le chaînage
     */
    public HabitatBuilder taille(Habitat.Taille taille) {
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

    public String getTypeHabitat() {
        return typeHabitat;
    }

    public String getNourriture() {
        return nourriture;
    }

    public Habitat.Taille getTaille() {
        return taille;
    }
}
