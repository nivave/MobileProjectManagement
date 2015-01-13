package com.zemingo.baseserver.model;

public enum AccessRightsEnum {
	ACCESS_RIGHTS_ADMIN(1),
	ACCESS_RIGHTS_MANAGER(2),	
	ACCESS_RIGHTS_VIEWER(3),
	ACCESS_RIGHTS_CONTRIBUTER(4),
	
	ACCESS_RIGHTS_UNDEFIDED(82);
	
	private final int value;
	
	private AccessRightsEnum(int value) {
		this.value = value;
	}

    public int getValue() {
        return value;
    }
}
