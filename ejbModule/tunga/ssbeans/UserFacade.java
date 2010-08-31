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
import tunga.entities.User;

/**
 *
 * @author Hieu
 */
@Stateless
public class UserFacade implements UserFacadeLocal, UserFacadeRemote {
    @PersistenceContext(unitName = "TUNGAPU")
    private EntityManager em;

    public void create(User user) {
        em.persist(user);
    }

    public void edit(User user) {
        em.merge(user);
    }

    public void remove(User user) {
        em.remove(em.merge(user));
    }

    public User find(Object id) {
        return em.find(User.class, id);
    }

    public List<User> findAll() {
        return em.createQuery("select object(o) from User as o").getResultList();
    }

    public List<User> findRange(int[] range) {
        Query q = em.createQuery("select object(o) from User as o");
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        return ((Long) em.createQuery("select count(o) from User as o").getSingleResult()).intValue();
    }

}
