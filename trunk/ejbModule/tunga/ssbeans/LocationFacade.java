/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tunga.ssbeans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import tunga.entities.Location;

/**
 *
 * @author Hieu
 */
@Stateless
public class LocationFacade implements LocationFacadeLocal, LocationFacadeRemote {
    @PersistenceContext(unitName = "TUNGAPU")
    private EntityManager em;

    public void create(Location location) {
        em.persist(location);
    }

    public void edit(Location location) {
        em.merge(location);
    }

    public void remove(Location location) {
        em.remove(em.merge(location));
    }

    public Location find(Object id) {
        return em.find(Location.class, id);
    }

    public List<Location> findAll() {
        return em.createQuery("select object(o) from Location as o").getResultList();
    }

    public List<Location> findRange(int[] range) {
        Query q = em.createQuery("select object(o) from Location as o");
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        return ((Long) em.createQuery("select count(o) from Location as o").getSingleResult()).intValue();
    }

}
