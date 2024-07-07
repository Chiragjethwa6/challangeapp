import logo from './logo.svg';
import './App.css';
import Greeting from './Components/Greeting';

function App() {
  return (
    <div className="App">
      <Greeting name="John" message="welcome"/>
    </div>
  );
}

export default App;
