package com.shaman.test.giterek.configuration;

import com.shaman.test.giterek.constants.ProductionSite;

public class DataSourceContext {

    private static ThreadLocal<ProductionSite> CURRENT_DB = new ThreadLocal<>();

    public static void setCurrentDB(ProductionSite dbId) {
        CURRENT_DB.set(dbId);
    }

    public static ProductionSite getCurrentDB() {
        return CURRENT_DB.get();
    }

}
