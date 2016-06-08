package events.types;

import events.Event;

public class KeyboardEvent extends Event{
	
	protected int button;

	protected KeyboardEvent(int button, Type type) {
		super(type);
		this.button = button;
	}
	
	public int getButton() {
		return button;
	}

}
