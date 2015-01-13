package com.zemingo.baseserver.model;

public enum ProjectStatusEnum {

	PROJECT_STATUS_PLANNING(1),
	PROJECT_STATUS_IN_DEVELOPMENT(2),	
	PROJECT_STATUS_FROZEN(3),
	PROJECT_STATUS_COMPLETED(4),
	
	PROJECT_STATUS_UNDEFINED(82);
	

	
	private final int value;
	
	private ProjectStatusEnum(int value) {
		this.value = value;
	}

    public int getValue() {
        return value;
    }
}
