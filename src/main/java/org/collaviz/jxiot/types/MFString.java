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
import java.util.Collection;
import java.util.Iterator;

public class MFString extends ArrayList<String> {

	private static final long serialVersionUID = 1L;

	public MFString() {
		super();
	}

	public MFString(Collection<? extends String> arg0) {
		super(arg0);
	}

	public MFString(int arg0) {
		super(arg0);
	}

	@Override
	public String toString() {
		if (size() == 0)
			return "";

		StringBuffer result = new StringBuffer();
		for (Iterator<String> I = iterator(); I.hasNext();) {
			result.append("\"");
			result.append(I.next());
			if (I.hasNext())
				result.append("\" ");
			else
				result.append("\"");
		}
		return result.toString();
	}

}
