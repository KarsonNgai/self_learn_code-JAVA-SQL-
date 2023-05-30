import { useState } from "react";
import { BrowserRouter as Rounter, Route, Link, Routes } from "react-router-dom";
import HomePage from "./HomePage";
import LoginPage from "./login_page/LoginPage";
import LogOutPage from "./login_page/LogOutPage";
import LoginStatusPage from "./login_page/LoginStatusPage";
import NormalAccess from "./test_info/NormalAccess";
import ModAccess from "./test_info/ModAccess";
import AdminAccess from "./test_info/AdminAccess";
import Register from "./login_page/Register";

const Paging=()=>{
    const [myCookie,setMyCookie]= useState(null);

    function loginInLink(){
        const logInOutStyle = {width:"100%", textAlign:'right'};
        if(myCookie===null){
            return(<td style={logInOutStyle}><Link to="login">login</Link>{'\u00A0\u00A0\u00A0'}</td>)
        }
        return (<td style={logInOutStyle}><Link to="log-out">log_out</Link>{'\u00A0\u00A0\u00A0'}</td>)
    }

    return(
        <div className="Paging">
            <p>Cookie name: {myCookie===null?'no cookie right now':myCookie.split('=')[0]}</p>
            <Rounter>
                <table>
                    <tbody>
                        <tr>
                            <td><Link to="/">Home</Link>{'\u00A0\u00A0\u00A0'}</td>
                            <td><Link to="/normalAccess">Normal_info</Link>{'\u00A0\u00A0\u00A0'}</td>
                            <td><Link to="/modAccess">Mod_info</Link>{'\u00A0\u00A0\u00A0'}</td>
                            <td><Link to="/adminAccess">Admin_info</Link>{'\u00A0\u00A0\u00A0'}</td>
                            {loginInLink()}
                        </tr>
                    </tbody>
                </table>
                <Routes>
                    <Route exact path="/" element={<HomePage/>}/>
                    <Route exact path="/login" element={<LoginPage setCookie={setMyCookie}/>}/>
                    <Route exact path="/log-out" element={<LogOutPage setCookie={setMyCookie} />}/>
                    <Route exact path="/login-state" element={<LoginStatusPage/>}/>
                    <Route exact path="/register" element={<Register/>}/>
                    <Route exact path="/normalAccess" element={<NormalAccess myCookie={myCookie}/>}/>
                    <Route exact path="/modAccess" element={<ModAccess myCookie={myCookie}/>}/>
                    <Route exact path="/adminAccess" element={<AdminAccess myCookie={myCookie}/>}/>
                    
                </Routes>
            </Rounter>
        </div>
        );
    }
    
export default Paging;
//router
//npm i -D react-router-dom 