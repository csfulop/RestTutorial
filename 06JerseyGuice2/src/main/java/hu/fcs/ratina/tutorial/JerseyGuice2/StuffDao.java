
package hu.fcs.ratina.tutorial.JerseyGuice2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StuffDao implements Dao<String> {

    private Map<String, String> stuffs = new HashMap<>();

    public StuffDao() {
        stuffs.put("1", "Viola");
        stuffs.put("2", "Zita");
    }

    @Override
    public List<String> getAll() {
        return new ArrayList<>(stuffs.values());
    }

    @Override
    public String getById(String id) {
        return stuffs.get(id);
    }

}
