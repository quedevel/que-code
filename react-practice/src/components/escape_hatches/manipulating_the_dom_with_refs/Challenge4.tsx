import { useRef } from 'react';
import SearchButton from './SearchButton';
import SearchInput from './SearchInput';

export default function Page() {
    const inputRef = useRef<HTMLInputElement>(null);
    return (
        <>
            <nav>
                <SearchButton onClick={() => {
                    if(inputRef.current){
                        inputRef.current.focus();
                    }
                }} />
            </nav>
            <SearchInput ref={inputRef} />
        </>
    );
}
