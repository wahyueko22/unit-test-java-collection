package com.arraylist;

public class MockArrayList<E> {
	transient Object[] elementData;
	private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
	private int index;
	private int defaultIncrement = 10;

	public MockArrayList() {
		this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
	}

	public void add(E item) {
		ensureExplicitCapacity();
		elementData[index++] = item;
	}

	private void ensureExplicitCapacity() {
		if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
			Object[] tempData = new Object[defaultIncrement];
			elementData = tempData;
		} else if (elementData.length <= index) {
			int newIncrement = index + (index >> 1);
			System.out.println("old index = "+ index + " ||  newIncrement = " + newIncrement);
			Object[] tempData = new Object[newIncrement];
			for (int i = 0; i < elementData.length; i++) {
				tempData[i] = elementData[i];
			}
			elementData = tempData;
		}
	}

	public void remove(E item) {
		for (int i = 0; i < elementData.length; i++) {
			if (elementData[i] == item) {
				// shifting elements
				for (int j = i; j < elementData.length - 1; j++) {
					elementData[j] = elementData[j + 1];
				}
				this.index--;
				break;
			}
		}
	}
	
	public E getItem(int idx) {
		E val=null;
		this.checkIndex(idx);
		for(int i=0; i<this.index; i++) {
			if(idx == i)
				val = (E) this.elementData[idx];
		}
		return val;
	}
	
	private void checkIndex(int idx) {
		if(idx >= this.index)
			throw new IndexOutOfBoundsException("array index of bound");
	}

	public boolean contain(E item) {
		boolean bol = Boolean.FALSE;
		for (Object str : elementData) {
			if (item.equals(str)) {
				return Boolean.TRUE;
			}
		}
		return bol;
	}
	
	public int getSize() {
		return this.index;
	}

}
