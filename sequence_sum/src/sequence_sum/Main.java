package sequence_sum;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) 
	{
		System.out.println(SequenceSum(10));
	}
	
	public static String SequenceSum(int value)
	{
		if(value < 0)
		{
			return String.valueOf(value) + "<0";
		}
		if(value == 0)
		{
			return "0=0";
		}
		IntStream sequence = IntStream.rangeClosed(0, value);
	    int sum = IntStream.rangeClosed(0, value).sum();
		int[] arr = sequence.toArray();
		String result = Arrays.stream(arr)
			    .mapToObj(i -> ((Integer) i).toString())
			    .collect(Collectors.joining("+"));
		return String.join("+", result + "=" + String.valueOf(sum));
	}
}
