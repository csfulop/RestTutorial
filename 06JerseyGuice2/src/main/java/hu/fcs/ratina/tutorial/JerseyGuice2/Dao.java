
package hu.fcs.ratina.tutorial.JerseyGuice2;

import java.util.List;

public interface Dao<T> {

    List<? extends T> getAll();

    T getById(String id);

}
