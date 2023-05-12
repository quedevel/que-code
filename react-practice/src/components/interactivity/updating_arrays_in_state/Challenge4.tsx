import { useState } from 'react';
import produce from "immer";
import AddTodo from './AddTodo';
import TaskList from './TaskList';

let nextId = 3;
const initialTodos = [
    { id: 0, title: 'Buy milk', done: true },
    { id: 1, title: 'Eat tacos', done: false },
    { id: 2, title: 'Brew tea', done: false },
];

type Todo = {
    id: number
    title: string
    done: boolean
}

export default function TaskApp() {
    const [todos, setTodos] = useState<Array<Todo>>(
        initialTodos
    );

    function handleAddTodo(title: string) {
        setTodos(
            produce(todos, (draft: Todo[]) => {
                draft.push({
                    id: nextId++,
                    title: title,
                    done: false,
                });
            })
        );
    }

    function handleChangeTodo(nextTodo: Todo) {
        setTodos(
            produce(todos, (draft: Todo[]) => {
                const todo = draft.find((t: Todo) => t.id === nextTodo.id);
                if (todo) {
                    todo.title = nextTodo.title;
                    todo.done = nextTodo.done;
                }
            })
        );
    }

    function handleDeleteTodo(todoId: number) {
        setTodos(
            produce(todos, (draft: Todo[]) => {
                const index = draft.findIndex((t: Todo) => t.id === todoId);
                draft.splice(index, 1);
            })
        );
    }

    return (
        <>
            <AddTodo
                onAddTodo={handleAddTodo}
            />
            <TaskList
                todos={todos}
                onChangeTodo={handleChangeTodo}
                onDeleteTodo={handleDeleteTodo}
            />
        </>
    );
}
