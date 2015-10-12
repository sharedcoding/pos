package com.ims.infra;

public class ActivityManager {

	private static ActivityManager instance;
	private Activity currentActivity;

	private ActivityManager() {
	}

	public static ActivityManager getInstance() {
		if (instance == null) {
			instance = new ActivityManager();
		}
		return instance;
	}

	public Activity getCurrentActivity() {
		return currentActivity;
	}

	public void setCurrentActivity(Activity runningActivity,
			Activity newActivity) {
		if (currentActivity == runningActivity) {
			currentActivity = newActivity;
		} else {
			throw new RuntimeException();
		}

	}
}
