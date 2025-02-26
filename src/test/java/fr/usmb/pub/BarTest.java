package fr.usmb.pub;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        Assertions.assertEquals(coca, bar.boissonFroide.get(0));
    }

    @Test
    void AjouterBoissonAlcoolise() {
        bar.add(whisky);
        Assertions.assertEquals(whisky, bar.boissonAlcoolisee.get(0));
    }

    @Test
    void AjouterBoissonChaude(){
        bar.add(cafe);
        Assertions.assertTrue(bar.boissonChaude.contains(cafe));
    }

    @Test
    void ServirBoisson(){
        bar.add(coca);
        bar.serv("coca");
        Assertions.assertFalse(bar.boissonFroide.contains(coca));
    }
    @Test
    void BarSansB(){
        try {
            Assertions.assertNull(bar.serv("Coca"), "must return Null");
        } catch (NullPointerException e) {
            Assertions.fail(" NullPointerException.");
        }
    }

    @Test
    void RechercerInsensible(){
        bar.add(coca);
        Assertions.assertEquals(coca, bar.serv("Coca"));
}

}