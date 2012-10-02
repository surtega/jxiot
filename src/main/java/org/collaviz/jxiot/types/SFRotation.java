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

public class SFRotation {
	/**
	 * The x coordinate.
	 */
	public float x;

	/**
	 * The y coordinate.
	 */
	public float y;

	/**
	 * The z coordinate.
	 */
	public float z;

	/**
	 * The angle.
	 */
	public float angle;

	/**
	 * Constructs and initializes a SFRotation from the specified x, y, z, and
	 * angle.
	 * 
	 * @param x
	 *            the x coordinate
	 * @param y
	 *            the y coordinate
	 * @param z
	 *            the z coordinate
	 * @param angle
	 *            the angle.
	 */
	public SFRotation(float x, float y, float z, float angle) {
		set(x, y, z, angle);
	}

	/**
	 * Constructs and initializes a SFRotation from the components contained in
	 * the array.
	 * 
	 * @param a
	 *            the array of length 4 containing x,y,z,angle in order
	 */
	public SFRotation(float a[]) {
		set(a);
	}

	/**
	 * Constructs and initializes a SFRotation from the specified axis and
	 * angle.
	 * 
	 * @param axis
	 *            the axis
	 * @param angle
	 *            the angle
	 */
	public SFRotation(SFVec3f axis, float angle) {
		this.x = axis.x;
		this.y = axis.y;
		this.z = axis.z;
		this.angle = angle;
	}

	/**
	 * Constructs and initializes a SFRotation to (0,0,1,0).
	 */
	public SFRotation() {
		this.x = 0.0f;
		this.y = 0.0f;
		this.z = 1.0f;
		this.angle = 0.0f;
	}

	/**
	 * Sets the value of this SFRotation to the specified axis and angle.
	 * 
	 * @param axis
	 *            the axis
	 * @param angle
	 *            the angle
	 */
	public final void set(SFVec3f axis, float angle) {
		this.x = axis.x;
		this.y = axis.y;
		this.z = axis.z;
		this.angle = angle;
	}

	/**
	 * Sets the value of this rotation to the specified x,y,z,angle.
	 * 
	 * @param x
	 *            the x coordinate
	 * @param y
	 *            the y coordinate
	 * @param z
	 *            the z coordinate
	 * @param angle
	 *            the angle
	 */
	public final void set(float x, float y, float z, float angle) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.angle = angle;
	}

	/**
	 * Sets the value of this rotation from the 4 values specified in the array.
	 * 
	 * @param a
	 *            the array of length 4 containing x,y,z,angle in order
	 * @throws ArrayIndexOutOfBounds
	 *             is thrown if t.length < 4
	 */
	public final void set(float a[]) {
		this.x = a[0];
		this.y = a[1];
		this.z = a[2];
		this.angle = a[3];
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
		if (!(obj instanceof SFRotation))
			return false;

		SFRotation that = (SFRotation) obj;
		return this.x == that.x && this.y == that.y && this.z == that.z
				&& this.angle == that.angle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Float.floatToIntBits(this.x) ^ Float.floatToIntBits(this.y)
				^ Float.floatToIntBits(this.z)
				^ Float.floatToIntBits(this.angle);
	}
}
