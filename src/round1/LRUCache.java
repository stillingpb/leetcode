package round1;

public class LRUCache {
	public static void main(String[] args) {
		LRUCache l = new LRUCache(3);
		int page[] = { 4, 3, 4, 2, 3, 1 };
		for (int i = 0; i < page.length; i++) {
			l.set(page[i], i);
			System.out.println(l);
		}

		int p2[] = { 1, 2, 4, 3 };
		for (int i = 0; i < p2.length; i++) {
			l.get(p2[i]);
			System.out.println(l);
		}
	}

	private int capacity;
	private int pos;
	private int[] cacheKey;
	private int[] cacheValue;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.pos = 0;
		cacheKey = new int[capacity];
		cacheValue = new int[capacity];
	}

	public int get(int key) {
		int valPos = getPos(key);
		if (valPos == -1)
			return -1;
		int value = cacheValue[valPos];
		adjustCache(valPos, key, value);
		return value;
	}

	public void set(int key, int value) {
		int valPos = getPos(key);
		if (pos < capacity) {
			if (valPos != -1)
				adjustCache(valPos, key, value);
			else {
				cacheKey[pos] = key;
				cacheValue[pos] = value;
				pos++;
			}
		} else
			adjustCache(valPos == -1 ? 0 : valPos, key, value);
	}

	private int getPos(int key) {
		for (int i = 0; i < pos; i++)
			if (cacheKey[i] == key)
				return i;
		return -1;
	}

	private void adjustCache(int valPos, int key, int value) {
		for (int i = valPos; i < pos - 1; i++) {
			cacheKey[i] = cacheKey[i + 1];
			cacheValue[i] = cacheValue[i + 1];
		}
		cacheKey[pos - 1] = key;
		cacheValue[pos - 1] = value;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < pos; i++)
			sb.append(" ").append(cacheKey[i]);
		return sb.toString();
	}
}
