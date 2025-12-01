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
    public Habitat(HabitatBuilder builder) {
        this.typeHabitat = builder.getTypeHabitat();
        this.nourriture = builder.getNourriture();
        this.taille = builder.getTaille();
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
}