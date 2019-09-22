package MST;

import java.util.Iterator;

public class EdgeData {
	char start;
	char end;
	int distance;
	
	public EdgeData(char start, char end, int distance) {
		this.start= start;
		this.end = end;
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "EdgeData [start=" + start + ", end=" + end + ", distance=" + distance + "]";
	}
	
	
	
}
