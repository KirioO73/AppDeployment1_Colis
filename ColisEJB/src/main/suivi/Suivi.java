package main.suivi;


import main.localisation.Localisation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class Suivi implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private ColisEtat etat;
    @OneToOne
    private Localisation localisation;

    public Suivi() {
        this.etat = ColisEtat.ENREGISTRE;
    }

    public Suivi(Localisation localisation) {
        this.etat = ColisEtat.ENREGISTRE;
        this.localisation = localisation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Localisation getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }

    public ColisEtat getEtat() {
        return etat;
    }

    public void setEtat(ColisEtat etat) {
        this.etat = etat;
    }
}
