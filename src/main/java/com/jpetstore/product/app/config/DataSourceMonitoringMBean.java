package com.jpetstore.product.app.config;

public interface DataSourceMonitoringMBean {
	int getnumActive();

	int getnumIdle();

	int getmaxTotal();
}