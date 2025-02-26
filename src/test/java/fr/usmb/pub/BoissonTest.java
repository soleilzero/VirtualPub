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
    void NegativeAlcoholDegreeIsNotAllowed(){
        try {
            b = new Boisson("Not whisky", -10.0f);
            Assertions.fail("Exception should be thrown for negative alcohol degree");
        } catch (IllegalArgumentException e) {
            Assertions.assertTrue(e.getMessage().contains("degree"));
        }
    }

    @Test
    void ZeroAlcoholDegreeIsNonAlcoholic(){
        b = new Boisson("Water", 0f);
        Assertions.assertFalse(b.alcoolise);
    }

    @Test
    void AlcoholDegreeOver100IsNotAllowed(){
        try {
            b = new Boisson("Potion", 101f);
            Assertions.fail("Exception should be thrown for negative alcohol degree");
        } catch (IllegalArgumentException e) {
            Assertions.assertTrue(e.getMessage().contains("degree"));
        }
    }

    @Test
    void correctAlcoholicDrinkNameToString(){
        b = new Boisson("Brandy", 5.0f);
        Assertions.assertTrue(b.toString().contains("Brandy"));
        Assertions.assertTrue(b.toString().contains("(l'abus d'alcool est dangereux pour la sante)"));
    }

    @Test
    void correctNonAlcoholicDrinkNameToString(){
        b = new Boisson("Water");
        Assertions.assertTrue(b.toString().contains("Water"));
        Assertions.assertFalse(b.toString().contains("(l'abus d'alcool est dangereux pour la sante)"));
    }

}