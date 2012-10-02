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

public class SFVec2d {
	/**
	 * The x coordinate.
	 */
	public double x;

	/**
	 * The y coordinate.
	 */
	public double y;

	/**
	 * Constructs and initializes a SFVec2d from the specified xy coordinates.
	 * 
	 * @param x
	 *            the x coordinate
	 * @param y
	 *            the y coordinate
	 */
	public SFVec2d(double x, double y) {
		set(x, y);
	}

	/**
	 * Constructs and initializes a SFVec2d from the specified array.
	 * 
	 * @param t
	 *            the array of length 2 containing xy in order
	 */
	public SFVec2d(double t[]) {
		set(t);
	}

	/**
	 * Sets the value of this tuple from the 2 values specified in the array.
	 * 
	 * @param t
	 *            the array of length 2 containing xy in order
	 * @throws ArrayIndexOutOfBounds
	 *             is thrown if t.length < 2
	 */
	public final void set(double t[]) {
		this.x = t[0];
		this.y = t[1];
	}

	/**
	 * Sets the value of this vector to the specified xy coordinates.
	 * 
	 * @param x
	 *            the x coordinate
	 * @param y
	 *            the y coordinate
	 */
	public final void set(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.x + " " + this.y;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof SFVec2d))
			return false;

		SFVec2d that = (SFVec2d) obj;
		return this.x == that.x && this.y == that.y;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return (int) (Double.doubleToLongBits(this.x) ^ Double
				.doubleToLongBits(this.y));
	}
}
