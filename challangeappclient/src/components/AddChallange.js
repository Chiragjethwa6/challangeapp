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
        <div className="card my-5">
            <div className="card-header">
                Add New Challenge
            </div>
            <div className="card-body">
                <form onSubmit={handleSubmit}>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="month">Month</label>
                        <input className="form-control" placeholder="e.g, January" type="text" id="month" value={month} onChange={e => setMonth(e.target.value)}></input>
                    </div>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="description">Description</label>
                        <textarea className="form-control" placeholder="Describe Challenge" id="description" value={description} onChange={e => setDescription(e.target.value)}></textarea>
                    </div>
                    <button className="btn btn-primary" type="submit">Submit</button>
                </form>
            </div>
        </div>
    )
}

export default AddChallange;