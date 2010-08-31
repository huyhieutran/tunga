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
import tunga.entities.RoomType;

/**
 *
 * @author Hieu
 */
@Stateless
public class RoomTypeFacade implements RoomTypeFacadeLocal, RoomTypeFacadeRemote {
    @PersistenceContext(unitName = "TUNGAPU")
    private EntityManager em;

    public void create(RoomType roomType) {
        em.persist(roomType);
    }

    public void edit(RoomType roomType) {
        em.merge(roomType);
    }

    public void remove(RoomType roomType) {
        em.remove(em.merge(roomType));
    }

    public RoomType find(Object id) {
        return em.find(RoomType.class, id);
    }

    public List<RoomType> findAll() {
        return em.createQuery("select object(o) from RoomType as o").getResultList();
    }

    public List<RoomType> findRange(int[] range) {
        Query q = em.createQuery("select object(o) from RoomType as o");
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        return ((Long) em.createQuery("select count(o) from RoomType as o").getSingleResult()).intValue();
    }

}
