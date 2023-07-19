import logo from './logo.png';
import './App.css';
import SampleForm from './components/SampleForm';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
       
        <a
          className="App-link"
          target="_blank"
        >
          <br></br>
          Welcome to my onboarding project!
        </a>
      </header>

      <SampleForm />
    </div>
  );
}

export default App;
