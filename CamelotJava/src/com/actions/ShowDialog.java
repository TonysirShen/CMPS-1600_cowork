package com.actions;

public class ShowDialog implements IAction {
	boolean show;
	/**
	 * Shows or hide the main menu.
	 * @param show If true, shows the menu, otherwise, it will hide it.
	 */
	public ShowDialog(boolean show) {
		this.show=show;
	}
	/**
	 * @return "ShowMenu" or "HideMenu"
	 */
	@Override
	public String getName() {
		return show? "ShowMenu":"HideMenu";
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
