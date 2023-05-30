import { useEffect, useState } from "react";

function ModAccess(props){
    const[data,setData] = useState(null);

    function fetchDataFromApi(){
        if(props.myCookie == null) return;
        
        //getMapping
        const urlForInfo = "http://localhost:8080/api/test/mod";
        const requestHeader = { method:"GET", 
                                mode:"cors", 
                                credentials:"include",
                                headers:{ "Accept":"application/json",
                                          "Content-Type":"application/json",
                                          "Cookie":props.myCookie}};
        
        fetch(urlForInfo, requestHeader)
        .then(response=>{
            if(response.ok){
                return response.json();
            }
            throw new Error("Error: response is not ok");
        })
        .then(json=>setData(json))
        .catch(err=>console.log(err));
    }

    useEffect(fetchDataFromApi,[]);

    return(
        <div>
            <p>statusCode: {data===null?"please login":data['statusCode']}</p>
            <p>content: {data===null?"please login":data['data']}</p>
        </div>
    )
}

export default ModAccess;