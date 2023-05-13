export const initialState = {
    selectedId: 0,
    messages: {
        0: 'Hello, Taylor',
        1: 'Hello, Alice',
        2: 'Hello, Bob',
    },
};

export type StateProps = {
    selectedId: number;
    messages: Record<number, string>;
}

export type ChangedSelectionAction = { type: 'changed_selection', contactId: number };
export type EditedMessageAction = { type: 'edited_message', message: string };
export type SentMessageAction = { type: 'sent_message' };
export type ActionProps =
    | ChangedSelectionAction
    | EditedMessageAction
    | SentMessageAction;

export function messengerReducer(state: StateProps, action: ActionProps) {
    switch (action.type) {
        case 'changed_selection': {
            return {
                ...state,
                selectedId: action.contactId,
            };
        }
        case 'edited_message': {
            return {
                ...state,
                messages: {
                    ...state.messages,
                    [state.selectedId]: action.message,
                },
            };
        }
        case 'sent_message': {
            return {
                ...state,
                messages: {
                    ...state.messages,
                    [state.selectedId]: '',
                },
            };
        }
        default: {
            throw new Error('Unknown action type');
        }
    }
}
