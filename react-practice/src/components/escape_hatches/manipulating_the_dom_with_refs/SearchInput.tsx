import React, { forwardRef } from 'react';

type SearchInputProps = React.HTMLProps<HTMLInputElement>;

const SearchInput = forwardRef<HTMLInputElement, SearchInputProps>(
    function SearchInput(props, ref) {
        return (
            <input
                {...props}
                ref={ref}
                placeholder="Looking for something?"
            />
        );
    }
);

export default SearchInput;