package juke.common;

import java.io.Serializable;
import java.util.*;


public abstract class ChargingList<T> implements List<T>, Serializable
{

	protected ArrayList<T> list = new ArrayList<T>();

	@Override
	public boolean add(T e)
	{
		charge(e);
		return list.add(e);
	}

	protected abstract void charge(T element);

	protected abstract void discharge(T element);

	@Override
	public void add(int index, T element)
	{
		charge(element);
		list.add(index, element);
	}

	@Override
	public boolean addAll(Collection<? extends T> c)
	{
		for (T aC : c) charge(aC);
		return list.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c)
	{
		java.util.Iterator<? extends T> it = c.iterator();
		for (int i = 0; i < c.size(); i++)
		{
			T e = it.next();
			if (i >= index)
				charge(e);
		}

		return list.addAll(index, c);
	}

	@Override
	public void clear()
	{
		for (T aList : list) discharge(aList);
			list.clear();
	}

	@Override
	public boolean contains(Object o)
	{
		return list.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c)
	{
		return list.containsAll(c);
	}

	@Override
	public T get(int index)
	{
		return list.get(index);
	}

	@Override
	public int indexOf(Object o)
	{
		return list.indexOf(o);
	}

	@Override
	public boolean isEmpty()
	{
		return list.isEmpty();
	}

	@Override
	public java.util.Iterator<T> iterator()
	{
		return list.iterator();
	}

	@Override
	public int lastIndexOf(Object o)
	{
		return list.lastIndexOf(o);
	}

	@Override
	public ListIterator<T> listIterator()
	{
		return list.listIterator();
	}

	@Override
	public ListIterator<T> listIterator(int index)
	{
		return list.listIterator(index);
	}

	@Override
	public boolean remove(Object o)
	{
		discharge((T)o);
		return list.remove(o);
	}

	@Override
	public T remove(int index)
	{
		T e = list.remove(index);
		discharge(e);
		return e;
	}

	@Override
	public boolean removeAll(Collection<?> c)
	{
		for (Object aC : c)
		{
			discharge((T) aC);
		}
		return list.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c)
	{
		for (T e : list)
		{
			if (!c.contains(e))
				discharge(e);
		}
		return list.retainAll(c);
	}

	@Override
	public T set(int index, T element)
	{
		charge(element);
		return list.set(index, element);
	}
	@Override
	public int size()
	{
		return list.size();
	}
	@Override
	public List<T> subList(int fromIndex, int toIndex)
	{
		return list.subList(fromIndex, toIndex);
	}
	@Override
	public Object[] toArray()
	{
		return list.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a)
	{
		return list.toArray(a);
	}
}
