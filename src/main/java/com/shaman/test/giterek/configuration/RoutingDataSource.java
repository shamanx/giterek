package com.shaman.test.giterek.configuration;


import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class RoutingDataSource extends AbstractRoutingDataSource {
	
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContext.getCurrentDB();
    }
    
    
}
