package events.types;

import events.Event;
import layers.LayerManager;

public class KeyPressedEvent extends KeyboardEvent{

	public KeyPressedEvent(int button) {
		super(button, Event.Type.KEY_PRESSED);
	}

}
