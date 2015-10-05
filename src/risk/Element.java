package risk;

public class Element implements Comparable<Element> {
	private String s;
	private int i;

	public Element(String s, int i) {
		this.s = s;
		this.i = i;
	}

	public int compareTo(Element arg0) {
		Integer i1 = new Integer(i);
		Integer i2 = new Integer(arg0.i);

		return i1.compareTo(i2);
	}

	public String toString() {
		return this.s + "," + this.i;
	}
}
