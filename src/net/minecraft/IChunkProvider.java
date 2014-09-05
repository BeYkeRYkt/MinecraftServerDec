package net.minecraft;

import java.util.List;

public interface IChunkProvider {

	boolean a(int var1, int var2);

	bfh d(int var1, int var2);

	bfh a(Position var1);

	void a(IChunkProvider var1, int var2, int var3);

	boolean a(IChunkProvider var1, bfh var2, int var3, int var4);

	boolean a(boolean var1, uy var2);

	boolean d();

	boolean e();

	String f();

	List a(xp var1, Position var2);

	Position a(World var1, String var2, Position var3);

	int g();

	void a(bfh var1, int var2, int var3);

	void c();
}
