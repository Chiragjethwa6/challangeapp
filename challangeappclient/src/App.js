import logo from './logo.svg';
import './App.css';
import ChallangeList from './components/ChallangeList';
import { useEffect, useState } from 'react';
import axios from 'axios';
import AddChallange from './components/AddChallange';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  const [challanges, setChallanges] = useState([]);

  useEffect(() => {
    fetchChallanges();
  }, []); 

  const fetchChallanges = async () => {
    try{
      const response = await axios.get('http://localhost:8080/challanges');
      setChallanges(response.data);
    }catch(e){
      console.error("error in fetching : ", e);
    }
  }  

  const handleChallangeAdded = () => {
    fetchChallanges();
  }
  return (
    <div className="container mt-5">
      <h1 className='text-center mb-4'>Monthly Challanges</h1>
      <AddChallange onChallangeAdded={handleChallangeAdded}/>
      <ChallangeList challanges = {challanges}/>
    </div>
  );
}

export default App;
