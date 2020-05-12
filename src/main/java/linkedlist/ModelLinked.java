package linkedlist;

public class ModelLinked<E> {
	E item;
	ModelLinked<E> prev;
	ModelLinked<E> next;
		
	public ModelLinked(E item, ModelLinked<E> prev, ModelLinked<E> next) {
		super();
		this.item = item;
		this.prev = prev;
		this.next = next;
	}
	
	public E getItem() {
		return item;
	}
	public void setItem(E item) {
		this.item = item;
	}
	public ModelLinked<E> getPrev() {
		return prev;
	}
	public void setPrev(ModelLinked<E> prev) {
		this.prev = prev;
	}
	public ModelLinked<E> getNext() {
		return next;
	}
	public void setNext(ModelLinked<E> next) {
		this.next = next;
	}
	
	
}
