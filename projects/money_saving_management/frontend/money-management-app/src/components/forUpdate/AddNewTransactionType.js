import { useState } from "react";
import { IsRequiredDataExist, simpleFetchDataInJson } from "../common-function/FetchData";
import { LoadingBox, ResultBox } from "../common-function/LoadingProcess";

const AddNewTransactionTtype=()=>{

    // this is the api response
    const [data, setData] = useState('');

    function insertTheTransactionType(divElementId){
        document.getElementById('submitButton').disabled = true;
        

        let transactionTypeName = document.getElementById('transactionTypeName').value;
        let transactionTypeDetail = document.getElementById('transactionTypeDetail').value;
        
        //check if there are missing input
        if(IsRequiredDataExist(transactionTypeName, "transaction type name") || IsRequiredDataExist(transactionTypeDetail, "transactionTypeDetail")){
            document.getElementById('submitButton').disabled = false;
            return;
        }

        LoadingBox(divElementId);

        // post mapping
        const url = `http://localhost:8080/saving_management/api/v1/transaction-type`; 
        const requestBody = {
            "transactionTypeName": transactionTypeName,
            "transactionTypeDetail": transactionTypeDetail,
        }
        const requestHeader = {
                method: "POST",
                mode: "cors",
                headers: {
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': "*"
                },
                body: JSON.stringify(requestBody)
            };
        simpleFetchDataInJson(url, requestHeader)
        .then(responseData=>{setData(responseData);ResultBox(divElementId,1);})
        .catch(err=>console.log(err.message))

    }

    return (
        <div id="form-input-box">
            <p>this is for update the transaction type</p>
            <label>transactionTypeName<input id="transactionTypeName" type="text" required/></label>
            <br/>
            <label>transactionTypeDetail<input id="transactionTypeDetail" type="text" required/></label>
            <br/>
            <button id="submitButton" onClick={()=>insertTheTransactionType("form-input-box")}>submit</button>
        </div>
    )
}

export default AddNewTransactionTtype;