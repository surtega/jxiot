/**
 * This file is part of the jXIOT library.
 * 
 * Copyright (c) 2010 Supporting GmbH
 * http://www.supporting.com
 * 
 * EDF R&D (http://research.edf.com/) sponsored initial development of 
 * this code in the context of the COLLAVIZ (http://www.collaviz.org/)
 * project.
 * 
 * This library is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation; either version 2.1 of the License, or 
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU 
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free
 * Software Foundation, Inc., 59 Temple Place, Suite 330, Boston,
 * MA 02111-1307, USA
 * 
 * The jXIOT's web site is located at:
 * http://forge.collaviz.org/community/jxiot
 * 
 */
package org.collaviz.jxiot.types;

import java.util.AbstractList;

public abstract class Float4Array<E> extends AbstractList<E> {

	float[] data;

	public Float4Array(float[] data) {
		set(data);
	}

	@Override
	public int size() {
		return this.data.length / 4;
	}

	public float[] getData() {
		return this.data;
	}

	public void set(float[] data) {
		if (data.length % 4 != 0)
			throw new IllegalArgumentException("Data of "
					+ getClass().getSimpleName()
					+ " needs to be multiple of 4.");
		this.data = data.clone();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractList#get(int)
	 */
	@Override
	public E get(int index) {
		if (index >= size())
			throw new ArrayIndexOutOfBoundsException("index=" + index
					+ ", size=" + size());
		int pos = index * 4;
		return createType(this.data[pos], this.data[pos + 1],
				this.data[pos + 2], this.data[pos + 3]);
	}

	protected abstract E createType(float x, float y, float z, float w);

	@Override
	public String toString() {
		if (size() == 0)
			return "";

		StringBuffer result = new StringBuffer();
		int j = 0;
		for (int i = 0; i < size(); i++) {
			result.append(this.data[j++]);
			result.append(' ');
			result.append(this.data[j++]);
			result.append(' ');
			result.append(this.data[j++]);
			result.append(' ');
			result.append(this.data[j++]);
			result.append(", ");
		}
		result.delete(result.length() - 2, result.length());
		return result.toString();
	}

}
