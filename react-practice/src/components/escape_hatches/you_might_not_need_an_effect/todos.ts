let nextId = 0;
let calls = 0;

export function getVisibleTodos(todos: Todo[], showActive: boolean) {
    console.log(`getVisibleTodos() was called ${++calls} times`);
    const activeTodos = todos.filter(todo => !todo.completed);
    return showActive ? activeTodos : todos;
}

export function createTodo(text: string, completed = false) {
    return {
        id: nextId++,
        text,
        completed
    };
}

export type Todo = {
    id: number
    text: string
    completed: boolean
}

export const initialTodos = [
    createTodo('Get apples', true),
    createTodo('Get oranges', true),
    createTodo('Get carrots'),
];
