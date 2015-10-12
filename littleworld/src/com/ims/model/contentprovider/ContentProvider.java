package com.ims.model.contentprovider;

public class ContentProvider {
	private static ContentResolver resolver;

	private ContentProvider(){}
	public static ContentResolver getContentResolver() {
		if (resolver == null) {
			resolver = new ContentResolver();
		}
		return resolver;
	}
}
