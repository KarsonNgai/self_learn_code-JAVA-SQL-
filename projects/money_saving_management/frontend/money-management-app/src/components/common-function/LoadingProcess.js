export const LoadingBox = (elementId) =>{
    document.getElementById(elementId).innerHTML = "loading...";
    return;
}

//handle status code in JSON
export const ResultBox = (elementId, statusCode)=>{
    if (statusCode==1){
        document.getElementById(elementId).innerHTML = "success";
        return;
    }
    document.getElementById(elementId).innerHTML = "fail, please find IT support";
}