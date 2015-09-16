package test2013b3;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q1Test {

	@Test
	public void test1() {
		assertTrue(Q1.match(new int[]{2,3,57}, new int[]{1,0,2}));
	}
	
	@Test
	public void test2(){
		assertTrue(Q1.match(new int[]{2,3,573,4,324,35}, new int[]{ }));
	}
	
	@Test
	public void test3(){
		assertTrue(Q1.match(new int[]{2,3,573,4,34,35} ,new int[]{1,0,2}));
	}
	
	@Test
	public void test4(){
		assertFalse(Q1.match(new int[]{2,3} ,new int[]{1,0,2}));
	}
	
	@Test
	public void test5(){
		assertFalse(Q1.match(new int[]{2,3,573,4,324,35} ,new int[]{1,0,2}));
	}
	
	@Test
	public void test6(){
		assertTrue(Q1.match(new int[]{} ,new int[]{}));
	}
	
	

}
