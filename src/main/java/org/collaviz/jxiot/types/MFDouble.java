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
import java.util.List;

public class MFDouble extends AbstractList<Double> implements List<Double> {

	protected double[] data;

	public MFDouble(double[] array) {
		this.data = array.clone();
	}

	@Override
	public Double get(int index) {
		return new Double(this.data[index]);
	}

	@Override
	public int size() {
		return this.data.length;
	}

	double[] getData() {
		return this.data;
	}

	@Override
	public String toString() {
		if (size() == 0)
			return "";

		StringBuffer result = new StringBuffer();
		for (int i = 0; i < size() - 1; i++) {
			result.append(this.data[i]);
			result.append(' ');
		}
		result.append(this.data[size() - 1]);
		return result.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof MFDouble))
			return false;

		MFDouble that = (MFDouble) obj;
		return Arrays.equals(that.data, this.data);
	}

}
