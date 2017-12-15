package mycode.java;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

public class MyArrayList<T> extends AbstractList<T> implements List<T> {

	private Object[] list;
	private int size = 0;

	public MyArrayList() {
		this(10);
	}

	public MyArrayList(int initialCapacity) {
		super();
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("Illegal capacity "
					+ initialCapacity);
		}
		this.list = new Object[initialCapacity];
	}

	@Override
	public T get(int index) {
		rangeCheck(index);
		return (T) list[index];
	}

	public T set(int index, T newvalue) {
		rangeCheck(index);
		T oldvalue = (T) list[index];
		list[index] = newvalue;
		return oldvalue;
	}

	public void ensureCapacity(int minCapacity) {
		int oldCapacity = list.length;
		if (minCapacity > oldCapacity) {
			Object oldData[] = list;
			int newCapacity = (oldCapacity * 3) / 2 + 1;
			if (newCapacity < minCapacity)
				newCapacity = minCapacity;
			// minCapacity is usually close to size, so this is a win:
			list = Arrays.copyOf(list, newCapacity);
		}
	}

	public boolean add(T e) {
		ensureCapacity(size + 1);
		list[size++] = e;
		return true;
	}

	public T remove(int index) {
		rangeCheck(index);
		T oldValue = (T) list[index];
		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(list, index + 1, list, index, numMoved);
		list[--size] = null; // Let gc do its work
		return oldValue;
	}

	public boolean remove(Object o) {
		if (o == null) {
			for (int index = 0; index < size; index++)
				if (list[index] == null) {
					fastRemove(index);
					return true;
				}
		} else {
			for (int index = 0; index < size; index++)
				if (o.equals(list[index])) {
					fastRemove(index);
					return true;
				}
		}
		return false;
	}

	/*
	 * Private remove method that skips bounds checking and does not return the
	 * value removed.
	 */
	private void fastRemove(int index) {
		modCount++;
		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(list, index + 1, list, index, numMoved);
		list[--size] = null; // Let gc do its work
	}

	public int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++)
				if (list[i] == null)
					return i;
		} else {
			for (int i = 0; i < size; i++)
				if (o.equals(list[i]))
					return i;
		}
		return -1;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void rangeCheck(int index) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException("out of bounds " + index);
		}

	}

	@Override
	public int size() {
		return size;
	}

	public static void main(String[] args) {
		MyArrayList<String> sl = new MyArrayList<String>(10);
		sl.add("a");
		sl.add("b");
		sl.add("c");
		sl.add("d");
		sl.add("e");
		System.out.println(sl.toString());
		sl.remove("d");
		System.out.println(sl.toString());
	}

}
