package fr.usmb.pub;

import org.junit.jupiter.api.*;

class BoissonTest {
    Boisson b;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testToString() {
        fail("Not yet implemeted");
    }

    @Test
    void exempleTest(){
        b = new Boisson("coca");
        Assertions.assertEquals("coca", b.nom);
    }

    @Test
    void testNewDrinkON(){
        b = new Boisson("Water");
        Assertions.assertEquals("Water", b.nom);
    }

    @Test
    void testNewDrinkNameDegree(){
        b = new Boisson("Whisky", 10.0f);
        Assertions.assertEquals("Whisky", b.nom);
        Assertions.assertEquals(10.0f, b.degre);
        Assertions.assertTrue(b.alcoolise);

    }

    @Test
    void testNewDrinkNegativeDegree(){
        try {
            b = new Boisson("Not whisky", -10.0f);
            Assertions.fail("Exception should be thrown for negative alcohol degree");
        } catch (IllegalArgumentException e) {
            Assertions.assertTrue(e.getMessage().contains("degree"));
        }
    }

    @Test
    void testCheckFuncAlc(){
        b = new Boisson("Brandy", 5.0f);
        String expected = "Brandy (l'abus d'alcool est dangereux pour la sante)";
        Assertions.assertEquals(expected, b.toString());
    }


    @Test
    void testCheckFuncNonAlc(){
        b = new Boisson("Water");
        Assertions.assertEquals("Water", b.nom);
    }
}