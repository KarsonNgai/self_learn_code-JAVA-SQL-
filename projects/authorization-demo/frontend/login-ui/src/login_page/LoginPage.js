import { useState } from "react";
import { useNavigate } from "react-router-dom";

function LoginPage(props){

    //login setting
    const [data, setData] = useState(null);
    let navigate = useNavigate();

    function loginFunction (loginUsername, loginPassword){
        if(loginUsername==='' || loginPassword===''){
            setData({"username":"login username or password is invalid"});
            return;
        }

        //postmapping signin
        const urlForSignIn="http://localhost:8080/api/auth/signin";
        const loginInfo = {username: loginUsername, password: loginPassword};
        const requestHeader = { method:"POST", 
                                mod:"cors", 
                                credentials:"include", 
                                headers:{"Content-Type": "application/json"},
                                body: JSON.stringify(loginInfo)
                            };

        fetch(urlForSignIn, requestHeader)
        .then(response=>{
            if(response.ok){
                props.setCookie(response.headers.get("x-auth-token"));
                return response.json();
            }
            throw new Error("Error: response is not ok");
        })
        .then(json=>{
            //console.log(json);
            setData(json);
            navigate(`/login-state`, {state:{data:json}});
        })
        .catch(err=>{setData({'username':"login username or password is invalid"});console.log(err);})
    }

    return(
        <div>
            <p>login message: {data!==null?data["username"]:"please login"}</p>

            <form id="login-form">
                <input type="text" id="lusername" defaultValue={"guest"}/>
                <input type="password" id="lpassword" defaultValue={"guestpassword"}/>
            </form>

            <button onClick={()=>{
                loginFunction(document.getElementById("lusername").value, document.getElementById("lpassword").value);
            }} disabled={data===null? false:true}>login</button>
            <p>Don't have account? <a href="/register">register new account</a></p>
        </div>
    )
}

export default LoginPage;