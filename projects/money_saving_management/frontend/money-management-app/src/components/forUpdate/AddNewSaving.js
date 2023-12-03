import { useState, useEffect } from "react";
import { IsRequiredDataExist, simpleFetchDataInJson } from "../common-function/FetchData";
import { LoadingBox, ResultBox } from "../common-function/LoadingProcess";


const AddNewSaving=()=>{

    const [categoryData, setCategoryData] = useState(null);
    //this is the api response
    //still do not provid
    const [data, setData] = useState('');

    useEffect(()=>{
        document.getElementById('transactionDate').value = new Date().toISOString().substring(0, 10);
        displayTheOptionOfTransactionCategory();
    },[])

    function displayTheOptionOfTransactionCategory(){
        const url = `http://localhost:8080/saving_management/api/v1/transaction-category`; 

        const requestHeader = {
                method: "GET",
                mode: "cors",
                headers: {
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': "*"
                }
            };
        simpleFetchDataInJson(url, requestHeader)
        .then(responseData=>setCategoryData(responseData))
        .catch(err=>console.log(err.message))
    }

    function renderingTheCategoryOptions(){
        //check if this is fetch, null mean fail to get
        if (categoryData===null){
            return;
        }
        //statusCode handle
        //it work when the error happen that not related to server, eg some data cannot be get because of some mistake
        if(categoryData['statusCode']!==200){
            console.log("inside the statusCode handle")
            console.log(categoryData['message']);
            return;
        }
        
        const optionsInSelect = [];
        let iterateTemp = categoryData['data'];

        for(let i =0;i<iterateTemp.length;i++){
            optionsInSelect.push(
                <option 
                    key={iterateTemp[i]["transactionCategoryId"]}
                    value={iterateTemp[i]["transactionCategoryId"]}>
                        {iterateTemp[i]["transactionCategoryName"]}</option>
            )
        }

        return optionsInSelect;
    }

    function insertTheTransaction(divElementId){
        document.getElementById('submitButton').disabled = true;
        let transactionDate = document.getElementById('transactionDate').value;
        let transactionAmount = document.getElementById('transactionAmount').value;
        let transactionCategoryId = document.getElementById('transactionCategoryId').value;
        
        //check if there are missing input
        if(IsRequiredDataExist(transactionDate, "transactionDate") || IsRequiredDataExist(transactionAmount, "transactionAmount") ||IsRequiredDataExist(transactionCategoryId, "transactionCategoryId")){
            document.getElementById('submitButton').disabled = false;
            return;
        }

        LoadingBox(divElementId);

        // post mapping
        const url = `http://localhost:8080/saving_management/api/v1/saving`;
        const requestBody = {
            "transactionDate": transactionDate,
            "transactionAmount": transactionAmount,
            "transactionCategoryId": transactionCategoryId
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
            <p>this is for update the saving</p>
            <label>transactionDate<input id="transactionDate" type="date" required/></label>
            <br/>
            <label>transactionAmount<input id="transactionAmount" type="number" required/></label>
            <br/><span>transactionCategoryId</span>
            <select id="transactionCategoryId">
                {renderingTheCategoryOptions()}
            </select>
            <button id="submitButton" onClick={()=>insertTheTransaction("form-input-box")}>submit</button>
        </div>)
} 

export default AddNewSaving;