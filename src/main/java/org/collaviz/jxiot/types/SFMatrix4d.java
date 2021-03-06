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

public class SFMatrix4d {
	/**
	 * The first element of the first row.
	 */
	public double m00;

	/**
	 * The second element of the first row.
	 */
	public double m01;

	/**
	 * third element of the first row.
	 */
	public double m02;

	/**
	 * The fourth element of the first row.
	 */
	public double m03;

	/**
	 * The first element of the second row.
	 */
	public double m10;

	/**
	 * The second element of the second row.
	 */
	public double m11;

	/**
	 * The third element of the second row.
	 */
	public double m12;

	/**
	 * The fourth element of the second row.
	 */
	public double m13;

	/**
	 * The first element of the third row.
	 */
	public double m20;

	/**
	 * The second element of the third row.
	 */
	public double m21;

	/**
	 * The third element of the third row.
	 */
	public double m22;

	/**
	 * The fourth element of the third row.
	 */
	public double m23;

	/**
	 * The first element of the fourth row.
	 */
	public double m30;

	/**
	 * The second element of the fourth row.
	 */
	public double m31;

	/**
	 * The third element of the fourth row.
	 */
	public double m32;

	/**
	 * The fourth element of the fourth row.
	 */
	public double m33;

	/**
	 * 
	 * Constructs and initializes a SFMatrix4d from the specified 16 values.
	 * 
	 * @param m00
	 *            the [0][0] element
	 * @param m01
	 *            the [0][1] element
	 * @param m02
	 *            the [0][2] element
	 * @param m03
	 *            the [0][3] element
	 * @param m10
	 *            the [1][0] element
	 * @param m11
	 *            the [1][1] element
	 * @param m12
	 *            the [1][2] element
	 * @param m13
	 *            the [1][3] element
	 * @param m20
	 *            the [2][0] element
	 * @param m21
	 *            the [2][1] element
	 * @param m22
	 *            the [2][2] element
	 * @param m23
	 *            the [2][3] element
	 * @param m30
	 *            the [3][0] element
	 * @param m31
	 *            the [3][1] element
	 * @param m32
	 *            the [3][2] element
	 * @param m33
	 *            the [3][3] element
	 */
	public SFMatrix4d(double m00, double m01, double m02, double m03,
			double m10, double m11, double m12, double m13, double m20,
			double m21, double m22, double m23, double m30, double m31,
			double m32, double m33) {
		set(m00, m01, m02, m03, m10, m11, m12, m13, m20, m21, m22, m23, m30,
				m31, m32, m33);
	}

	/**
	 * Constructs and initializes a SFMatrix4d from the specified 16 element
	 * array. this.m00 =v[0], this.m01=v[1], etc.
	 * 
	 * @param v
	 *            the array of length 16 containing in order
	 */
	public SFMatrix4d(double v[]) {
		set(v);
	}

	/**
	 * Constructs and initializes a SFMatrix4d to identity matrix.
	 */
	public SFMatrix4d() {
		setIdentity();
	}

	/**
	 * Sets this SFMatrix4d to identity.
	 */
	public final void setIdentity() {
		this.m00 = 1.0f;
		this.m01 = 0.0f;
		this.m02 = 0.0f;
		this.m03 = 0.0f;
		this.m10 = 0.0f;
		this.m11 = 1.0f;
		this.m12 = 0.0f;
		this.m13 = 0.0f;
		this.m20 = 0.0f;
		this.m21 = 0.0f;
		this.m22 = 1.0f;
		this.m23 = 0.0f;
		this.m30 = 0.0f;
		this.m31 = 0.0f;
		this.m32 = 0.0f;
		this.m33 = 1.0f;
	}

	/**
	 * Sets the values in this SFMatrix4d equal to the row-major array parameter
	 * (ie, the first four elements of the array will be copied into the first
	 * row of this matrix, etc.).
	 * 
	 * @throws ArrayIndexOutOfBoundsException
	 *             if m.length < 16
	 */
	public final void set(double m[]) {
		this.m00 = m[0];
		this.m01 = m[1];
		this.m02 = m[2];
		this.m03 = m[3];
		this.m10 = m[4];
		this.m11 = m[5];
		this.m12 = m[6];
		this.m13 = m[7];
		this.m20 = m[8];
		this.m21 = m[9];
		this.m22 = m[10];
		this.m23 = m[11];
		this.m30 = m[12];
		this.m31 = m[13];
		this.m32 = m[14];
		this.m33 = m[15];
	}

	/**
	 * Sets the 16 values of this SFMatrix4d
	 */
	public void set(double m00, double m01, double m02, double m03, double m10,
			double m11, double m12, double m13, double m20, double m21,
			double m22, double m23, double m30, double m31, double m32,
			double m33) {
		this.m00 = m00;
		this.m01 = m01;
		this.m02 = m02;
		this.m03 = m03;
		this.m10 = m10;
		this.m11 = m11;
		this.m12 = m12;
		this.m13 = m13;
		this.m20 = m20;
		this.m21 = m21;
		this.m22 = m22;
		this.m23 = m23;
		this.m30 = m30;
		this.m31 = m31;
		this.m32 = m32;
		this.m33 = m33;
	}
}
