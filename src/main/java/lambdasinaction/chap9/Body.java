package lambdasinaction.chap9;

public class Body implements Sized {

	public static void main(String[] args) {
		System.out.println(new Body().size());
	}

	@Override
	public int size() {
		return 20;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}
}
