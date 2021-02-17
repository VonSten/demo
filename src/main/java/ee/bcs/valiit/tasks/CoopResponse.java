package ee.bcs.valiit.tasks;

import java.util.List;
import java.util.Map;

public class CoopResponse {
    private List<CoopProduct> data;
    private Map metaData;

    public List<CoopProduct> getData() {
        return data;
    }

    public void setData(List<CoopProduct> data) {
        this.data = data;
    }

    public Map getMetaData() {
        return metaData;
    }

    public void setMetaData(Map metaData) {
        this.metaData = metaData;
    }

    public static class CoopProduct {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
