package pl.wjug.mwarecki.jmm.nonblocking;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public final class ConcurrentArrayQueue<E> implements Queue<E> {
	private final E[] ringBuffer;
	private volatile long addedCounter = 0;
	private volatile long removedCounter = 0;

	@SuppressWarnings("unchecked")
	public ConcurrentArrayQueue(final int size) {
		ringBuffer = (E[]) new Object[size];
	}

	public boolean offer(final E e) {
		if (addedCounter - removedCounter == ringBuffer.length) {
			return false;
		}
		ringBuffer[(int) (addedCounter % ringBuffer.length)] = e;
		addedCounter++;
		return true;
	}

	public E poll() {
		if (addedCounter == removedCounter) {
			return null;
		}
		int removeIndex = (int) (removedCounter % ringBuffer.length);
		E element = ringBuffer[removeIndex];
		ringBuffer[removeIndex] = null;
		removedCounter++;
		return element;
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
