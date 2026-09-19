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
    @Test
    void decrypteCAvecUneCleDeTrois() {
        ChaineCryptee chaine = ChaineCryptee.deCryptee("C", 3);
        assertEquals("Z", chaine.decrypte());
    }
    @Test
    void decrypteZAvecUneCleNegativeDeTrois() {
        ChaineCryptee chaine = ChaineCryptee.deCryptee("Z", -3);
        assertEquals("C", chaine.decrypte());
    }
    @Test
    void decrypteUneChaineAvecUnEspace() {
        ChaineCryptee chaine = ChaineCryptee.deCryptee("B C", 1);
        assertEquals("A B", chaine.decrypte());
    }
    @Test
    void decrypteLesCaracteresNonMajusculesNeSontPasModifies() {
        ChaineCryptee chaine = ChaineCryptee.deCryptee("B1aC", 1);
        assertEquals("A1aB", chaine.decrypte());
    }
    @Test
    void crypterPuisDecrypterRedonneLaChaineOriginale() {
        String original = "HELLO WORLD";

        ChaineCryptee chaine = ChaineCryptee.deEnClair(original, 3);
        String chiffre = chaine.crypte();

        ChaineCryptee chaineCryptee = ChaineCryptee.deCryptee(chiffre, 3);
        String resultat = chaineCryptee.decrypte();

        assertEquals(original, resultat);
    }
    @Test
    void crypteUneChaineVide() {
        ChaineCryptee chaine = ChaineCryptee.deEnClair("", 3);
        assertEquals("", chaine.crypte());
    }
    @Test
    void decrypteUneChaineVide() {
        ChaineCryptee chaine = ChaineCryptee.deCryptee("", 3);
        assertEquals("", chaine.decrypte());
    }
    @Test
    void crypteAvecUneCleDeZero() {
        ChaineCryptee chaine = ChaineCryptee.deEnClair("ABC XYZ", 0);
        assertEquals("ABC XYZ", chaine.crypte());
    }
    @Test
    void decrypteAvecUneCleDeZero() {
        ChaineCryptee chaine = ChaineCryptee.deCryptee("ABC XYZ", 0);
        assertEquals("ABC XYZ", chaine.decrypte());
    }
    @Test
    void decrypteUneChaineNullDoitLeverUneException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> ChaineCryptee.deCryptee(null, 1)
        );
    }
    @Test
    void crypteAvecUneCleTresGrande() {
        ChaineCryptee chaine = ChaineCryptee.deEnClair("A", 52);
        assertEquals("A", chaine.crypte());
    }
    @Test
    void crypteAvecUneCleNegativeTresGrande() {
        ChaineCryptee chaine = ChaineCryptee.deEnClair("A", -52);
        assertEquals("A", chaine.crypte());
    }
    @Test
    void decrypteAvecUneCleTresGrande() {
        ChaineCryptee chaine = ChaineCryptee.deCryptee("A", 52);
        assertEquals("A", chaine.decrypte());
    }
    @Test
    void decrypteAvecUneCleNegativeTresGrande() {
        ChaineCryptee chaine = ChaineCryptee.deCryptee("A", -52);
        assertEquals("A", chaine.decrypte());
    }

}