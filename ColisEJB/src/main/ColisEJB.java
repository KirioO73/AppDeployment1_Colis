package main;

import main.colis.Colis;
import main.localisation.Localisation;
import main.suivi.ColisEtat;
import main.suivi.Suivi;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Stateless
@LocalBean
public class ColisEJB {
    @PersistenceContext
    private EntityManager entityManager;

    public ColisEJB() {
    }

    public Colis addColis(float poids, float prix, Localisation origine, Localisation destination, Suivi suivi){
        Colis colis = new Colis(poids,  prix,  origine,  destination, suivi);
        entityManager.persist(colis);
        return colis;
    }

    public Colis addColis(float poids, float prix){
        Colis colis = new Colis(poids,  prix);
        entityManager.persist(colis);
        return colis;
    }

    public Colis findColis(long id){
        return entityManager.find(Colis.class, id);
    }

    public Collection<Colis> findAllColis(){
        Query query = entityManager.createQuery("SELECT c FROM Colis c");
        return (Collection<Colis>)query.getResultList();
    }


    public Suivi addSuivi(Localisation origine){
        Suivi suivi = new Suivi(origine);
        entityManager.persist(suivi);
        return suivi;
    }

    public Suivi findSuivi(long id){
        return entityManager.find(Suivi.class, id);
    }


    public Suivi alterStateSuivi(long suiviId, ColisEtat newState){
        Suivi suivi = findSuivi(suiviId);
        suivi.setEtat(newState);
        entityManager.persist(suivi);
        return suivi;
    }

    public Localisation addLocalisation(float longitude, float lattitude, String emplacement){
        Localisation localisation;
        try{
            Query query = entityManager.createQuery("SELECT c FROM Localisation c WHERE c.emplacement = '"
                    + emplacement + "' AND c.lattitude = '"
                    + lattitude + "' AND c.longitude= '" + longitude +"' ");
            localisation = (Localisation) query.getSingleResult();
        }catch (NoResultException e){
            localisation = new Localisation(longitude, lattitude,  emplacement);
            entityManager.persist(localisation);
        }
        return localisation;
    }

    public Localisation findLocalisation(long id){
        return entityManager.find(Localisation.class, id);
    }


}
