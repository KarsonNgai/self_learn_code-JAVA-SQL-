import { useEffect, useState } from "react";
import { simpleFetchDataInJson } from "../common-function/FetchData";
import "./ViewAllSaving.css";
import Pagination from "../common-components/Pagination";


const ViewAllSaving=()=>{
    const [data, setData] = useState([]);

    useEffect(()=>{
        const url = `http://localhost:8080/saving_management/api/v1/all_saving`;
        const requestHeader = {
                method: "GET",
                mode: "cors",
                headers: {
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': "*"
                }
            };
        simpleFetchDataInJson(url, requestHeader)
        .then(responseData=>setData(responseData))
        .catch(err=>console.log(err.message))

    },[])

    //key is meaningless, just make it different and re-rendering
    //can use the response status code
    return(
        <div className="view-div">
            <Pagination itemsPerPage="20" data={data} key={data[0]}/>
        </div>
    )
}

export default ViewAllSaving;