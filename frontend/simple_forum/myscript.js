var title = window.document.getElementById("title");

var content = window.document.getElementById("content");

var btn = window.document.getElementById("btn");

var list = window.document.getElementById("list");

btn.addEventListener("click", function(){
    list.innerHTML = list.innerHTML +`
        <div class="article">
            <h2>${title.value}</h2>
            <p>${content.value}</p>
        </div>
    `;
})