package com.zemingo.baseserver;

public enum ACErrorEnum {

	ERROR_JSON_KEY_IS_MISSING(1),
	ERROR_JSON_OBJECT_IS_NOT_VALID(2),
	
	ERROR_INVALID_USER_TOKEN(100),
	ERROR_INVALID_REGISTRATION_CODE(102),
	ERROR_FULL_SYSNC_REQUIRED(103),
	ERROR_CONTACT_ID_ALREADY_EXIST(104),
	ERROR_UNKOWN_ERROR(999);

	
	private final int value;
	private ACErrorEnum(int value) {
		this.value = value;
	}

    public int getValue() {
        return value;
    }


}
