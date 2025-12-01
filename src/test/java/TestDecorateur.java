import mentora.decorate.*;
import org.junit.Test;

public class TestDecorateur {

    @Test
    public void testDecorateur() {
        AnimalInterface animal = new Aquatique(new AnimalImpl());
        System.out.println(animal.description());
    }
}
