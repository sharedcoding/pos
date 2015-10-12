package com.ims.infra;

import java.util.HashMap;

public class Intent {

	private int actId = 0;
	private HashMap<String, Object> map;

	public Intent() {
		this(0);
	}

	public Intent(int actId) {
		this(actId, new HashMap<String, Object>());
	}

	private Intent(int actId, HashMap<String, Object> map) {
		this.actId = actId;
		this.map = map;
	}

	public void putExtra(String key, Object value) {
		map.put(key, value);
	}

	public Object getExtra(String key) {
		return map.get(key);
	}

	public int getActId() {
		return actId;
	}

	public Intent getIntent(int actId) {
		return new Intent(actId, map);
	}

}
