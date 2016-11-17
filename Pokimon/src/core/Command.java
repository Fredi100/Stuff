package core;

/**
 * A Command defines what should happen if it gets called.
 * Execute will run the defined functionality, undo will reverse that
 * 
 * @author Fredi100
 * @version 2016-10-22
 */
public abstract class Command {
	
	public abstract void execute();
	
	public abstract void undo();
	
}
