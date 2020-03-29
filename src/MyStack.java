
public interface MyStack<E> {

	/**
	 *
	 * @param obj
	 */
	void push(E obj);

	/**
	 *
	 * @return
	 */
	E peek();

	/**
	 *
	 * @return
	 */
	E pop();

	/**
	 *
	 * @return
	 */
	boolean isEmpty();
}
