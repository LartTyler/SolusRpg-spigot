package me.dbstudios.solusrpg.configuration;

import java.util.HashMap;
import java.util.Map;

public class Metadata<K> {
	private final Map<K, Object> data = new HashMap<>();

	public boolean has(K key) {
		return this.data.containsKey(key);
	}

	public <T> boolean hasOfType(K key, Class<T> type) {
		return this.has(key) && type.isInstance(this.get(key));
	}

	public Object get(K key) {
		return this.get(key, null);
	}

	public Object get(K key, Object def) {
		if (this.has(key))
			return this.get(key);

		return def;
	}

	public <T> T getAsType(K key, Class<T> type) {
		return this.getAsType(key, type, null);
	}

	public <T> T getAsType(K key, Class<T> type, T def) {
		if (this.hasOfType(key, type))
			return type.cast(this.get(key));

		return def;
	}

	public Metadata<K> set(K key, Object value) {
		this.data.put(key, value);

		return this;
	}

	public Metadata<K> remove(K key) {
		this.data.remove(key);

		return this;
	}

	public Metadata<K> clear() {
		this.data.clear();

		return this;
	}

	public Set<K> keySet() {
		return this.data.keySet();
	}

	public boolean isEmpty() {
		return this.data.isEmpty();
	}
}