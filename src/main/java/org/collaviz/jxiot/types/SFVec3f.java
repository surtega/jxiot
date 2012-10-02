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

public class SFVec3f {

	public final static SFVec3f ZERO = new SFVec3f(0, 0, 0);

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

	public SFVec3f() {
		set(0.0f, 0.0f, 0.0f);
	}

	/**
	 * Constructs and initializes a SFVec3f from the specified xyz coordinates.
	 * 
	 * @param x
	 *            the x coordinate
	 * @param y
	 *            the y coordinate
	 * @param z
	 *            the z coordinate
	 */
	public SFVec3f(float x, float y, float z) {
		set(x, y, z);
	}

	/**
	 * Constructs and initializes a SFVec3f from the specified array.
	 * 
	 * @param t
	 *            the array of length 3 containing xyz in order
	 */
	public SFVec3f(float t[]) {
		set(t);
	}

	public SFVec3f(SFVec3f other) {
		this.x = other.x;
		this.y = other.y;
		this.z = other.z;
	}

	/**
	 * Sets the value of this vector from the 3 values specified in the array.
	 * 
	 * @param t
	 *            the array of length 3 containing xyz in order
	 * @throws ArrayIndexOutOfBounds
	 *             is thrown if t.length < 3
	 */
	public final void set(float t[]) {
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
	public final void set(float x, float y, float z) {
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
		if (!(obj instanceof SFVec3f))
			return false;

		SFVec3f that = (SFVec3f) obj;
		return this.x == that.x && this.y == that.y && this.z == that.z;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Float.floatToIntBits(this.x) ^ Float.floatToIntBits(this.y)
				^ Float.floatToIntBits(this.z);
	}

	public float angleBetween(SFVec3f otherVector) {
		float dotProduct = dot(otherVector);
		float angle = (float) Math.acos(dotProduct);
		return angle;
	}

	public float dot(SFVec3f vec) {
		return x * vec.x + y * vec.y + z * vec.z;
	}

	public SFVec3f addLocal(SFVec3f vec) {
		x += vec.x;
		y += vec.y;
		z += vec.z;
		return this;
	}

	public float distanceSquared(SFVec3f v) {
		double dx = x - v.x;
		double dy = y - v.y;
		double dz = z - v.z;
		return (float) (dx * dx + dy * dy + dz * dz);
	}

	public SFVec3f normalizeLocal() {
		float length = length();
		if (length != 0) {
			return divideLocal(length);
		}

		return this;

	}

	public SFVec3f divideLocal(float scalar) {
		scalar = 1f / scalar;
		x *= scalar;
		y *= scalar;
		z *= scalar;
		return this;
	}

	public float length() {
		return (float) Math.sqrt(lengthSquared());
	}

	public float lengthSquared() {
		return x * x + y * y + z * z;
	}

	public SFVec3f subtract(SFVec3f vec, SFVec3f result) {
		if (result == null) {
			result = new SFVec3f();
		}
		result.x = x - vec.x;
		result.y = y - vec.y;
		result.z = z - vec.z;
		return result;
	}

	public SFVec3f crossLocal(SFVec3f v) {
		return crossLocal(v.x, v.y, v.z);
	}

	public SFVec3f crossLocal(float otherX, float otherY, float otherZ) {
		float tempx = (y * otherZ) - (z * otherY);
		float tempy = (z * otherX) - (x * otherZ);
		z = (x * otherY) - (y * otherX);
		x = tempx;
		y = tempy;
		return this;
	}

	public SFVec3f set(SFVec3f other) {
		this.x = other.x;
		this.y = other.y;
		this.z = other.z;
		return this;
	}

	public static SFVec3f sub(SFVec3f first, SFVec3f second, SFVec3f result) {
		if (result == null)
			result = new SFVec3f();
		result.set(first.x - second.x,
				   first.y - second.y,
				   first.z - second.z);
		return result;
	}
}
