package com.hari.dsal.interval;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

	private List<Interval> insertInterval(List<Interval> il, Interval element) {
		List<Interval> result = new LinkedList<>();

		int i=0;
		while(i<il.size() && il.get(i).end < element.start) {
			result.add(il.get(i++));
		}

		while(i < il.size() && il.get(i).start <= element.end) {
			element = new Interval(
					Math.min(element.start, il.get(i).start),
					Math.max(element.end, il.get(i).end));
			i++;
			break;
		}
		result.add(element);
		while(i < il.size())
			result.add(il.get(i++));
		return result;
	}

	public static void main(String[] args) {
		Interval interval_1 = new Interval(2,3);
		Interval interval_2 = new Interval(3,4);
		Interval interval_3 = new Interval(5,6);
		Interval interval_4 = new Interval(6,7);
		Interval interval_5 = new Interval(7,8);
		Interval interval_6 = new Interval(8,9);
		Interval interval_7 = new Interval(9,10);

		List<Interval> input = Arrays.asList(interval_1,interval_2,interval_3,interval_4,interval_5,interval_6,interval_7);

		InsertInterval ii = new InsertInterval();
		Interval element = new Interval(4, 5);
		List<Interval> res = ii.insertInterval(input, element);

		res.forEach(i -> {
			System.out.print("["+i.start+","+i.end+"]");
		});
	}

};
