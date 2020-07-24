package juuxel.qurp;

public enum Algorithm {
	NONE {
		@Override
		public double modifyDelta(double delta) {
			return delta;
		}
	},

	QURP {
		@Override
		public double modifyDelta(double delta) {
			return Lerping.qurp(delta);
		}
	},

	HYPERP {
		@Override
		public double modifyDelta(double delta) {
			return Lerping.hyperp(delta);
		}
	},

	CURP {
		@Override
		public double modifyDelta(double delta) {
			return Lerping.curp(delta);
		}
	},

	ZERO {
		@Override
		public double modifyDelta(double delta) {
			return 0;
		}
	},

	HALF {
		@Override
		public double modifyDelta(double delta) {
			return 0.5;
		}
	},

	ONE {
		@Override
		public double modifyDelta(double delta) {
			return 1;
		}
	},

	;

	public abstract double modifyDelta(double delta);
}
