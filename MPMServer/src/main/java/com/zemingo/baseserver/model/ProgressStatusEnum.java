package com.zemingo.baseserver.model;

public enum ProgressStatusEnum {
	
	PROGRESS_STATUS_YELLO(1),	
	PROGRESS_STATUS_GREEN(2),
	PROGRESS_STATUS_RED(3),
	
	PROGRESS_STATUS_UNDEFINED(82);
	
	
	
	private final int value;
	
	private ProgressStatusEnum(int value) {
		this.value = value;
	}

    public int getValue() {
        return value;
    }
}
