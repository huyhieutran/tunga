/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tunga.ssbeans;

import java.util.List;
import javax.ejb.Remote;
import tunga.entities.Room;

/**
 *
 * @author Hieu
 */
@Remote
public interface RoomFacadeRemote {

    void create(Room room);

    void edit(Room room);

    void remove(Room room);

    Room find(Object id);

    List<Room> findAll();

    List<Room> findRange(int[] range);

    int count();

}
