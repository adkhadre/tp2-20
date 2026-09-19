package fr.uvsq.saclay.m1.info;

public class ChaineCryptee {

    private String chaine;
    private int decalage;

    private ChaineCryptee(String chaine, int decalage) {
        this.chaine = chaine;
        this.decalage = decalage;
    }

    public static ChaineCryptee deEnClair(String chaine, int decalage) {
        return new ChaineCryptee(chaine, decalage);
    }

    public String crypte() {
        String resultat = "";

        for (int i = 0; i < chaine.length(); i++) {
            char caractere = chaine.charAt(i);

            if (caractere >= 'A' && caractere <= 'Z') {
                caractere = (char) ((Math.floorMod(
                        caractere - 'A' + decalage, 26)) + 'A');            }

            resultat += caractere;
        }

        return resultat;
    }
}