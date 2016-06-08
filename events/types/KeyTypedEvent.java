package events.types;

import events.Event;

public class KeyTypedEvent extends KeyboardEvent{

	public KeyTypedEvent(int button) {
		super(button, Event.Type.KEY_TYPED);
	}

}
