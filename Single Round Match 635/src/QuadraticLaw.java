

public class QuadraticLaw {
	
	public long getTime(long d) {
        long upper = (long) Math.sqrt(d);
        for (long i = upper; i >= 0; i--) {
            if(i + i*i <= d) return i;
        }
        return 0;
	}
}
