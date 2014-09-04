package net.minecraft;

import com.google.common.base.Predicate;
import java.util.List;
import java.util.Random;

public class bfg extends bfh {

	public bfg(World var1, int var2, int var3) {
		super(var1, var2, var3);
	}

	public boolean a(int var1, int var2) {
		return var1 == this.a && var2 == this.b;
	}

	public int b(int var1, int var2) {
		return 0;
	}

	public void b() {
	}

	public atr a(dt var1) {
		return aty.a;
	}

	public int b(dt var1) {
		return 255;
	}

	public int c(dt var1) {
		return 0;
	}

	public int a(arf var1, dt var2) {
		return var1.c;
	}

	public void a(arf var1, dt var2, int var3) {
	}

	public int a(dt var1, int var2) {
		return 0;
	}

	public void a(Entity var1) {
	}

	public void b(Entity var1) {
	}

	public void a(Entity var1, int var2) {
	}

	public boolean d(dt var1) {
		return false;
	}

	public bcm a(dt var1, bfl var2) {
		return null;
	}

	public void a(bcm var1) {
	}

	public void a(dt var1, bcm var2) {
	}

	public void e(dt var1) {
	}

	public void c() {
	}

	public void d() {
	}

	public void e() {
	}

	public void a(Entity var1, brt var2, List var3, Predicate var4) {
	}

	public void a(Class var1, brt var2, List var3, Predicate var4) {
	}

	public boolean a(boolean var1) {
		return false;
	}

	public Random a(long var1) {
		return new Random(this.p().J() + (long) (this.a * this.a * 4987142) + (long) (this.a * 5947611) + (long) (this.b * this.b) * 4392871L + (long) (this.b * 389711) ^ var1);
	}

	public boolean f() {
		return true;
	}

	public boolean c(int var1, int var2) {
		return true;
	}
}
