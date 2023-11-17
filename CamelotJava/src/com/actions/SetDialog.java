package com.actions;

public class SetDialog implements IAction {
	private String string;
	public SetDialog(String string){
		this.string = string;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "SetDialog";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return false;
	}
	public String toString() {
		return String.format("%s(%s)", getName(),this.string);
	}

}
