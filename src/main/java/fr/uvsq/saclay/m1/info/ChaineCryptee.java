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
    private String transforme(int decalage) {
        StringBuilder resultat = new StringBuilder();

        for (int i = 0; i < chaine.length(); i++) {
            char caractere = chaine.charAt(i);
            resultat.append(decaleCaractere(caractere, decalage));
        }

        return resultat.toString();
    }
    public String crypte() {
        return transforme(decalage);
    }

    public static ChaineCryptee deCryptee(String chaine, int decalage) {
        return new ChaineCryptee(chaine, decalage);
    }
    public String decrypte() {
        return transforme(-decalage);
    }


}