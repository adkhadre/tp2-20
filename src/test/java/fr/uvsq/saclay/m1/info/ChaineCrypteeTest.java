package fr.uvsq.saclay.m1.info;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

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
    @Test
    void crypteAvecUneCleSuperieureA26() {
        ChaineCryptee chaine = ChaineCryptee.deEnClair("A", 27);
        assertEquals("B", chaine.crypte());
    }
    @Test
    void crypteAvecUneCleInferieureAmoins26() {
        ChaineCryptee chaine = ChaineCryptee.deEnClair("C", -29);
        assertEquals("Z", chaine.crypte());
    }
    @Test
    void crypteUneChaineNullDoitLeverUneException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> ChaineCryptee.deEnClair(null, 1)
        );
    }
    @Test
    void decrypteUneChaineAvecUneCleDeUn() {
        ChaineCryptee chaine = ChaineCryptee.deCryptee("BCD", 1);
        assertEquals("ABC", chaine.decrypte());
    }

}