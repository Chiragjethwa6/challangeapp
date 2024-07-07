import { useState } from "react";
import axios from "axios";

function AddChallange({onChallangeAdded}){
    const [month, setMonth] = useState('');
    const [description, setDescription] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try{
            await axios.post('http://localhost:8080/challanges', {month, description});
            setMonth('');
            setDescription('');
            onChallangeAdded();
        }catch(e){
            console.error("error in adding : ", e);
        }
    }

    return (
        <div>
            <form>
                <div>
                    <label htmlFor="month">Month</label>
                    <input type="text" id="month" value={month} onChange={e => setMonth(e.target.value)}></input>
                </div>
                <div>
                    <label htmlFor="description">Description</label>
                    <textarea id="description" value={description} onChange={e => setDescription(e.target.value)}></textarea>
                </div>
                <button onClick={handleSubmit} type="submit">Submit</button>
            </form>
            
        </div>
    )
}

export default AddChallange;