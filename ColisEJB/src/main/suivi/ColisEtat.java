package main.suivi;

public enum ColisEtat {
    ENREGISTRE("ENREGISTRE"),
    PREPARE("PREPARE"),
    EXPEDIE("EXPEDIE"),
    POINT_RELAI("POINT RELAI"),
    EN_LIVRAISON("EN LIVRAISON"),
    LIVRE("LIVRE");

    private String etat;

    ColisEtat(String etat) {
        this.etat = etat;
    }

    public String toString() {
        return etat;
    }

}
