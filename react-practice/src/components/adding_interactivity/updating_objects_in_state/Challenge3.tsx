import React, { useState } from 'react'
import Background from './Background'
import Box from './Box'
import produce from 'immer'

const initialPosition = {
    x: 0,
    y: 0
}

type Shape = {
    color: string
    position: Position
}

type Position = {
    x: number
    y: number
}

export default function Canvas() {
    const [shape, setShape] = useState<Shape>({
        color: 'orange',
        position: initialPosition
    })

    function handleMove(dx: number, dy: number) {
        setShape(produce(shape, (draft) => {
            draft.position.x += dx
            draft.position.y += dy
        }))
    }

    function handleColorChange(e: React.ChangeEvent<HTMLSelectElement>) {
        setShape(produce(shape, (draft) => {
            draft.color = e.target.value
        }))
    }

    return (
        <>
            <select
                value={shape.color}
                onChange={handleColorChange}
            >
                <option value="orange">orange</option>
                <option value="lightpink">lightpink</option>
                <option value="aliceblue">aliceblue</option>
            </select>
            <Background
                position={initialPosition}
            />
            <Box
                color={shape.color}
                position={shape.position}
                onMove={handleMove}
            >
                Drag me!
            </Box>
        </>
    )
}
