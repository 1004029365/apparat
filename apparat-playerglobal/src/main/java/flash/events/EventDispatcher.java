package flash.events;

import jitb.lang.annotations.Metadata;
import jitb.lang.annotations.Element;
import jitb.lang.closure.Function;
import jitb.lang.closure.Function1;

import java.util.*;

/**
 * @author Joa Ebert
 */
@Metadata({
	@Element(name="Event", keys={"name", "type"}, values={"deactivate", "flash.events.Event"}),
	@Element(name="Event", keys={"name", "type"}, values={"activate", "flash.events.Event"})})
public class EventDispatcher extends jitb.lang.Object implements IEventDispatcher {
	private final class EventListener implements Comparable<EventListener> {
		public final Function1<Event, Object> callback;
		public final boolean useCapture;
		public final int priority;

		public EventListener(final Function1<Event, Object> callback, final boolean useCapture, final int priority) {
			this.callback = callback;
			this.useCapture = useCapture;
			this.priority = priority;
		}

		@Override
		public int compareTo(final EventListener that) {
			if(null == that || this.priority > that.priority) {
				return 1;
			} else if(this.priority < that.priority) {
				return -1;
			} else {
				return 0;
			}
		}
	}


	private final Map<String, List<EventListener>> map = new HashMap<String, List<EventListener>>();

	@Override
	public boolean dispatchEvent(final Event event) {
		final List<EventListener> listOfListenersForType = map.get(event.type());

		if(null != listOfListenersForType && listOfListenersForType.size() > 0) {
			for(final EventListener listener : listOfListenersForType) {
				listener.callback.applyVoid1(null, event);
			}

			return true;
		}

		return false;
	}

	@Override
	public boolean hasEventListener(final String type) {
		final List<EventListener> listOfListenersForType = map.get(type);
		return null != listOfListenersForType && listOfListenersForType.size() > 0;
	}

	@Override
	public boolean willTrigger(final String type) {
		return false;
	}

	@Override
	public void addEventListener(final String type, final Function1<Event, Object> listener) {
		addEventListener(type, listener, false);
	}

	@Override
	public void addEventListener(final String type, final Function1<Event, Object> listener, final boolean useCapture) {
		addEventListener(type, listener, useCapture, 0);
	}

	@Override
	public void addEventListener(final String type, final Function1<Event, Object> listener, final boolean useCapture, final int priority) {
		addEventListener(type, listener, useCapture, priority, false);
	}

	@Override
	public void addEventListener(final String type, final Function1<Event, Object> listener, final boolean useCapture, final int priority, final boolean useWeakReference) {
		List<EventListener> listOfListenersForType = map.get(type);

		if(null == listOfListenersForType) {
			listOfListenersForType = new LinkedList<EventListener>();
			map.put(type, listOfListenersForType);
		}

		//TODO add weak reference here.
		listOfListenersForType.add(new EventListener(listener, useCapture, priority));
		Collections.sort(listOfListenersForType);
	}

	@Override
	public void addEventListener(final String type, final Function<Object> listener) {
		addEventListener(type, listener, false);
	}

	@Override
	public void addEventListener(final String type, final Function<Object> listener, final boolean useCapture) {
		addEventListener(type, listener, useCapture, 0);
	}

	@Override
	public void addEventListener(final String type, final Function<Object> listener, final boolean useCapture, final int priority) {
		addEventListener(type, listener, useCapture, priority, false);
	}

	@Override
	public void addEventListener(final String type, final Function<Object> listener, final boolean useCapture, final int priority, final boolean useWeakReference) {
		addEventListener(type, (Function1<Event, Object>)listener, useCapture, priority, useWeakReference);
	}

	@Override
	public void removeEventListener(final String type, final Function1<Event, Object> listener) {
		removeEventListener(type, listener, false);
	}

	@Override
	public void removeEventListener(final String type, final Function1<Event, Object> listener, final boolean useCapture) {
		final List<EventListener> listOfListenersForType = map.get(type);

		if(null == listOfListenersForType) {
			return;
		}

		final Iterator<EventListener> iter = listOfListenersForType.listIterator();

		while(iter.hasNext()) {
			final EventListener internalListener = iter.next();

			if(internalListener.useCapture == useCapture &&
					internalListener.callback == listener) {
				iter.remove();
				return;
			}
		}
	}

	@Override
	public void removeEventListener(final String type, final Function<Object> listener) {
		removeEventListener(type, listener, false);
	}

	@Override
	public void removeEventListener(final String type, final Function<Object> listener, final boolean useCapture) {
		removeEventListener(type, (Function1<Event, Object>)listener, useCapture);
	}
}
