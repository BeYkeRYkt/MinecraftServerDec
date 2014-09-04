package net.minecraft;

public class boh {

	public static final boh[] a = new boh[64];
	public static final boh b = new boh(0, 0);
	public static final boh c = new boh(1, 8368696);
	public static final boh d = new boh(2, 16247203);
	public static final boh e = new boh(3, 10987431);
	public static final boh f = new boh(4, 16711680);
	public static final boh g = new boh(5, 10526975);
	public static final boh h = new boh(6, 10987431);
	public static final boh i = new boh(7, 31744);
	public static final boh j = new boh(8, 16777215);
	public static final boh k = new boh(9, 10791096);
	public static final boh l = new boh(10, 12020271);
	public static final boh m = new boh(11, 7368816);
	public static final boh n = new boh(12, 4210943);
	public static final boh o = new boh(13, 6837042);
	public static final boh p = new boh(14, 16776437);
	public static final boh q = new boh(15, 14188339);
	public static final boh r = new boh(16, 11685080);
	public static final boh s = new boh(17, 6724056);
	public static final boh t = new boh(18, 15066419);
	public static final boh u = new boh(19, 8375321);
	public static final boh v = new boh(20, 15892389);
	public static final boh w = new boh(21, 5000268);
	public static final boh x = new boh(22, 10066329);
	public static final boh y = new boh(23, 5013401);
	public static final boh z = new boh(24, 8339378);
	public static final boh A = new boh(25, 3361970);
	public static final boh B = new boh(26, 6704179);
	public static final boh C = new boh(27, 6717235);
	public static final boh D = new boh(28, 10040115);
	public static final boh E = new boh(29, 1644825);
	public static final boh F = new boh(30, 16445005);
	public static final boh G = new boh(31, 6085589);
	public static final boh H = new boh(32, 4882687);
	public static final boh I = new boh(33, '\ud93a');
	public static final boh J = new boh(34, 1381407);
	public static final boh K = new boh(35, 7340544);
	public final int L;
	public final int M;

	private boh(int var1, int var2) {
		if (var1 >= 0 && var1 <= 63) {
			this.M = var1;
			this.L = var2;
			a[var1] = this;
		} else {
			throw new IndexOutOfBoundsException("Map colour ID must be between 0 and 63 (inclusive)");
		}
	}

}
