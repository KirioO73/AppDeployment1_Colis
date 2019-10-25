package main.colis;

import main.localisation.Localisation;
import main.suivi.Suivi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class Colis implements Serializable {
    @Id @GeneratedValue
    private long id;
    private float poids;
    private float prix;
    @OneToOne
    private Localisation origine;
    @OneToOne
    private Localisation destination;
    @OneToOne
    private Suivi suivi;

    public Colis() {
    }

    public Colis(float poids, float prix) {
        this.poids = poids;
        this.prix = prix;
    }

    public Colis(float poids, float prix, Localisation origine, Localisation destination) {
        this.poids = poids;
        this.prix = prix;
        this.origine = origine;
        this.destination = destination;
    }

    public Colis(float poids, float prix, Localisation origine, Localisation destination, Suivi suivi) {
        this.poids = poids;
        this.prix = prix;
        this.origine = origine;
        this.destination = destination;
        this.suivi = suivi;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Suivi getSuivi() {
        return suivi;
    }

    public void setSuivi(Suivi suivi) {
        this.suivi = suivi;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Localisation getOrigine() {
        return origine;
    }

    public void setOrigine(Localisation origine) {
        this.origine = origine;
    }

    public Localisation getDestination() {
        return destination;
    }

    public void setDestination(Localisation destination) {
        this.destination = destination;
    }
}
