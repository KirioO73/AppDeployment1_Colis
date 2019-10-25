package main.localisation;

import com.sun.istack.internal.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Localisation implements Serializable {
    @Id @GeneratedValue
    private long id;
    private float longitude;
    private float lattitude;
    @Nullable
    private String emplacement;

    public Localisation() {
    }

    public Localisation(float longitude, float lattitude, String emplacement) {
        if (emplacement.equals(""))
            this.emplacement = "Unknow";
        else
            this.emplacement = emplacement;
        this.longitude = longitude;
        this.lattitude = lattitude;
    }

    public Localisation(float longitude, float lattitude) {
        this.longitude = longitude;
        this.lattitude = lattitude;
        this.emplacement = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLattitude() {
        return lattitude;
    }

    public void setLattitude(float lattitude) {
        this.lattitude = lattitude;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    @Override
    public String toString() {
        return "Localisation{" +
                "id=" + id +
                ", longitude=" + longitude +
                ", lattitude=" + lattitude +
                ", emplacement='" + emplacement + '\'' +
                '}';
    }
}
