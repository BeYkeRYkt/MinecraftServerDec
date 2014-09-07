package net.minecraft;

import com.google.common.base.Predicate;
import java.util.List;
import java.util.Random;

public class bfg extends Chunk {

	public bfg(World var1, int var2, int var3) {
		super(var1, var2, var3);
	}

	public boolean a(int var1, int var2) {
		return var1 == this.x && var2 == this.y;
	}

	public int b(int var1, int var2) {
		return 0;
	}

	public void b() {
	}

	public Block a(Position var1) {
		return Blocks.AIR;
	}

	public int b(Position var1) {
		return 255;
	}

	public int c(Position var1) {
		return 0;
	}

	public int a(arf var1, Position var2) {
		return var1.c;
	}

	public void a(arf var1, Position var2, int var3) {
	}

	public int a(Position var1, int var2) {
		return 0;
	}

	public void a(Entity var1) {
	}

	public void b(Entity var1) {
	}

	public void a(Entity var1, int var2) {
	}

	public boolean d(Position var1) {
		return false;
	}

	public TileEntity a(Position var1, bfl var2) {
		return null;
	}

	public void a(TileEntity var1) {
	}

	public void a(Position var1, TileEntity var2) {
	}

	public void e(Position var1) {
	}

	public void c() {
	}

	public void d() {
	}

	public void e() {
	}

	public void a(Entity var1, AxisAlignedBB var2, List var3, Predicate var4) {
	}

	public void a(Class var1, AxisAlignedBB var2, List var3, Predicate var4) {
	}

	public boolean a(boolean var1) {
		return false;
	}

	public Random a(long var1) {
		return new Random(this.getWorld().J() + (long) (this.x * this.x * 4987142) + (long) (this.x * 5947611) + (long) (this.y * this.y) * 4392871L + (long) (this.y * 389711) ^ var1);
	}

	public boolean f() {
		return true;
	}

	public boolean c(int var1, int var2) {
		return true;
	}
}
