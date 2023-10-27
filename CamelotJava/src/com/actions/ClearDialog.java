package com.actions;

public class ClearDialog implements IAction {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "ClearDialog";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String toString() {
		return String.format("%s()", getName());
	}

}
