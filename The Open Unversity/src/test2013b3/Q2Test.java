package test2013b3;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q2Test {

	@Test
	public void test() {
		Q2.CharList c = new Q2.CharList("abcbabb");
		System.out.println(c.what('a', 'b'));
		assertEquals(6, c.what('a', 'b'));
	}

}
