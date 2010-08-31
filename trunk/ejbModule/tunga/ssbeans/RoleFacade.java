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
import tunga.entities.Role;

/**
 *
 * @author Hieu
 */
@Stateless
public class RoleFacade implements RoleFacadeLocal, RoleFacadeRemote {
    @PersistenceContext(unitName = "TUNGAPU")
    private EntityManager em;

    public void create(Role role) {
        em.persist(role);
    }

    public void edit(Role role) {
        em.merge(role);
    }

    public void remove(Role role) {
        em.remove(em.merge(role));
    }

    public Role find(Object id) {
        return em.find(Role.class, id);
    }

    public List<Role> findAll() {
        return em.createQuery("select object(o) from Role as o").getResultList();
    }

    public List<Role> findRange(int[] range) {
        Query q = em.createQuery("select object(o) from Role as o");
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        return ((Long) em.createQuery("select count(o) from Role as o").getSingleResult()).intValue();
    }

}
