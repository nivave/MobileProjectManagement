package com.zemingo.baseserver.model;

public enum PlatformEnum {
	PLATFORM_IOS(1),
	PLATFORM_ANDROID(2),	
	
	PLATFORM_UNDEFIDED(82);
	

	
	private final int value;
	
	private PlatformEnum(int value) {
		this.value = value;
	}

    public int getValue() {
        return value;
    }
}
