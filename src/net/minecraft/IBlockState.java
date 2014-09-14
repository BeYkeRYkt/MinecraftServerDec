package net.minecraft;

import com.google.common.collect.ImmutableMap;
import java.util.Collection;

public interface IBlockState {

	Collection<?> a();

	Comparable<?> b(bex<?> var1);

	IBlockState a(bex<?> var1, Comparable<?> var2);

	IBlockState a(bex<?> var1);

	ImmutableMap<?, ?> b();

	Block getBlock();

}
