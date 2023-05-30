import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Register.css";

const Register=()=>{

    const [data, setData]= useState(null);
    const [usernameMessage, setUsernameMessage] = useState("username's length should be longer than 4 word");
    const [emailMessage, setEmailMessage] = useState("please provide a valid email");
    const [passwordMessage, setPasswordMessage] = useState("length of password should be greater than 8 and include at least 1 Capital letter, 1 special icon, 1 letter and 1 digital number");
    const [repasswordMessage, setRepasswordMessage] = useState("please retype the password");
    let navigate = useNavigate(); 

    function IsUsernameValid(checkedUsername){
        //in this app, username should be started with english, all should be contructed by number and english letter
        //regex
        if(checkedUsername.length<4) return setUsernameMessage("username's length should be longer than 4 word");
        
        return checkedUsername.match(/^[a-zA-Z][a-zA-Z0-9]*/)
                ?setUsernameMessage("done")
                :setUsernameMessage("username should be start with english letter and form by number and english only'");
    }

    function IsEmailValid(checkedEmail){
        return checkedEmail.match(/.+[@].+[.].+/)
                ?setEmailMessage("done")
                :setEmailMessage("please enter a valid email");
    }

    function IsPasswordStrongEnough(password){
        //not allow the user to set a very easy password so as to avoid rainbow table attack
        return true;
    }
    //the final goal would be changing the checking to be onChange, so the design of the follow funciton may seem too dump

    function checkPassword(password){
        if(password.length<8) return setPasswordMessage("length of password should be greater than 8 and include at least 1 Capital letter, 1 special icon, 1 letter and 1 digital number");
        if(!IsPasswordStrongEnough(password)) return setPasswordMessage("password is not strong enough");
        return setPasswordMessage("done");
    }

    function isRePasswordEqualPassword(password, retypePassword){
        return password !== retypePassword
                ?setRepasswordMessage("password and retype-password is not the same")
                :setRepasswordMessage("done");
    }

    function registerFunction(username, password, retypePassword, email){
        //validate

        console.log("now fetching");
        //fetch
        fetchRegister(username, password, email)
    }

    function IsInputStillMissing(){
        return ("done"!==usernameMessage || "done"!==passwordMessage 
            || "done"!==passwordMessage || "done"!==repasswordMessage);
    }

    function fetchRegister(username, password, email){
        const url = "http://localhost:8080/api/auth/signup";
        const info = {username:username, password:password, email:email, role:["users"]};
        const fetchHeader = {
            method:"POST", mode:"cors", headers:{"Content-Type":"application/json"},body:JSON.stringify(info)
        }

        fetch(url,fetchHeader)
        .then(response=>{
            if(response.ok){
                return response.json();
            }
            throw new Error("Error happen: something went wrong");
        })
        .then(json=>{
            setData(json);
            navigate(`/login-state`, {state:{data:json}})
        })
        .catch(err=>{console.log(err)});

    }


    return(
        <div>
            <p>this is register page</p>
            <form id="register-form">
                <p>username: <span className="instructionMessage">{usernameMessage}</span></p>
                <input type="text" id="username" onChange={()=>{IsUsernameValid(document.getElementById("username").value)}}/>
                <p>email: <span className="instructionMessage">{emailMessage}</span></p>
                <input type="text" id="email" onChange={()=>IsEmailValid(document.getElementById("email").value)}/>
                <p>password: <span className="instructionMessage">{passwordMessage}</span></p>
                <input type="password" id="password" onChange={()=>checkPassword(document.getElementById("password").value)}/>
                <p>retype password: <span className="instructionMessage">{repasswordMessage}</span></p>
                <input type="password" id="re-password" onChange={()=>isRePasswordEqualPassword(document.getElementById("password").value,document.getElementById("re-password").value)}/>
                
            </form>
            <button onClick={()=>{
                fetchRegister(document.getElementById("username").value, 
                                document.getElementById("password").value, 
                                document.getElementById("email").value);
                }} disabled={IsInputStillMissing()}>register</button>
            <br/><br/>
            <button onClick={()=>console.log(data)}>check the response</button>
        </div>
    )
}

export default Register;