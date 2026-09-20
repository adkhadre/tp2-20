package fr.uvsq.saclay.m1.info;

public class ChaineCryptee {
    private static final org.slf4j.Logger LOGGER =
            org.slf4j.LoggerFactory.getLogger(ChaineCryptee.class);

    private String chaineCryptee;
    private int decalage;

    private ChaineCryptee(String chaine, int decalage) {
        if (chaine == null) {
            throw new IllegalArgumentException("La chaîne ne peut pas être null");
        }

        this.chaineCryptee = chaine;
        this.decalage = decalage;
    }

    public static ChaineCryptee deEnClair(String chaine, int decalage) {
        if (chaine == null) {
            throw new IllegalArgumentException("La chaîne ne peut pas être null");
        }

        return new ChaineCryptee(
                transforme(chaine, decalage),
                decalage);
    }
    private static char decaleCaractere(char c, int decalage) {
        if (c < 'A' || c > 'Z') {
            return c;
        }
        return (char) (Math.floorMod(c - 'A' + decalage, 26) + 'A');
    }
    private static String transforme(String chaine, int decalage){
        StringBuilder resultat = new StringBuilder();
        for (int i = 0; i < chaine.length(); i++) {
            char caractere = chaine.charAt(i);
            resultat.append(decaleCaractere(caractere, decalage));
        }
        return resultat.toString();
    }
    public String crypte() {
        return chaineCryptee;
    }

    public static ChaineCryptee deCryptee(String chaine, int decalage) {
        return new ChaineCryptee(chaine, decalage);
    }
    public String decrypte() {
        return transforme(chaineCryptee, -decalage);
    }
    public static void main(String[] args) {
        ChaineCryptee chaine = ChaineCryptee.deEnClair("BONJOUR", 3);
        ChaineCryptee message = ChaineCryptee.deEnClair("CE PROJET EST VRAIMENT TRES INTERESSANT", -9);

        LOGGER.info("Chaîne cryptée : {}", chaine.crypte());
        LOGGER.info("Chaîne décryptée : {}", chaine.decrypte());

        LOGGER.info("Chaîne cryptée : {}", message.crypte());
        LOGGER.info("Chaîne décryptée : {}", message.decrypte());
    }



}