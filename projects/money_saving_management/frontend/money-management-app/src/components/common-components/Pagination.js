import { useEffect, useState } from "react";
import "./Pagination.css";

const Pagination=({itemsPerPage=5, data})=>{
    //setting, should be as a parameter
    const [items, setItems] = useState(data);
    
    
  
    const paginationContainerId = "#pagination"; // id that we want to put the data in

    //setting
    const ininalPage = 1;

    //round up the value
    const totalPages = Math.ceil(items.length/itemsPerPage);

    function showItems(page){
        
        const endIndex = page* itemsPerPage;
        const startIndex = endIndex - itemsPerPage;
        const itemsDisplayByPage = items.slice(startIndex, endIndex);

        //get the position that we want to display our item
        //, clear and create component in it
        const itemsContainer = document.querySelector("#items");
        itemsContainer.innerHTML = "";

        itemsDisplayByPage.forEach(i=>{
            const temp2 = document.createElement("tr");
         
            temp2.innerHTML = `<td>${i["transactionDate"]}</td>
            <td>${i['transactionAmount']}</td>
            <td>${i['transactionCategory']['transactionCategoryName']}
                <div>${i['transactionCategory']['transactionCategoryDetail']}</div></td>
            <td>${i['transactionCategory']['transactionType']['transactionTypeName']}
                <div>${i['transactionCategory']['transactionType']['transactionTypeDetail']}</div></td>`;

            //https://stackoverflow.com/questions/31913642/argument-1-of-node-appendchild-does-not-implement-interface-node
            
            itemsContainer.append(temp2);
        }
        )

    }

    function setupPagination(){
        const paginationComponent = document.querySelector(paginationContainerId);
        paginationComponent.innerHTML = ""

        for(let i = 1; i<=totalPages;i++){
            const pageLink = document.createElement("a");
            pageLink.href = "#";
            pageLink.innerText = i;

            if(i === ininalPage){
                pageLink.classList.add("active");
            }

            pageLink.addEventListener("click", (event)=>{
                event.preventDefault();
                //maybe we can just make it as 1?cause this function only run once when initial
                //ininalPage = i;
                showItems(i);

                const currentActive = paginationComponent.querySelector(".active");
                currentActive.classList.remove("active");
                pageLink.classList.add("active");
            })
            paginationComponent.appendChild(pageLink);
        }
    }

    useEffect(()=>{
        setupPagination();
        showItems(ininalPage);
       
    },[data])

    useEffect(()=>{
        setItems(data);
    },[data])

    return(
        <div id="abc">
            <table id="saving-table">
                <thead>
                    <tr>
                        <th>changeDate</th>
                        <th>changeValue</th>
                        <th>Category</th>
                        <th>Type</th>
                    </tr>
                </thead>
                <tbody id="items">
                    <tr></tr>
                </tbody>
            </table>
            
            <div id="pagination" className="pagination-container"></div>
        </div>
    )

}

export default Pagination;