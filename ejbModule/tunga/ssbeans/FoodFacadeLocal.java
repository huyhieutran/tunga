/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tunga.ssbeans;

import java.util.List;
import javax.ejb.Local;
import tunga.entities.Food;

/**
 *
 * @author Hieu
 */
@Local
public interface FoodFacadeLocal {

    void create(Food food);

    void edit(Food food);

    void remove(Food food);

    Food find(Object id);

    List<Food> findAll();

    List<Food> findRange(int[] range);

    int count();

}
