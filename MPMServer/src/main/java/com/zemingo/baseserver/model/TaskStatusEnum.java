package com.zemingo.baseserver.model;

public enum TaskStatusEnum {

	TASK_STATUS_ASSIGN(1),
	TASK_STATUS_IN_PROGRESS(2),	
	TASK_STATUS_COMPLETED(3),
	
	TASK_STATUS_UNDEFIDED(82);
	

	
	private final int value;
	
	private TaskStatusEnum(int value) {
		this.value = value;
	}

    public int getValue() {
        return value;
    }
}
