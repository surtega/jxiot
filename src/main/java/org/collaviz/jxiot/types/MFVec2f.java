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
import java.util.Arrays;

public class MFVec2f extends AbstractList<SFVec2f> {

	float[] data;

	public MFVec2f(float[] data) {
		set(data);
	}

	public void set(float[] data) {
		if (data.length % 2 != 0)
			throw new IllegalArgumentException(
					"Data of MFVec2f needs to be multiple of 2.");
		this.data = data.clone();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractList#get(int)
	 */
	@Override
	public SFVec2f get(int index) {
		if (index >= size())
			throw new ArrayIndexOutOfBoundsException("index=" + index
					+ ", size=" + size());
		int pos = index * 2;
		return new SFVec2f(this.data[pos], this.data[pos + 1]);
	}

	public float[] getData() {
		return this.data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		return this.data.length / 2;
	}

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
		}
		result.deleteCharAt(result.length() - 1);
		return result.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof MFVec2f))
			return false;

		MFVec2f that = (MFVec2f) obj;
		return Arrays.equals(that.data, this.data);
	}
}
