import { useState } from "react";
import Challange from "./Challange";

function ChallangeList({challanges}){
    return (
        <div className="list-group">
            {challanges.map(challange => (
                <Challange key={challange.id} challange={challange} />
            ))}
        </div>
    )
}

export default ChallangeList;