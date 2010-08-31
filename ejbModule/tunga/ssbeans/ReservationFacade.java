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
import tunga.entities.Reservation;

/**
 *
 * @author Hieu
 */
@Stateless
public class ReservationFacade implements ReservationFacadeLocal, ReservationFacadeRemote {
    @PersistenceContext(unitName = "TUNGAPU")
    private EntityManager em;

    public void create(Reservation reservation) {
        em.persist(reservation);
    }

    public void edit(Reservation reservation) {
        em.merge(reservation);
    }

    public void remove(Reservation reservation) {
        em.remove(em.merge(reservation));
    }

    public Reservation find(Object id) {
        return em.find(Reservation.class, id);
    }

    public List<Reservation> findAll() {
        return em.createQuery("select object(o) from Reservation as o").getResultList();
    }

    public List<Reservation> findRange(int[] range) {
        Query q = em.createQuery("select object(o) from Reservation as o");
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        return ((Long) em.createQuery("select count(o) from Reservation as o").getSingleResult()).intValue();
    }

}
