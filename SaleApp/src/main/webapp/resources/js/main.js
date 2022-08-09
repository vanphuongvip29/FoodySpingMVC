/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */






function addComment(storeId){
    fetch("/SaleApp/api/add-comment",{
        method: 'post',
        body: JSON.stringify({
            "content" : document.getElementById("commentId").value,
            "storeId" : storeId
        }),
        headers: {
            "Content-Type" : "application/json"
        }
    }).then(function(res){
        
        console.info(res)
        return res.json();
         
    }).then(function(data){
        
        console.info(data);
        
        let area = document.getElementById("commentArea");
        
        area.innerHTML = `
            <div clas="row">
                <div class="commentDate">
                    <p>${data.content}</p>
                    <i>${moment(data.createdDate).fromNow()}</i>
                    <hr>
                </div>

            </div>
        ` + area.innerHTML
    })
    
}








