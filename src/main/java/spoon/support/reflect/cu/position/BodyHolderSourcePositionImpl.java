/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon.support.reflect.cu.position;

import spoon.reflect.cu.position.BodyHolderSourcePosition;
import spoon.reflect.declaration.CtCompilationUnit;

/**
 * This class represents the position of a Java program element in a source
 * file.
 */
public class BodyHolderSourcePositionImpl extends DeclarationSourcePositionImpl
		implements BodyHolderSourcePosition {

	private static final long serialVersionUID = 1L;
	private int bodyStart;
	private int bodyEnd;

	public BodyHolderSourcePositionImpl(
			CtCompilationUnit compilationUnit,
			int nameStart, int nameEnd,
			int modifierSourceStart, int modifierSourceEnd,
			int declarationSourceStart, int declarationSourceEnd,
			int bodyStart,
			int bodyEnd,
			int[] lineSeparatorPositions) {
		super(compilationUnit,
				nameStart, nameEnd,
				modifierSourceStart, modifierSourceEnd,
				declarationSourceStart, declarationSourceEnd,
				lineSeparatorPositions);
		checkArgsAreAscending(declarationSourceStart, modifierSourceStart, modifierSourceEnd + 1, nameStart, nameEnd + 1, bodyStart, bodyEnd + 1, declarationSourceEnd + 1);
		this.bodyStart = bodyStart;
		this.bodyEnd = bodyEnd;
	}

	@Override
	public int getBodyStart() {
		return bodyStart;
	}

	@Override
	public int getBodyEnd() {
		return bodyEnd;
	}

	@Override
	public String getSourceDetails() {
		return super.getSourceDetails()
				+ "\nbody = " + getFragment(getBodyStart(), getBodyEnd());
	}
}
