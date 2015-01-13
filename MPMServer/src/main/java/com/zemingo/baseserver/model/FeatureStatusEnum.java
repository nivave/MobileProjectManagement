package com.zemingo.baseserver.model;

public enum FeatureStatusEnum {

	FEATURE_STATUS_IN_DEFELOPMENT(1),	
	FEATURE_STATUS_IN_DESINE(2),
	FEATURE_STATUS_IN_TESTING(3),
	FEATURE_STATUS_COMPLETED(4),
	
	FEATURE_STATUS_UNDEFIDED(82);
	
	
	
	private final int value;
	
	private FeatureStatusEnum(int value) {
		this.value = value;
	}

    public int getValue() {
        return value;
    }
}
