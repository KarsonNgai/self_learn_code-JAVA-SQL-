export const simpleFetchDataInJson=(url, requestHeader)=>{
    return Promise.resolve(
        fetch(url, requestHeader)
        .then(response=>{
            if(! response.ok)throw new Error(`This is an HTTP error: The Status is ${response.status}`)
            return response.json();
        }));
}

export function IsRequiredDataExist(checkedData, whichData){
    if(checkedData === null || checkedData === ''|| checkedData === undefined){
        alert(`${whichData} is required`);
        return true;
    }
    return false;
}