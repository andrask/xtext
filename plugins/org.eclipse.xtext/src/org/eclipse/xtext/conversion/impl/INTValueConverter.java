/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class INTValueConverter extends AbstractLexerBasedConverter<Integer> {

	public INTValueConverter() {
		super();
	}
	
	@Override
	protected String toEscapedString(Integer value) {
		return value.toString();
	}
	
	@Override
	protected void assertValidValue(Integer value) {
		super.assertValidValue(value);
		if (value < 0)
			throw new ValueConverterException(getRuleName() + "-value may not be negative (value: " + value + ").", null, null);
	}
	
	public Integer toValue(String string, INode node) {
		if (Strings.isEmpty(string))
			throw new ValueConverterException("Couldn't convert empty string to an int value.", node, null);
		try {
			int intValue = Integer.parseInt(string, 10);
			return Integer.valueOf(intValue);
		} catch (NumberFormatException e) {
			throw new ValueConverterException("Couldn't convert '" + string + "' to an int value.", node, e);
		}
	}

}