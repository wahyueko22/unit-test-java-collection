package com.map;

public class MockHashMap<K,V> {
	transient Object[] table = new Object[1000];
	
	static class NodeHash<K,V>{
		private NodeHash<K,V> prev;
		private NodeHash<K,V> next;
		private V value;
		private K key;
		private int hash;
		
		public NodeHash(NodeHash<K,V> prev, NodeHash<K,V> next , V value, K key, int hash ) {
			this.prev = prev;
			this.next = next;
			this.value = value;
			this.key = key;
			this.hash = hash;
		}

		public NodeHash<K, V> getPrev() {
			return prev;
		}

		public NodeHash<K, V> getNext() {
			return next;
		}

		public V getValue() {
			return value;
		}

		public K getKey() {
			return key;
		}

		public int getHash() {
			return hash;
		}

		public void setPrev(NodeHash<K, V> prev) {
			this.prev = prev;
		}

		public void setNext(NodeHash<K, V> next) {
			this.next = next;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public void setHash(int hash) {
			this.hash = hash;
		}	
		
	}
	
	public V put(K key, V value) {
		int hash = hashKey(key) & 1000;
		System.out.println("put hash = " + hash);
		if(table[hash] != null) {
			NodeHash<K,V> nodes = (NodeHash<K, V>) table[hash];
			NodeHash<K,V> nextNode = nodes;
			boolean lopping = true;
			while (lopping) {
				//nextNode.getNext() for not null
				if(nextNode.getNext() != null) {
					//check the key is equal or not
					if(key.equals(nextNode.getKey())) {
						//replace the value
						nextNode.setValue(value);
						break;
					}
					//if key not equal execute the code below
					nextNode = nextNode.getNext();	
				}else {
					//check the key is equal or not
					if(key.equals(nextNode.getKey())) {
						//replace the value
						nextNode.setValue(value);
						break;
					}
					//add new NodeHash object to array table[hash]
					NodeHash<K,V> newNode1 = new NodeHash(nextNode, null, value, key, hash);
					nextNode.setNext(newNode1);
					lopping = false;
				}
			}
		
		}else {
			//add new NodeHash object to array table[hash]
			NodeHash<K,V> newNode = new NodeHash(null, null, value, key, hash);
			table[hash] = newNode;
		}
		return null;
	}
	
	public V get(K key) {
		int hash = hashKey(key) & 1000;
		System.out.println("get hash = " + hash);
		if(table[hash] != null) {
			NodeHash<K,V> nodes = (NodeHash<K, V>) table[hash];
			NodeHash<K,V> nextNode = nodes;
			boolean lopping = true;
			while (lopping) {
				//lopping until  null
				if(nextNode.getNext() != null) {
					if(key.equals(nextNode.getKey())) {
						return nextNode.getValue();
					}
					nextNode = nextNode.getNext();	
				}else {
					if(key.equals(nextNode.getKey())) {
						return nextNode.getValue();
					}
					return null;
				}
			}
		}
		return null;
	}
	
	static final int hashKey(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}
	
	public static void main(String[] arg) {
		MockHashMap<String, String> testMapa = new MockHashMap<String, String>();
		testMapa.put("satu", "jakarta");
		testMapa.put("satu", "jepara");
		System.out.println(testMapa.get("satu"));
	}
	
}
