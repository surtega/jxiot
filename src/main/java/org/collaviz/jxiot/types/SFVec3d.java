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

public class SFVec3d {
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

	public SFVec3d() {
		set(0.0, 0.0, 0.0);
	}

	/**
	 * Constructs and initializes a SFVec3d from the specified xyz coordinates.
	 * 
	 * @param x
	 *            the x coordinate
	 * @param y
	 *            the y coordinate
	 * @param z
	 *            the z coordinate
	 */
	public SFVec3d(double x, double y, double z) {
		set(x, y, z);
	}

	/**
	 * Constructs and initializes a SFVec3d from the specified array.
	 * 
	 * @param t
	 *            the array of length 3 containing xyz in order
	 */
	public SFVec3d(double t[]) {
		set(t);
	}

	/**
	 * Sets the value of this tuple from the 3 values specified in the array.
	 * 
	 * @param t
	 *            the array of length 3 containing xyz in order
	 * @throws ArrayIndexOutOfBounds
	 *             is thrown if t.length < 3
	 */
	public final void set(double t[]) {
		this.x = t[0];
		this.y = t[1];
		this.z = t[2];
	}

	/**
	 * Sets the value of this vector to the specified xyz coordinates.
	 * 
	 * @param x
	 *            the x coordinate
	 * @param y
	 *            the y coordinate
	 * @param z
	 *            the z coordinate
	 */
	public final void set(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.x + " " + this.y + " " + this.z;
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
		if (!(obj instanceof SFVec3d))
			return false;

		SFVec3d that = (SFVec3d) obj;
		return this.x == that.x && this.y == that.y && this.z == that.z;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return (int) (Double.doubleToLongBits(this.x)
				^ Double.doubleToLongBits(this.y) ^ Double
				.doubleToLongBits(this.z));
	}
}
