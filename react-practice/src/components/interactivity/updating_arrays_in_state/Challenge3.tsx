import { useState } from 'react'
import AddTodo from './AddTodo'
import TaskList from './TaskList'

let nextId = 3
const initialTodos = [
    { id: 0, title: 'Buy milk', done: true },
    { id: 1, title: 'Eat tacos', done: false },
    { id: 2, title: 'Brew tea', done: false },
]

type Todo = {
    id: number
    title: string
    done: boolean
}

export default function TaskApp() {
    const [todos, setTodos] = useState<Array<Todo>>(
        initialTodos
    )

    function handleAddTodo(title: string) {
        setTodos([
            ...todos,
            {
                id: nextId++,
                title: title,
                done: false
            }
        ])
    }

    function handleChangeTodo(nextTodo: Todo) {
        setTodos(todos.map((t: Todo) => { return t.id === nextTodo.id ? nextTodo : t }))
    }

    function handleDeleteTodo(todoId: number) {
        setTodos( todos.filter((t: Todo)  => t.id !== todoId))
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
    )
}
