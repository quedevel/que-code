import React from 'react'
import Profile from "./components/describe/keeping_components_pure/Challenge2";

function App() {
  return (
    <div>
        <Profile person={{
            imageId: 'lrWQx8l',
            name: 'Subrahmanyan Chandrasekhar',
        }} />
        <Profile person={{
            imageId: 'MK3eW3A',
            name: 'Creola Katherine Johnson',
        }} />
    </div>
  )
}

export default App
