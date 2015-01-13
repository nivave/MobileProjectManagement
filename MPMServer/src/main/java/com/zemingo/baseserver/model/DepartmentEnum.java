package com.zemingo.baseserver.model;

public enum DepartmentEnum {

	DEPARTMENT_QA(1),
	DEPARTMENT_DESIGN(2),	
	DEPARTMENT_DEV(3),
	DEPARTMENT_PRODUCT(4),
	DEPARTMENT_MANAGEMENT(5),
	
	DEPARTMENT_UNDEFINDED(82);
	

	
	private final int value;
	
	private DepartmentEnum(int value) {
		this.value = value;
	}

    public int getValue() {
        return value;
    }
}
