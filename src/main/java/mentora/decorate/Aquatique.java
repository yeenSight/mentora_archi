package mentora.decorate;

public class Aquatique extends Animal {

    public Aquatique(AnimalInterface animal) {
        super(animal);
    }

    @Override
    public String description() {
        return super.description() +  " aquatique";
    }
}
