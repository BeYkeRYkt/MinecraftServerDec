package net.minecraft;

import java.util.List;

public interface IChunkProvider {

	boolean a(int var1, int var2);

	Chunk d(int var1, int var2);

	Chunk a(Position var1);

	void a(IChunkProvider var1, int var2, int var3);

	boolean a(IChunkProvider var1, Chunk var2, int var3, int var4);

	boolean a(boolean var1, uy var2);

	boolean d();

	boolean e();

	String f();

	List a(xp var1, Position var2);

	Position a(World var1, String var2, Position var3);

	int g();

	void a(Chunk var1, int var2, int var3);

	void c();
}
