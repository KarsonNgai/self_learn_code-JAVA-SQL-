import { useLocation } from "react-router-dom";

function LoginStatusPage(){
    let loginStatus = useLocation();

    function iterateStateAndRender(){
        let personalStatus = [];
        if(loginStatus.state!==null){
            let littleObject = loginStatus.state['data'];

            for(const property in littleObject){
                personalStatus.push(
                    <li key={property}>{property}: {littleObject[property]}</li>
                )
            }
        }
        return personalStatus;
    }

    return(
        <ul>    
            {iterateStateAndRender()}
        </ul>)
}

export default LoginStatusPage;