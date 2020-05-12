import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.arraylist.MockArrayList;

public class MockArrayListTest {
	
	public MockArrayList<String> init() {
		MockArrayList<String> ls = new MockArrayList<String>();
		ls.add("1");
		ls.add("2");
		ls.add("3");
		return ls;
	}
	
	@Test
	public void add() {
		MockArrayList<String> ls = this.init();
		int res = ls.getSize();
		assertEquals("ok add ",3, res);
	}
		
	@Test
	public void getitemByIndex() {
		MockArrayList<String> ls =  this.init();
		String res = ls.getItem(0);
		assertEquals("1", res);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void getitemByIndexError() {
		MockArrayList<String> ls =  this.init();
		ls.getItem(1000);
	}
	
	@Test
	public void contain() {
		MockArrayList<String> ls = this.init();
		boolean bol = ls.contain("1");
		assertTrue(bol);
	}
	
	@Test
	public void containError() {
		MockArrayList<String> ls = this.init();
		boolean bol = ls.contain("Tari");
		assertFalse(bol);
	}
	
	@Test
	public void remove() {
		MockArrayList<String> ls = this.init();
		ls.remove("1");
		assertEquals("Removing 1 list", 2, ls.getSize());
	}
	
	@Test
	public void remove_1() {
		MockArrayList<String> ls = this.init();
		ls.remove("1000");
		assertEquals("Removing 1 list",3, ls.getSize());
	}
	
	@Test
	public void getSize() {
		MockArrayList<String> ls = this.init();
        assertEquals("getSize", 3, ls.getSize());
	}
}
