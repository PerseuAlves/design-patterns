package factoryMethod.factory;

import factoryMethod.entity.Message;
import factoryMethod.entity.TextMessage;

/**
 * Provides implementation for creating Text messages
 */
public class TextMessageCreator extends MessageCreator {

	@Override
	public Message createMessage() {
		return new TextMessage();
	}
}
