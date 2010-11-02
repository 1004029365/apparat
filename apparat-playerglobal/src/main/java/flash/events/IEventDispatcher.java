package flash.events;

import jitb.lang.closure.Function;
import jitb.lang.closure.Function1;

/**
 * @author Joa Ebert
 */
public interface IEventDispatcher {
	boolean dispatchEvent(final Event event);
	boolean hasEventListener(final String type);
	boolean willTrigger(final String type);
	void addEventListener(final String type, final Function1<Event, Object> listener);
	void addEventListener(final String type, final Function1<Event, Object> listener, final boolean useCapture);
	void addEventListener(final String type, final Function1<Event, Object> listener, final boolean useCapture,
						  final int priority);
	void addEventListener(final String type, final Function1<Event, Object> listener, final boolean useCapture,
						  final int priority, final boolean useWeakReference);

	void removeEventListener(final String type, final Function1<Event, Object> listener);
	void removeEventListener(final String type, final Function1<Event, Object> listener, final boolean useCapture);
	
	void addEventListener(final String type, final Function<Object> listener);
	void addEventListener(final String type, final Function<Object> listener, final boolean useCapture);
	void addEventListener(final String type, final Function<Object> listener, final boolean useCapture,
						  final int priority);
	void addEventListener(final String type, final Function<Object> listener, final boolean useCapture,
						  final int priority, final boolean useWeakReference);

	void removeEventListener(final String type, final Function<Object> listener);
	void removeEventListener(final String type, final Function<Object> listener, final boolean useCapture);
}
