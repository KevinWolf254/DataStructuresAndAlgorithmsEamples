package co.ke.proaktiv.io.algorithms.depthfirstsearch;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class BasicsTest {
	private final char[][] edges = new char[][] {
		{'a', 'b'},
		{'a', 'c'},
		{'a', 'd'},
		{'b', 'e'},
		{'c', 'f'},
		{'d', 'f'},
		{'e', 'c'}
	};
	private final char src = 'a';
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	
	@Test
	void testPrintDirectedAcyclicGraphUsingStack() {
        System.setOut(new PrintStream(outputStream));
        
		// given
		Basics underTest = new Basics(this.edges, this.src);
		
		// when
		underTest.printDirectedAcyclicGraphUsingStack();
		
		// then
        System.setOut(System.out);
        String result = outputStream.toString().trim();

		try {
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		String expected = "a\r\nd\r\nf\r\nc\r\nf\r\nb\r\ne\r\nc\r\nf"; // adfcfbecf
        assertEquals(expected, result);
	}

	@Test
	void testPrintDirectedAcyclicGraphUsingRecursion() {
        System.setOut(new PrintStream(outputStream));
        
		// given
		Basics underTest = new Basics(this.edges, this.src);
		
		// when
		underTest.printDirectedAcyclicGraphUsingRecursion();
		
		// then
        System.setOut(System.out);
        String result = outputStream.toString().trim();

		try {
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		String expected = "a\r\nd\r\nf\r\nc\r\nf\r\nb\r\ne\r\nc\r\nf"; // adfcfbecf
        assertEquals(expected, result);
	}

}
