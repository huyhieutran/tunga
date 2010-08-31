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
import tunga.entities.Menu;

/**
 *
 * @author Hieu
 */
@Stateless
public class MenuFacade implements MenuFacadeLocal, MenuFacadeRemote {
    @PersistenceContext(unitName = "TUNGAPU")
    private EntityManager em;

    public void create(Menu menu) {
        em.persist(menu);
    }

    public void edit(Menu menu) {
        em.merge(menu);
    }

    public void remove(Menu menu) {
        em.remove(em.merge(menu));
    }

    public Menu find(Object id) {
        return em.find(Menu.class, id);
    }

    public List<Menu> findAll() {
        return em.createQuery("select object(o) from Menu as o").getResultList();
    }

    public List<Menu> findRange(int[] range) {
        Query q = em.createQuery("select object(o) from Menu as o");
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        return ((Long) em.createQuery("select count(o) from Menu as o").getSingleResult()).intValue();
    }

}
