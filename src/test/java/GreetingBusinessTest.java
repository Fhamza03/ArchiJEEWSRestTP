
import fr.ubo.hello.bean.Greeting;
import fr.ubo.hello.business.GreetingBusiness;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingBusinessTest {

    private GreetingBusiness business;

    @BeforeEach
    void setUp() {
        business = new GreetingBusiness();
    }

    @Test
    void testGreeting() {
        String name = "Hamza";
        Greeting result = business.greeting(name);

        assertNotNull(result);
        assertEquals("Hello, Hamza", result.getMessage());
        assertEquals("Hamza FELLAH", result.getAuteur());
    }

    @Test
    void testBadGreeting() {
        Greeting result = business.badGreeting();

        assertNotNull(result);
        assertEquals("name est obligatoire. Merci de le renseigner.", result.getMessage());
        assertEquals("Hamza FELLAH", result.getAuteur());
    }
}
