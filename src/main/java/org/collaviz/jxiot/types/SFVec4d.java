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

public class SFVec4d {
	/**
	 * The x coordinate.
	 */
	public double x;

	/**
	 * The y coordinate.
	 */
	public double y;

	/**
	 * The z coordinate.
	 */
	public double z;

	/**
	 * The w coordinate.
	 */
	public double w;

	/**
	 * Constructs and initializes a SFVec4d from the specified xyzw coordinates.
	 * 
	 * @param x
	 *            the x coordinate
	 * @param y
	 *            the y coordinate
	 * @param z
	 *            the z coordinate
	 * @param w
	 *            the w coordinate
	 */
	public SFVec4d(double x, double y, double z, double w) {
		set(x, y, z, w);
	}

	/**
	 * Constructs and initializes a SFVec4d from the specified array.
	 * 
	 * @param t
	 *            the array of length 4 containing xyzw in order
	 */
	public SFVec4d(double t[]) {
		set(t);
	}

	/**
	 * Sets the value of this tuple from the 4 values specified in the array.
	 * 
	 * @param t
	 *            the array of length 4 containing xyzw in order
	 * @throws ArrayIndexOutOfBounds
	 *             is thrown if t.length < 4
	 */
	public final void set(double t[]) {
		this.x = t[0];
		this.y = t[1];
		this.z = t[2];
		this.w = t[3];
	}

	/**
	 * Sets the value of this vector to the specified xyzw coordinates.
	 * 
	 * @param x
	 *            the x coordinate
	 * @param y
	 *            the y coordinate
	 * @param z
	 *            the z coordinate
	 * @param w
	 *            the w coordinate
	 */
	public final void set(double x, double y, double z, double w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.x + " " + this.y + " " + this.z + " " + this.w;
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
		if (!(obj instanceof SFVec4d))
			return false;

		SFVec4d that = (SFVec4d) obj;
		return this.x == that.x && this.y == that.y && this.z == that.z
				&& this.w == that.w;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return (int) (Double.doubleToLongBits(this.x)
				^ Double.doubleToLongBits(this.y)
				^ Double.doubleToLongBits(this.z) ^ Double
				.doubleToLongBits(this.w));
	}
}
