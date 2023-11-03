package base.collection;

import java.util.Objects;

public class ClassWithSameHashCode {
	public String string;
	public int hashCode;

	public ClassWithSameHashCode(String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return "collection.ClassWithSameHashCode{" +
				"string='" + string + '\'' +
				"hashcode=" + hashCode +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ClassWithSameHashCode that = (ClassWithSameHashCode) o;
		return Objects.equals(string, string);
	}

	@Override
	public int hashCode() {
		hashCode = Objects.hash(0);
		return hashCode;
	}
}
