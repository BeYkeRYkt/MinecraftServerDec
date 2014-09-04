package net.minecraft;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.ProfileLookupCallback;

class UserProfileLookupCallback implements ProfileLookupCallback {

	private final GameProfile[] a;

	UserProfileLookupCallback(GameProfile[] profileArray) {
		this.a = profileArray;
	}

	public void onProfileLookupSucceeded(GameProfile profile) {
		this.a[0] = profile;
	}

	public void onProfileLookupFailed(GameProfile profile, Exception ex) {
		this.a[0] = null;
	}

}
