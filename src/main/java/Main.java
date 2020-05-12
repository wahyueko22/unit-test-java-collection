import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.arraylist.MockArrayList;

public class Main {
	//
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1 second = 1_000_000_000 nanosecond
		List<String> arr = new ArrayList<String>();
		long arrAddstart = System.nanoTime();
		for(int i=0; i<1000; i++) {
			arr.add("test" + i);
		}
		long arrAddend = System.nanoTime();
		System.out.println("elapsed time ArrayList add = " +  (arrAddend - arrAddstart));
		long arrGetstart = System.nanoTime();
		arr.get(10);
		long arrGetEnd = System.nanoTime();
		System.out.println("elapsed time ArrayList get = " +  (arrGetEnd - arrGetstart));
		long arrRemovestart = System.nanoTime();
		arr.remove(50);
		long arrRemoveEnd = System.nanoTime();
		System.out.println("elapsed time ArrayList remove = " +  (arrRemoveEnd - arrRemovestart));
	
		System.out.println();
		System.out.println();
		
		List<String> link = new LinkedList<String>();
		long linkAddStart = System.nanoTime();
		for(int i=0; i<1000; i++) {
			link.add("test" + i);
		}
		long linkAddEnd = System.nanoTime();
		System.out.println("elapsed time LinkedList add = " +  (linkAddEnd - linkAddStart));
		long linkGetStart = System.nanoTime();
		link.get(10);
		long linkGetEnd = System.nanoTime();
		System.out.println("elapsed time LinkedList get = " +  (linkGetEnd - linkGetStart));
		long linkRemovestart = System.nanoTime();
		link.remove(50);
		long linkRemoveEnd = System.nanoTime();
		System.out.println("elapsed time LinkedList remove = " +  (linkRemoveEnd - linkRemovestart));

	}

}
