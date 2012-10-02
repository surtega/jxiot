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

public class SFMatrix3f {
	/**
	 * The first element of the first row.
	 */
	public float m00;

	/**
	 * The second element of the first row.
	 */
	public float m01;

	/**
	 * third element of the first row.
	 */
	public float m02;

	/**
	 * The first element of the second row.
	 */
	public float m10;

	/**
	 * The second element of the second row.
	 */
	public float m11;

	/**
	 * The third element of the second row.
	 */
	public float m12;

	/**
	 * The first element of the third row.
	 */
	public float m20;

	/**
	 * The second element of the third row.
	 */
	public float m21;

	/**
	 * The third element of the third row.
	 */
	public float m22;

	/**
	 * Constructs and initializes a SFMatrix3f from the specified nine values.
	 * 
	 * @param m00
	 *            the [0][0] element
	 * @param m01
	 *            the [0][1] element
	 * @param m02
	 *            the [0][2] element
	 * @param m10
	 *            the [1][0] element
	 * @param m11
	 *            the [1][1] element
	 * @param m12
	 *            the [1][2] element
	 * @param m20
	 *            the [2][0] element
	 * @param m21
	 *            the [2][1] element
	 * @param m22
	 *            the [2][2] element
	 */
	public SFMatrix3f(float m00, float m01, float m02, float m10, float m11,
			float m12, float m20, float m21, float m22) {
		set(m00, m01, m02, m10, m11, m12, m20, m21, m22);
	}

	/**
	 * Constructs and initializes a SFMatrix3f from the specified 9 element
	 * array. this.m00 =v[0], this.m01=v[1], etc.
	 * 
	 * @param v
	 *            the array of length 9 containing in order
	 */
	public SFMatrix3f(float v[]) {
		set(v);
	}

	/**
	 * Constructs and initializes a SFMatrix3f to identity matrix.
	 */
	public SFMatrix3f() {
		setIdentity();
	}

	/**
	 * Sets this SFMatrix3f to identity.
	 */
	public final void setIdentity() {
		this.m00 = 1.0f;
		this.m01 = 0.0f;
		this.m02 = 0.0f;
		this.m10 = 0.0f;
		this.m11 = 1.0f;
		this.m12 = 0.0f;
		this.m20 = 0.0f;
		this.m21 = 0.0f;
		this.m22 = 1.0f;
	}

	/**
	 * Sets 9 values
	 */
	public void set(float m00, float m01, float m02, float m10, float m11,
			float m12, float m20, float m21, float m22) {
		this.m00 = m00;
		this.m01 = m01;
		this.m02 = m02;
		this.m10 = m10;
		this.m11 = m11;
		this.m12 = m12;
		this.m20 = m20;
		this.m21 = m21;
		this.m22 = m22;
	}

	/**
	 * Sets the values in this SFMatrix3f equal to the row-major array parameter
	 * (ie, the first four elements of the array will be copied into the first
	 * row of this matrix, etc.).
	 */
	public final void set(float m[]) {
		this.m00 = m[0];
		this.m01 = m[1];
		this.m02 = m[2];
		this.m10 = m[3];
		this.m11 = m[4];
		this.m12 = m[5];
		this.m20 = m[6];
		this.m21 = m[7];
		this.m22 = m[8];
	}

}
