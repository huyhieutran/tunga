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
import tunga.entities.ReservationDetail;

/**
 *
 * @author Hieu
 */
@Stateless
public class ReservationDetailFacade implements ReservationDetailFacadeLocal, ReservationDetailFacadeRemote {
    @PersistenceContext(unitName = "TUNGAPU")
    private EntityManager em;

    public void create(ReservationDetail reservationDetail) {
        em.persist(reservationDetail);
    }

    public void edit(ReservationDetail reservationDetail) {
        em.merge(reservationDetail);
    }

    public void remove(ReservationDetail reservationDetail) {
        em.remove(em.merge(reservationDetail));
    }

    public ReservationDetail find(Object id) {
        return em.find(ReservationDetail.class, id);
    }

    public List<ReservationDetail> findAll() {
        return em.createQuery("select object(o) from ReservationDetail as o").getResultList();
    }

    public List<ReservationDetail> findRange(int[] range) {
        Query q = em.createQuery("select object(o) from ReservationDetail as o");
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        return ((Long) em.createQuery("select count(o) from ReservationDetail as o").getSingleResult()).intValue();
    }

}
