package mentora;

public abstract class AbstractLivingBeing implements LivingBeingInterface {

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
}
