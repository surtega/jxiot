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

public class SFColor {

	/**
	 * The red component
	 */
	public float r;

	/**
	 * The green component
	 */
	public float g;

	/**
	 * The blue component
	 */
	public float b;

	/**
	 * Constructs and initializes a SFColor to (0,0,0).
	 */
	public SFColor() {
		set(0.0f, 0.0f, 0.0f);
	}

	/**
	 * Constructs and initializes a SFColor from the specified r, g, b
	 * 
	 * @param r
	 *            The red component
	 * @param g
	 *            The green component
	 * @param b
	 *            The blue component
	 */
	public SFColor(float r, float g, float b) {
		set(r, g, b);
	}

	/**
	 * Constructs and initializes a SFColor from the components contained in the
	 * array
	 * 
	 * @param f
	 *            the array of length 3 containing r,g,b in order
	 */
	public SFColor(float[] f) {
		set(f);
	}

	/**
	 * Sets the value of this SFColor from the 4 values specified in the array
	 * 
	 * @param f
	 *            the array of length 4 containing r,g,b,a in order
	 * @throws ArrayIndexOutOfBounds
	 *             is thrown if f.length < 4
	 */
	public void set(float[] f) {
		this.r = f[0];
		this.g = f[1];
		this.b = f[2];
	}

	/**
	 * Sets the value of this SFColor to the specified r,g,b.
	 * 
	 * @param r
	 *            The red component
	 * @param g
	 *            The green component
	 * @param b
	 *            The blue component
	 */
	public void set(float r, float g, float b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	@Override
	public String toString() {
		return this.r + " " + this.g + " " + this.b;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof SFColor))
			return false;

		SFColor that = (SFColor) obj;
		return this.r == that.r && this.g == that.g && this.b == that.b;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Float.floatToIntBits(this.r) ^ Float.floatToIntBits(this.g)
				^ Float.floatToIntBits(this.b);
	}
}
