/**
 * Created by Ayyad Shenouda on 2/4/2016.
 */

public class OffByN implements CharacterComparator {
	
	private int N;
	
	public OffByN(int N) {
		this.N = N;
	}

	@Override
	public boolean equalChars(char x, char y) {
		if(x - y == N || y - x == N) {
			return true;
		}
		return false;
	}
} 
