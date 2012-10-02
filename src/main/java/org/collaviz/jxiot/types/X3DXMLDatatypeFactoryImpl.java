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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class X3DXMLDatatypeFactoryImpl {

	public final static String WS_COMMA_SEPARATOR = "[,\\s]+";
	public static final int ARBRITARY_SIZE = -1;
	public static final boolean SF = true;
	public static final boolean MF = false;

	public MFBool getMFBoolFromString(String value) throws Exception {
		String[] splits = value.trim().split(WS_COMMA_SEPARATOR);
		if (splits.length == 0)
			return new MFBool();
		boolean[] b = new boolean[splits.length];
		for (int i = 0; i < b.length; i++) {
			b[i] = Boolean.parseBoolean(splits[i]);
		}
		return new MFBool(b);
	}

	public MFColor getMFColorFromString(String value) throws Exception {
		float[] values = parseFloatArray(value, MF, 3);
		return new MFColor(values);
	}

	public MFColorRGBA getMFColorRGBAFromString(String value)
			throws Exception {
		float[] values = parseFloatArray(value, MF, 4);
		return new MFColorRGBA(values);
	}

	public MFDouble getMFDoubleFromString(String value)
			throws Exception {
		double[] values = parseDoubleArray(value, MF, ARBRITARY_SIZE);
		return new MFDouble(values);
	}

	public MFFloat getMFFloatFromString(String value) throws Exception {
		float[] values = parseFloatArray(value, MF, ARBRITARY_SIZE);
		return new MFFloat(values);
	}

	public MFImage getMFImageFromString(String value) throws Exception {
		// TODO Implement
		throw new UnsupportedOperationException();
	}

	public MFInt32 getMFInt32FromString(String value) throws Exception {
		int[] values = parseIntArray(value, MF, ARBRITARY_SIZE);
		return new MFInt32(values);
	}

	public MFMatrix3d getMFMatrix3dFromString(String value)
			throws Exception {
		// TODO Implement
		throw new UnsupportedOperationException();
	}

	public MFMatrix3f getMFMatrix3fFromString(String value)
			throws Exception {
		// TODO Implement
		throw new UnsupportedOperationException();
	}

	public MFMatrix4d getMFMatrix4dFromString(String value)
			throws Exception {
		// TODO Implement
		throw new UnsupportedOperationException();
	}

	public MFMatrix4f getMFMatrix4fFromString(String value)
			throws Exception {
		// TODO Implement
		throw new UnsupportedOperationException();
	}

	public MFRotation getMFRotationFromString(String value)
			throws Exception {
		float[] values = parseFloatArray(value, MF, 4);
		return new MFRotation(values);
	}

	public MFString getMFStringFromString(String value)
			throws Exception {
		boolean inString = false;
		String tmpString = "";

		if (value.length() == 0)
			return new MFString();

		/*
		 * A single non-quoted string This is not legal according to the spec,
		 * but commonly used so we handle it here.
		 */
		if (value.indexOf('\"') == -1)
			return new MFString(Collections.singletonList(value));

		List<String> result = new ArrayList<String>();

		for (int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);
			if (c == '\"') {
				inString = !inString;
				if (inString) // String starts
				{
					tmpString = "";
				} else {
					result.add(tmpString);
				}
			} else
				tmpString += c;
		}
		return new MFString(result);
	}

	public MFTime getMFTimeFromString(String value) throws Exception {
		double[] values = parseDoubleArray(value, MF, ARBRITARY_SIZE);
		return new MFTime(values);
	}

	public MFVec2d getMFVec2dFromString(String value) throws Exception {
		double[] values = parseDoubleArray(value, MF, 2);
		return new MFVec2d(values);
	}

	public MFVec2f getMFVec2fFromString(String value) throws Exception {
		float[] values = parseFloatArray(value, MF, 2);
		return new MFVec2f(values);
	}

	public MFVec3d getMFVec3dFromString(String value) throws Exception {
		double[] values = parseDoubleArray(value, MF, 3);
		return new MFVec3d(values);
	}

	public MFVec3f getMFVec3fFromString(String value) throws Exception {
		float[] values = parseFloatArray(value, MF, 3);
		return new MFVec3f(values);
	}

	public MFVec4d getMFVec4dFromString(String value) throws Exception {
		double[] values = parseDoubleArray(value, MF, 4);
		return new MFVec4d(values);
	}

	public MFVec4f getMFVec4fFromString(String value) throws Exception {
		float[] values = parseFloatArray(value, MF, 4);
		return new MFVec4f(values);
	}

	public boolean getSFBoolFromString(String value) throws Exception {
		value = value.trim().toLowerCase();
		if ("true".equals(value))
			return true;
		if ("false".equals(value))
			return false;
		throw new IllegalArgumentException(
				"Expected boolean value, but found: " + value);
	}

	public SFColor getSFColorFromString(String value) throws Exception {
		float[] colors = parseFloatArray(value, SF, 3);
		return new SFColor(colors);
	}

	public SFColorRGBA getSFColorRGBAFromString(String value)
			throws Exception {
		float[] colors = parseFloatArray(value, SF, 4);
		return new SFColorRGBA(colors);
	}

	public double getSFDoubleFromString(String value) throws Exception {
		return Double.parseDouble(value);
	}

	public float getSFFloatFromString(String value) throws Exception {
		return Float.parseFloat(value);
	}

	public SFImage getSFImageFromString(String value) throws Exception {
		int[] values = parseIntArray(value, SF, ARBRITARY_SIZE);
		return new SFImage(values);
	}

	public int getSFInt32FromString(String value) throws Exception {
		return Integer.parseInt(value);
	}

	public SFMatrix3d getSFMatrix3dFromString(String value)
			throws Exception {
		double[] values = parseDoubleArray(value, SF, 9);
		return new SFMatrix3d(values);
	}

	public SFMatrix3f getSFMatrix3fFromString(String value)
			throws Exception {
		float[] values = parseFloatArray(value, SF, 9);
		return new SFMatrix3f(values);
	}

	public SFMatrix4d getSFMatrix4dFromString(String value)
			throws Exception {
		double[] values = parseDoubleArray(value, SF, 16);
		return new SFMatrix4d(values);
	}

	public SFMatrix4f getSFMatrix4fFromString(String value)
			throws Exception {
		float[] values = parseFloatArray(value, SF, 16);
		return new SFMatrix4f(values);
	}

	public SFRotation getSFRotationFromString(String value)
			throws Exception {
		float[] values = parseFloatArray(value, SF, 4);
		return new SFRotation(values);
	}

	public String getSFStringFromString(String value) throws Exception {
		return value;
	}

	public double getSFTimeFromString(String value) throws Exception {
		return Double.parseDouble(value);
	}

	public SFVec2d getSFVec2dFromString(String value) throws Exception {
		double[] values = parseDoubleArray(value, SF, 2);
		return new SFVec2d(values);
	}

	public SFVec2f getSFVec2fFromString(String value) throws Exception {
		float[] values = parseFloatArray(value, SF, 2);
		return new SFVec2f(values);
	}

	public SFVec3d getSFVec3dFromString(String value) throws Exception {
		double[] values = parseDoubleArray(value, SF, 3);
		return new SFVec3d(values);
	}

	public SFVec3f getSFVec3fFromString(String value) throws Exception {
		float[] values = parseFloatArray(value, SF, 3);
		return new SFVec3f(values);
	}

	public SFVec4d getSFVec4dFromString(String value) throws Exception {
		double[] values = parseDoubleArray(value, SF, 4);
		return new SFVec4d(values);
	}

	public SFVec4f getSFVec4fFromString(String value) throws Exception {
		float[] values = parseFloatArray(value, SF, 4);
		return new SFVec4f(values);
	}

	public static float[] parseFloatArray(String value, boolean single,
			int tupleSize) throws Exception {
		
		if (value == null)
			return new float[0];
		
		value = value.trim();
		if (value.length() == 0)
			return new float[0];

		String[] splits = value.split(WS_COMMA_SEPARATOR);

		if (tupleSize != ARBRITARY_SIZE) {
			if (single && splits.length != tupleSize)
				throw new Exception("Expected " + tupleSize
						+ " float values but found " + splits.length + " ("
						+ value + ").");

			if (!single && splits.length % tupleSize != 0)
				throw new Exception("Expected multiple of "
						+ tupleSize + " values but found " + splits.length
						+ " (" + value + ").");
		}

		float[] result = new float[splits.length];
		int i = 0;
		try {
			for (i = 0; i < splits.length; i++) {
				result[i] = Float.parseFloat(splits[i]);
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Error parsing value number "
					+ i + ".", e);
		}
		return result;
	}

	public static double[] parseDoubleArray(String value, boolean single,
			int tupleSize) throws Exception {
		value = value.trim();
		if (value.length() == 0)
			return new double[0];

		String[] splits = value.split(WS_COMMA_SEPARATOR);

		if (tupleSize != ARBRITARY_SIZE) {
			if (single && splits.length != tupleSize)
				throw new Exception("Expected " + tupleSize
						+ " values but found " + splits.length + " (" + value
						+ ").");

			if (!single && splits.length % tupleSize != 0)
				throw new Exception("Expected multiple of "
						+ tupleSize + " values but found " + splits.length
						+ " (" + value + ").");
		}

		double[] result = new double[splits.length];
		int i = 0;
		try {
			for (i = 0; i < splits.length; i++) {
				result[i] = Double.parseDouble(splits[i]);
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Error parsing value number "
					+ i + ".", e);
		}
		return result;
	}

	public static int[] parseIntArray(String value, boolean single,
			int tupleSize) throws Exception {
		value = value.trim();
		if (value.length() == 0)
			return new int[0];

		String[] splits = value.split(WS_COMMA_SEPARATOR);

		if (tupleSize != ARBRITARY_SIZE) {
			if (single && splits.length != tupleSize)
				throw new Exception("Expected " + tupleSize
						+ " values but found " + splits.length + " (" + value
						+ ").");

			if (!single && splits.length % tupleSize != 0)
				throw new Exception("Expected multiple of "
						+ tupleSize + " values but found " + splits.length
						+ " (" + value + ").");
		}

		int[] result = new int[splits.length];
		int i = 0;
		try {
			for (i = 0; i < splits.length; i++) {
				result[i] = Integer.parseInt(splits[i]);
			}
		} catch (NumberFormatException e) {
			throw new Exception("Error parsing value number " + i
					+ ".", e);
		}
		return result;
	}
}
