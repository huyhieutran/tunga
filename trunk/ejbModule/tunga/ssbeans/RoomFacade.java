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
import tunga.entities.Room;

/**
 *
 * @author Hieu
 */
@Stateless
public class RoomFacade implements RoomFacadeLocal, RoomFacadeRemote {
    @PersistenceContext(unitName = "TUNGAPU")
    private EntityManager em;

    public void create(Room room) {
        em.persist(room);
    }

    public void edit(Room room) {
        em.merge(room);
    }

    public void remove(Room room) {
        em.remove(em.merge(room));
    }

    public Room find(Object id) {
        return em.find(Room.class, id);
    }

    public List<Room> findAll() {
        return em.createQuery("select object(o) from Room as o").getResultList();
    }

    public List<Room> findRange(int[] range) {
        Query q = em.createQuery("select object(o) from Room as o");
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        return ((Long) em.createQuery("select count(o) from Room as o").getSingleResult()).intValue();
    }

}
