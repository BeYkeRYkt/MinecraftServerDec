package net.minecraft;

import com.mojang.authlib.GameProfile;
import java.util.Date;

class UserData {

	private final GameProfile profile;
	private final Date date;

	public UserData(GameProfile profile, Date date) {
		this.profile = profile;
		this.date = date;
	}

	public GameProfile getProfile() {
		return this.profile;
	}

	public Date getDate() {
		return this.date;
	}

}
