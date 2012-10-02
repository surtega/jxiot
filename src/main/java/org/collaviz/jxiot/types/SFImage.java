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

import java.util.Arrays;


public class SFImage {
	
	/**
	 * The pixel data of the image
	 */
	int data[];

	/**
	 * Constructs and initializes an empty SFImage
	 */
	public SFImage() {
		this.data = null;
	}

	/**
	 * Constructs and initializes a SFImage from the specified values. If
	 * data.length < width*height*components the pixel data will be filled with
	 * padding 0 until it has the proper size
	 */
	public SFImage(int width, int height, int components, int[] d) {
		this.data = new int[width*height+3];
		this.data[0] = width;
		this.data[1] = height;
		this.data[2] = components;
		System.arraycopy(d, 0, this.data, 3, width*height);
	}

	/**
	 * Constructs and initializes a SFImage from the specified array.
	 * 
	 * @param d
	 *            The data to initialize the SFImage from. Assumes that d[0] is
	 *            the width, d[1] the height and d[2] the number of components.
	 *            If the remaining size of this array is smaller than the
	 *            required amount, the of pixel data will be filled with padding
	 *            0 until it has the proper size
	 */
	public SFImage(int[] d) {
		set(d, 0);
	}

	/**
	 * Constructs and initializes a SFVec3f from the specified array.
	 * 
	 * @param d
	 *            The data to initialize the SFImage from. Assumes that
	 *            d[offset] is the width, d[offset+1] the height and d[offset+2]
	 *            the number of components. If the remaining size of this array
	 *            is smaller than the required amount, the of pixel data will be
	 *            filled with padding 0 until it has the proper size
	 */
	public SFImage(int[] d, int offset) {
		set(d, offset);
	}

	private void set(int[] d, int offset) {
		this.data = new int[d[offset]*d[offset + 1]+3]; 
		System.arraycopy(d, offset, this.data, 0, this.data.length);
	}

	@Override
	public String toString() 
	{
		StringBuffer result = new StringBuffer();
		result.append(getWidth());
		result.append(' ');
		result.append(getHeight());
		result.append(' ');
		result.append(getNumberOfComponents());
		result.append(' ');
		int length = getWidth() * getHeight();
		for (int i = 0; i < length; i++) {
			result.append(String.format("%#08x", this.data[i+3]));
			result.append(' ');
		}
		return result.toString();
	}
	
	public int getWidth() {
		return this.data == null ? 0 : this.data[0];
	}

	public int getHeight() {
		return this.data == null ? 0 : this.data[1];
	}

	public int getNumberOfComponents() {
		return this.data == null ? 0 : this.data[2];
	}

	@Override
	public boolean equals(final Object obj) 
	{
		if (this == obj)
			return true;
		if (!(obj instanceof SFImage))
			return false;

		final SFImage that = (SFImage) obj;
		return Arrays.equals(that.data, this.data);
	}
	
	@Override
	public int hashCode()
	{
		/*
		 * Implemented according to the recommendation in
		 * Effective Java, Second Edition, Joshua Bloch, P. 48
		 */
		int result = 17;
		result = ((result << 5) - result) + this.getWidth();
		result = ((result << 5) - result) + this.getHeight();
		result = ((result << 5) - result) + this.getNumberOfComponents();
		
		return result;
	}
}