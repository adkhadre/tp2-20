package fr.uvsq.saclay.m1.info;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ChaineCrypteeTest {

    @Test
    void crypteUneChaineAvecUneCleDeUn() {
        ChaineCryptee chaine = ChaineCryptee.deEnClair("ABC", 1);

        assertEquals("BCD", chaine.crypte());
    }
    @Test
    void crypteZAvecUneCleDeTrois() {
        ChaineCryptee chaine = ChaineCryptee.deEnClair("Z", 3);

        assertEquals("C", chaine.crypte());
    }
}