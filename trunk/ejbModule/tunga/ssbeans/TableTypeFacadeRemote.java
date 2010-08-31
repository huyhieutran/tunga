/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tunga.ssbeans;

import java.util.List;
import javax.ejb.Remote;
import tunga.entities.TableType;

/**
 *
 * @author Hieu
 */
@Remote
public interface TableTypeFacadeRemote {

    void create(TableType tableType);

    void edit(TableType tableType);

    void remove(TableType tableType);

    TableType find(Object id);

    List<TableType> findAll();

    List<TableType> findRange(int[] range);

    int count();

}
