/* Copyright (C) 2017 TU Dortmund
 * This file is part of LearnLib, http://www.learnlib.de/.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.learnlib.algorithms.adt.learner;

import net.automatalib.automata.transout.impl.compact.CompactMealy;
import net.automatalib.util.automata.random.RandomAutomata;
import net.automatalib.words.Alphabet;
import net.automatalib.words.impl.Alphabets;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import java.util.Iterator;
import java.util.Random;

/**
 * Test for {@link ADTLearner}.
 *
 * @author frohme.
 */
public class ADTLearnerRandomMealy2Test extends AbstractADTLearnerTest<Integer, Character> {

	private static final Alphabet<Integer> INPUTS = Alphabets.integers(1, 2);
	private static final Alphabet<Character> OUTPUTS = Alphabets.characters('a', 'b');

	private final int size;

	@Factory(dataProvider = "sizes")
	public ADTLearnerRandomMealy2Test(final int size) {
		this.size = size;
	}

	@DataProvider(name = "sizes")
	public static Iterator<Object[]> getSizes() {
		return AbstractADTLearnerTest.generateSizes(BIG_AUTOMATON_SIZE);
	}

	@Override
	protected CompactMealy<Integer, Character> getTarget() {
		return RandomAutomata.randomMealy(new Random(1337), this.size, INPUTS, OUTPUTS);
	}
}