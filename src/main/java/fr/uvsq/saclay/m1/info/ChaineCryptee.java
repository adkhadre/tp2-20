package fr.uvsq.saclay.m1.info;

public class ChaineCryptee {

    private String chaine;
    private int decalage;

    private ChaineCryptee(String chaine, int decalage) {
        if (chaine == null) {
            throw new IllegalArgumentException("La chaîne ne peut pas être null");
        }

        this.chaine = chaine;
        this.decalage = decalage;
    }

    public static ChaineCryptee deEnClair(String chaine, int decalage) {
        return new ChaineCryptee(chaine, decalage);
    }
    private char decaleCaractere(char c, int decalage) {
        if (c < 'A' || c > 'Z') {
            return c;
        }
        return (char) (Math.floorMod(c - 'A' + decalage, 26) + 'A');
    }

    public String crypte() {
        String resultat = "";

        for (int i = 0; i < chaine.length(); i++) {
            char caractere = chaine.charAt(i);
            resultat += decaleCaractere(caractere, decalage);
        }

        return resultat;
    }
    public static ChaineCryptee deCryptee(String chaine, int decalage) {
        return new ChaineCryptee(chaine, decalage);
    }
    public String decrypte() {
        String resultat = "";

        for (int i = 0; i < chaine.length(); i++) {
            char caractere = chaine.charAt(i);
            resultat += decaleCaractere(caractere, -decalage);
        }

        return resultat;
    }
}