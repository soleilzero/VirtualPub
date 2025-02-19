package fr.usmb.pub;

import org.junit.jupiter.api.*;

class BarTest {

    private Bar bar;
    private Boisson cafe = new Boisson("cafe");
    private Boisson coca = new Boisson("coca");
    private Boisson whisky = new Boisson("whisky",(float) 10);
    private Boisson eau = new Boisson("eau");

    @BeforeEach
    void setUp() {
        bar = new Bar();
    }

    @AfterEach
    void tearDown() {
        bar = null;
    }

    @Test
    void AjouterBoissonFroide() {
        bar.add(coca);
        Assertions.assertEquals(coca, bar.boissonFroide.firstElement());
    }

    @Test
    void AjouterBoissonAlcoolise() {
        bar.add(whisky);
        Assertions.assertEquals(whisky, bar.boissonAlcoolisee.firstElement());
    }
}