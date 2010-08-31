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
import tunga.entities.TableType;

/**
 *
 * @author Hieu
 */
@Stateless
public class TableTypeFacade implements TableTypeFacadeLocal, TableTypeFacadeRemote {
    @PersistenceContext(unitName = "TUNGAPU")
    private EntityManager em;

    public void create(TableType tableType) {
        em.persist(tableType);
    }

    public void edit(TableType tableType) {
        em.merge(tableType);
    }

    public void remove(TableType tableType) {
        em.remove(em.merge(tableType));
    }

    public TableType find(Object id) {
        return em.find(TableType.class, id);
    }

    public List<TableType> findAll() {
        return em.createQuery("select object(o) from TableType as o").getResultList();
    }

    public List<TableType> findRange(int[] range) {
        Query q = em.createQuery("select object(o) from TableType as o");
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        return ((Long) em.createQuery("select count(o) from TableType as o").getSingleResult()).intValue();
    }

}
