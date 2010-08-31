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
import tunga.entities.UserInfo;

/**
 *
 * @author Hieu
 */
@Stateless
public class UserInfoFacade implements UserInfoFacadeLocal, UserInfoFacadeRemote {
    @PersistenceContext(unitName = "TUNGAPU")
    private EntityManager em;

    public void create(UserInfo userInfo) {
        em.persist(userInfo);
    }

    public void edit(UserInfo userInfo) {
        em.merge(userInfo);
    }

    public void remove(UserInfo userInfo) {
        em.remove(em.merge(userInfo));
    }

    public UserInfo find(Object id) {
        return em.find(UserInfo.class, id);
    }

    public List<UserInfo> findAll() {
        return em.createQuery("select object(o) from UserInfo as o").getResultList();
    }

    public List<UserInfo> findRange(int[] range) {
        Query q = em.createQuery("select object(o) from UserInfo as o");
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        return ((Long) em.createQuery("select count(o) from UserInfo as o").getSingleResult()).intValue();
    }

}
