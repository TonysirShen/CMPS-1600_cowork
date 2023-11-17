package com.actions;
import com.actions.IAction;

public class Wait implements IAction {
	private int time;
	
	public Wait(int a) {
		this.time = a;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Wait";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%d)", getName(),this.time);
	}
}
