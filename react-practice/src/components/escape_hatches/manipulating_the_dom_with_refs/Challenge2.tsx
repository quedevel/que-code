import { useRef } from "react" 

export default function Page() {
    const ref = useRef<HTMLInputElement>(null)

    const handleFocus = () => {
        if (ref.current) ref.current.focus()
    }

    return (
        <>
            <nav>
                <button onClick={handleFocus}>Search</button>
            </nav>
            <input
                ref={ref}
                placeholder="Looking for something?"
            />
        </>
    ) 
}
