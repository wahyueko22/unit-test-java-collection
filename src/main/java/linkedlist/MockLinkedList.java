package linkedlist;

public class MockLinkedList<E> {
	private ModelLinked<E> firstValue;
	private ModelLinked<E> lastValue;
	private int size;

	public void add(E item) {
		ModelLinked<E> last = lastValue;
		ModelLinked<E> newData = new ModelLinked<E>(item, last, null);
		lastValue = newData;
		if (last == null) {
			firstValue = newData;
		} else {
			lastValue.setNext(newData);
		}
		size++;
	}

	public E get(int index) {
		checkElementSize(index);
		return node(index).item;
	}
	
	ModelLinked<E> node(int index) {
        if (index < (size >> 1)) {
        	ModelLinked<E> x = firstValue;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
        	ModelLinked<E> x = lastValue;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

	private void checkElementSize(int index) {
		if (!(index >= 0 && index < size)) {
			throw new IndexOutOfBoundsException("eeroor");
		}
	}

	public static void main(String[] args) {
		//
		MockLinkedList<String> test = new MockLinkedList<String>();
		test.add("1");
		test.add("2");

		System.out.println(test.get(3));
	}
}
