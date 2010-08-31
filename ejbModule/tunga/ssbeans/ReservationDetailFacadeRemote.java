/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tunga.ssbeans;

import java.util.List;
import javax.ejb.Remote;
import tunga.entities.ReservationDetail;

/**
 *
 * @author Hieu
 */
@Remote
public interface ReservationDetailFacadeRemote {

    void create(ReservationDetail reservationDetail);

    void edit(ReservationDetail reservationDetail);

    void remove(ReservationDetail reservationDetail);

    ReservationDetail find(Object id);

    List<ReservationDetail> findAll();

    List<ReservationDetail> findRange(int[] range);

    int count();

}
