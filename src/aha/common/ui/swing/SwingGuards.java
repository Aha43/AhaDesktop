package aha.common.ui.swing;

import static java.util.Objects.requireNonNull;

import javax.swing.Action;

/**
 * <p>
 *   Place for static utility methods that implements runtime checks on objects
 *   in the swing namespace, special argument checks.
 * </p>
 */
public final class SwingGuards {
	private SwingGuards() {}
	
	/**
	 * <p>
	 *   Throws
	 *   {@link IllegalArgumentException} if {@code action} does not have name
	 *   property set.
	 * </p>
	 * @param action {@link Action} to check.
	 * @param name   the name used in exception to refer to {@code action}
	 *               (typically a method parameter name).
	 * @return {@code action}.
	 * @throws NullPointerException if {@code action == null}.
	 * @throws IllegalArgumentException if {@code action} missing name.
	 */
	public static final Action requireIsNamed(Action action, String name) {
		requireNonNull(action, name);
		var aName = action.getValue(Action.NAME);
		if (!(aName instanceof String) || ((String) aName).isBlank())
		    throw new IllegalArgumentException(
		    	"Action " + aName + " must define Action.NAME");
		return action;
	}
	
	/**
	 * <p>
	 *   Throws
	 *   {@link IllegalArgumentException} if {@code action} does not have name
	 *   property set.
	 * </p>
	 * @param action {@link Action} to check.
	 * @return {@code action}.
	 * @throws NullPointerException if {@code action == null}.
	 * @throws IllegalArgumentException if {@code action} missing name.
	 */
	public static final Action requireIsNamed(Action action) {
		requireNonNull(action, "action");
		var aName = action.getValue(Action.NAME);
		if (!(aName instanceof String) || ((String) aName).isBlank())
		    throw new IllegalArgumentException(
		    	"Action must define Action.NAME");
		return action;
	}
	
}
