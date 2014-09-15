package net.minecraft;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class bed {

	private static final Joiner a = Joiner.on(", ");
	private static final Function b = new bee();
	private final Block c;
	private final ImmutableList d;
	private final ImmutableList e;

	public bed(Block var1, bex... var2) {
		this.c = var1;
		Arrays.sort(var2, new bef(this));
		this.d = ImmutableList.copyOf((Object[]) var2);
		LinkedHashMap var3 = Maps.newLinkedHashMap();
		ArrayList var4 = Lists.newArrayList();
		Iterable var5 = eb.a(this.e());
		Iterator var6 = var5.iterator();

		while (var6.hasNext()) {
			List var7 = (List) var6.next();
			Map var8 = eu.b(this.d, var7);
			BlockState var9 = new BlockState(var1, ImmutableMap.copyOf(var8), (bee) null);
			var3.put(var8, var9);
			var4.add(var9);
		}

		var6 = var4.iterator();

		while (var6.hasNext()) {
			BlockState var10 = (BlockState) var6.next();
			var10.a(var3);
		}

		this.e = ImmutableList.copyOf((Collection) var4);
	}

	public ImmutableList a() {
		return this.e;
	}

	private List e() {
		ArrayList var1 = Lists.newArrayList();

		for (int var2 = 0; var2 < this.d.size(); ++var2) {
			var1.add(((bex) this.d.get(var2)).c());
		}

		return var1;
	}

	public IBlockState b() {
		return (IBlockState) this.e.get(0);
	}

	public Block c() {
		return this.c;
	}

	public Collection d() {
		return this.d;
	}

	public String toString() {
		return Objects.toStringHelper((Object) this).add("block", Block.BLOCKREGISTRY.c(this.c)).add("properties", Iterables.transform(this.d, b)).toString();
	}

}
