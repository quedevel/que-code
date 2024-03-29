import React, { useEffect, useRef } from 'react' 

interface MyInputProps {
    shouldFocus: boolean 
    value: string 
    onChange: (event: React.ChangeEvent<HTMLInputElement>) => void 
}

export default function MyInput({ shouldFocus, value, onChange }: MyInputProps) {
    const ref = useRef<HTMLInputElement>(null) 

    useEffect(() => {
        if (shouldFocus && ref.current) {
            ref.current.focus() 
        }
    }, [shouldFocus]) 

    return (
        <input
            ref={ref}
            value={value}
            onChange={onChange}
        />
    ) 
}
