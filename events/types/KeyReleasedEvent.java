package events.types;

import events.Event;
import layers.LayerManager;

public class KeyReleasedEvent extends KeyboardEvent{

	public KeyReleasedEvent(int button) {
		super(button, Event.Type.KEY_RELEASED);
	}

}
