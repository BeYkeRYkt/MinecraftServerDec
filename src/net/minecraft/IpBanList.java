package net.minecraft;

import com.google.gson.JsonObject;
import java.io.File;
import java.net.SocketAddress;

public class IpBanList extends JsonList<String> {

	public IpBanList(File file) {
		super(file);
	}

	protected JsonListEntry<String> toListEntry(JsonObject jsonObject) {
		return new IpBanEntry(jsonObject);
	}

	public boolean isBanned(SocketAddress saddress) {
		String var2 = this.addressToString(saddress);
		return this.contains(var2);
	}

	public IpBanEntry getBanEntry(SocketAddress saddress) {
		String address = this.addressToString(saddress);
		return (IpBanEntry) this.get(address);
	}

	private String addressToString(SocketAddress address) {
		String addressString = address.toString();
		if (addressString.contains("/")) {
			addressString = addressString.substring(addressString.indexOf(47) + 1);
		}

		if (addressString.contains(":")) {
			addressString = addressString.substring(0, addressString.indexOf(58));
		}

		return addressString;
	}

}
