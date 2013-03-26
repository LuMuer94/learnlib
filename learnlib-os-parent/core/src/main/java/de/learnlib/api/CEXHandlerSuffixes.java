/* Copyright (C) 2013 TU Dortmund
 * This file is part of LearnLib, http://www.learnlib.de/.
 * 
 * LearnLib is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License version 3.0 as published by the Free Software Foundation.
 * 
 * LearnLib is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with LearnLib; if not, see
 * <http://www.gnu.de/documents/lgpl.en.html>.
 */
package de.learnlib.api;

import net.automatalib.words.Word;

import java.util.Collection;

import de.learnlib.oracles.DefaultQuery;

/**
 * This interface specifies components that analize counterexamples
 * and generate a collection of suffixes which can be used by 
 * learning algorithms to produce a refined hypothesis. Some analysis
 * strategies will produce additional membership queries to yield a result.
 *
 * @author Maik Merten <maikmerten@googlemail.com>
 * 
 * @param <I> input symbol class
 * 
 */
public interface CEXHandlerSuffixes<I, O> {

    /**
     * Analize a counterexample and generate a set of counterexamples
     * that effect refinement of the current hypothesis constructed by
     * a learning algorithm.
     * 
     * @param ceQuery A Query that produces diverging output between the current hypothesis and the system under learning
     * @param suffixes A collection that shall be filled with the suffixes created during analysis
     */
    public void createSuffixes(DefaultQuery<I, O> ceQuery, Collection<Word<I>> suffixes);
	
}
