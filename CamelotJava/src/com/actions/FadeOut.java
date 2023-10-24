package com.actions;

public class FadeOut implements IAction {
	boolean fade;
	/**
	 * Shows or hide the main menu.
	 * @param show If true, shows the menu, otherwise, it will hide it.
	 */
	public FadeOut(boolean fade) {
		this.fade=fade;
	}
	/**
	 * @return "ShowMenu" or "HideMenu"
	 */
	@Override
	public String getName() {
		return fade? "FadeOut":"FadeIn";
	}
	/**
	 * @return true
	 */
	@Override
	public boolean getShouldWait() {
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s()", getName());
	}
}
