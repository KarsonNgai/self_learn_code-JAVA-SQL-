import { useEffect, useState } from "react";
import { IsRequiredDataExist, simpleFetchDataInJson } from "../common-function/FetchData";
import { LoadingBox, ResultBox } from "../common-function/LoadingProcess";

const AddNewTransactionCategory = ()=>{
    const [transactionTypeData, setTransactionTypeData] = useState(null);
    //this is the api response
    const [data, setData] = useState('');

    useEffect(()=>{
        displayTheOptionOfTransactionType();
    },[])

    function displayTheOptionOfTransactionType(){
        const url = `http://localhost:8080/saving_management/api/v1/transaction-type`; 

        const requestHeader = {
                method: "GET",
                mode: "cors",
                headers: {
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': "*"
                }
            };
        simpleFetchDataInJson(url, requestHeader)
        .then(responseData=>setTransactionTypeData(responseData))
        .catch(err=>console.log(err.message))
    }

    function renderingTheTransactionTypeOptions(){
        //check if this is fetch, null mean fail to get
        if (transactionTypeData===null){
            return;
        }
        //statusCode handle
        //it work when the error happen that not related to server, eg some data cannot be get because of some mistake
        if(transactionTypeData['statusCode']!==200){
            console.log("inside the statusCode handle")
            console.log(transactionTypeData['message']);
            return;
        }
        
        const optionsInSelect = [];
        let iterateTemp = transactionTypeData['data'];

        for(let i =0;i<iterateTemp.length;i++){
            optionsInSelect.push(
                <option 
                    key={iterateTemp[i]["transactionTypeId"]}
                    value={iterateTemp[i]["transactionTypeId"]}>
                        {iterateTemp[i]["transactionTypeName"]}</option>
            )
        }

        return optionsInSelect;
    }

    function insertThesavingDescription(divElementId){
        document.getElementById('submitButton').disabled = true;
        let transactionCategoryName = document.getElementById('transactionCategoryName').value;
        let transactionCategoryDetail = document.getElementById('transactionCategoryDetail').value;
        let transactionTypeId = document.getElementById('transactionTypeId').value;

        let isFixedTransaction = document.getElementById('isFixedTransaction').checked;//boolean
        
        //check if there are missing input
        if(IsRequiredDataExist(transactionCategoryName, "transactionCategoryName") || IsRequiredDataExist(transactionCategoryDetail, "transactionCategory")){
            document.getElementById('submitButton').disabled = false;
            return;
        }

        LoadingBox(divElementId);

        // post mapping
        const url = `http://localhost:8080/saving_management/api/v1/transaction-category`; 
        const requestBody = {
            "transactionCategoryName": transactionCategoryName,
            "transactionCategoryDetail": transactionCategoryDetail,
            "transactionTypeId": transactionTypeId,
            "isFixed" : isFixedTransaction
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

    return(
        <div id="form-input-box">
            <p>this is for update the transaction category</p>
            <label>transactionCategoryName<input id="transactionCategoryName" type="text" required/></label>
            <br/>
            <label>transactionCategoryDetail<input id="transactionCategoryDetail" type="text" required/></label>
            <br/>
            <label>is Fixed Transaction<input id="isFixedTransaction" type="checkbox" value="true"/></label>
            <select name="transactionTypeId" id="transactionTypeId">
                {renderingTheTransactionTypeOptions()}
            </select>
            <button id="submitButton" onClick={()=>insertThesavingDescription("form-input-box")}>submit</button>
        </div>
    )
}

export default AddNewTransactionCategory;