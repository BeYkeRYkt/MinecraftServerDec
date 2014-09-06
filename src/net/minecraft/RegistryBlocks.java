package net.minecraft;

import org.apache.commons.lang3.Validate;

public class RegistryBlocks extends RegistryMaterials {

	private final Object defaultBlockName;
	private Object defaultObject;

	public RegistryBlocks(Object blockName) {
		this.defaultBlockName = blockName;
	}

	public void register(int id, BlockNameInfo nameInfo, Object object) {
		if (this.defaultBlockName.equals(nameInfo)) {
			this.defaultObject = object;
		}

		super.register(id, nameInfo, object);
	}

	public void validate() {
		Validate.notNull(this.defaultBlockName);
	}

	public Object getByName(Object nameInfo) {
		Object obj = super.getByName(nameInfo);
		return obj == null ? this.defaultObject : obj;
	}

	public Object getById(int id) {
		Object obj = super.getById(id);
		return obj == null ? this.defaultObject : obj;
	}

}
