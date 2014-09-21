package net.minecraft;

class GameRule {

	private String data;
	private boolean isTrue;
	private int intValue;
	private final GameRuleValue type;

	public GameRule(String data, GameRuleValue type) {
		this.type = type;
		this.setRuleData(data);
	}

	public void setRuleData(String data) {
		this.data = data;
		this.isTrue = Boolean.parseBoolean(data);
		this.intValue = this.isTrue ? 1 : 0;

		try {
			this.intValue = Integer.parseInt(data);
		} catch (NumberFormatException var4) {
		}

	}

	public String getData() {
		return this.data;
	}

	public boolean isTrue() {
		return this.isTrue;
	}

	public int getNumericalValue() {
		return this.intValue;
	}

	public GameRuleValue getType() {
		return this.type;
	}

}
