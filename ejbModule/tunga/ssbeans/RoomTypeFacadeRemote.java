/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tunga.ssbeans;

import java.util.List;
import javax.ejb.Remote;
import tunga.entities.RoomType;

/**
 *
 * @author Hieu
 */
@Remote
public interface RoomTypeFacadeRemote {

    void create(RoomType roomType);

    void edit(RoomType roomType);

    void remove(RoomType roomType);

    RoomType find(Object id);

    List<RoomType> findAll();

    List<RoomType> findRange(int[] range);

    int count();

}
