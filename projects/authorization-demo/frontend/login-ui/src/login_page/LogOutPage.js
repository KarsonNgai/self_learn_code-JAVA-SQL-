import { useEffect, useState } from "react";

function LogOutPage(props){
    const [data,setData] = useState(null);

    useEffect(()=>logOutFunction(),[]);

    function logOutFunction (){
        //postmapping signin
        const urlForSignIn="http://localhost:8080/api/auth/signout";
        const requestHeader = { method:"POST", 
                                mod:"cors", 
                                credentials:"include", 
                                headers:{"Content-Type": "application/json"}
                            };

        fetch(urlForSignIn, requestHeader)
        .then(response=>{
            if(response.ok){
                //props.setCookie(response.headers.get("x-auth-token"));
                return response.json();
            }
            throw new Error("Error: response is not ok");
        })
        .then(json=>{
            //console.log(json);
            props.setCookie(null);
            setData(json);
        })
        .catch(err=>{setData({'username':"login username or password is invalid"});console.log(err);});
    }

    return(
        <div>
            <p>login message: {data!==null?data["msg"]:"cannot fetch data"}</p>
        </div>
    )
}

export default LogOutPage;