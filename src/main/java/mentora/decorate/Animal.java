package mentora.decorate;

public abstract class Animal implements AnimalInterface {
    private AnimalInterface animal;

    public Animal(AnimalInterface animal) {
        this.animal = animal;
    }

    @Override
    public String description() {
        return animal.description();
    }
}
