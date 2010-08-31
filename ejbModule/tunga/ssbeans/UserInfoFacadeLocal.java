/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tunga.ssbeans;

import java.util.List;
import javax.ejb.Local;
import tunga.entities.UserInfo;

/**
 *
 * @author Hieu
 */
@Local
public interface UserInfoFacadeLocal {

    void create(UserInfo userInfo);

    void edit(UserInfo userInfo);

    void remove(UserInfo userInfo);

    UserInfo find(Object id);

    List<UserInfo> findAll();

    List<UserInfo> findRange(int[] range);

    int count();

}
