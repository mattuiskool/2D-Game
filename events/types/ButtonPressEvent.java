package events.types;

import core.UI.UIButton;
import events.Event;

public class ButtonPressEvent extends Event{
	
	public UIButton button;
	
	public ButtonPressEvent(UIButton button) {
		super(Event.Type.BUTTON_PRESSED);
		this.button = button;
	}

}
