/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tunga.ssbeans;

import java.util.List;
import javax.ejb.Local;
import tunga.entities.TableType;

/**
 *
 * @author Hieu
 */
@Local
public interface TableTypeFacadeLocal {

    void create(TableType tableType);

    void edit(TableType tableType);

    void remove(TableType tableType);

    TableType find(Object id);

    List<TableType> findAll();

    List<TableType> findRange(int[] range);

    int count();

}
