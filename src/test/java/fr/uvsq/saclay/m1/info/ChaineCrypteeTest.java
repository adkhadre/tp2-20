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
    @Test
    void crypteDAvecUneCleNegativeDeTrois() {
        ChaineCryptee chaine = ChaineCryptee.deEnClair("D", -3);

        assertEquals("A", chaine.crypte());
    }
    @Test
    void crypteCAvecUneCleNegativeDeTrois() {
        ChaineCryptee chaine = ChaineCryptee.deEnClair("C", -3);

        assertEquals("Z", chaine.crypte());
    }
    @Test
    void crypteEspaceNeDoitPasEtreModifie() {
        ChaineCryptee chaine = ChaineCryptee.deEnClair("A B", 1);

        assertEquals("B C", chaine.crypte());
    }
    @Test
    void crypteUneMinusculeNeDoitPasEtreModifiee() {
        ChaineCryptee chaine = ChaineCryptee.deEnClair("a", -3);

        assertEquals("a", chaine.crypte());
    }
    @Test
    void crypteUnChiffreNeDoitPasEtreModifie() {
        ChaineCryptee chaine = ChaineCryptee.deEnClair("A1B", 1);
        assertEquals("B1C", chaine.crypte());
    }
}