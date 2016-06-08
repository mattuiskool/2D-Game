package events;

public class Event {
	
	public enum Type {
		MOUSE_PRESSED,
		MOUSE_RELEASED,
		MOUSE_MOVED,
		KEY_PRESSED,
		KEY_TYPED,
		KEY_RELEASED,
		WINDOW_LOST_FOCUS
	}
	
	private Type type;
	boolean handled;
	
	protected Event(Type type){
		this.type = type;
	}
	
	public Type getType(){
		return type;
	}
	
}
