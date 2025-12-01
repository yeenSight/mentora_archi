package mentora.decorate;

public class Terrestre extends Animal {

    public Terrestre(AnimalInterface animal) {
        super(animal);
    }

    @Override
    public String description() {
        return super.description() + "  terrestre";
    }
}
