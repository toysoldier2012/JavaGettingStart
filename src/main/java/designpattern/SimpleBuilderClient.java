package designpattern;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class SimpleBuilderClient {
	public static void main(String[] args) {
		SimpleBuilder build = new SimpleBuilder.Builder("o1", "o2").setO3("o3").build();
		System.out.println(build);
	}
}

@Getter
@ToString
class SimpleBuilder {
	private final Object o1;
	private final Object o2;
	private final Object o3;
	private final Object o4;

	public SimpleBuilder(Builder builder) {
		this.o1 = builder.o1;
		this.o2 = builder.o2;
		this.o3 = builder.o3;
		this.o4 = builder.o4;
	}

	public static class Builder {
		private final Object o1;
		private final Object o2;
		private Object o3;
		private Object o4;

		public Builder(Object o1, Object o2) {
			this.o1 = o1;
			this.o2 = o2;
		}

		public Builder setO3(Object o3) {
			this.o3 = o3;
			return this;
		}

		public Builder setO4(Object o4) {
			this.o4 = o4;
			return this;
		}

		public SimpleBuilder build() {
			return new SimpleBuilder(this);
		}
	}
}
