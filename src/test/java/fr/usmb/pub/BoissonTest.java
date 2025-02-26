package fr.usmb.pub;

import org.junit.jupiter.api.*;

import java.util.Optional;

class BoissonTest {
    Boisson b;

    @Test
    void DrinkNameInitialization(){
        b = new Boisson("Water");
        Assertions.assertEquals("Water", b.nom);
    }

    @Test
    void AlocoholicDrinkDegreeAndNameInitialisation(){
        b = new Boisson("Whisky", 10.0f);
        Assertions.assertEquals("Whisky", b.nom);
        Assertions.assertTrue(10.0f == b.degre);
    }

    @Test
    void AlcoholicDrinkIsAlcoholic(){
        b = new Boisson("Whisky", 10.0f);
        Assertions.assertTrue(b.alcoolise);
    }

    @Test
    void DrinkNegativeDegreeInitialization(){
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