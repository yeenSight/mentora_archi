package mentora;

public abstract class AbstractLivingBeing implements LivingBeingInterface {
    private int numberPaw;
    /**
     * Méthode abstraite à implémenter dans les classes filles
     */
    protected abstract void jump(int distance);

    /**
     * Méthode concrète pouvant être utilisée telle quelle dans les classes filles
     */
    public void goForward(){
        System.out.println("Je vais de l'avant");
    }

    public void setNumberPaw(int nbPaw){
        numberPaw = nbPaw;
    }

    public int getNumberPaw(){
        return numberPaw;
    }
}
