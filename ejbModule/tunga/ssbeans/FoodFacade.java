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
import tunga.entities.Food;

/**
 *
 * @author Hieu
 */
@Stateless
public class FoodFacade implements FoodFacadeLocal, FoodFacadeRemote {
    @PersistenceContext(unitName = "TUNGAPU")
    private EntityManager em;

    public void create(Food food) {
        em.persist(food);
    }

    public void edit(Food food) {
        em.merge(food);
    }

    public void remove(Food food) {
        em.remove(em.merge(food));
    }

    public Food find(Object id) {
        return em.find(Food.class, id);
    }

    public List<Food> findAll() {
        return em.createQuery("select object(o) from Food as o").getResultList();
    }

    public List<Food> findRange(int[] range) {
        Query q = em.createQuery("select object(o) from Food as o");
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        return ((Long) em.createQuery("select count(o) from Food as o").getSingleResult()).intValue();
    }

}
