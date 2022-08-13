/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */






function addComment(storeId) {
    fetch("/SaleApp/api/add-comment", {
        method: 'post',
        body: JSON.stringify({
            "content": document.getElementById("commentId").value,
            "storeId": storeId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {

        console.info(res)
        return res.json();

    }).then(function (data) {

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
        
        location.reload()
    })

}

function addToCart(id, name, price) {

    event.preventDefault()

    fetch("/SaleApp/api/cart", {
        method: 'post',
        body: JSON.stringify({
            "foodId": id,
            "foodName": name,
            "price": price,
            "quantity": 1
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json()
    }).then(function (data) {
        let counter = document.getElementById("cartCounter")
        counter.innerText = data
    })


}

function updateCart(obj, foodId) {
    fetch("/SaleApp/api/cart", {
        method: 'put',
        body: JSON.stringify({
            "foodId": foodId,
            "foodName": "",
            "price": 0,
            "quantity": obj.value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json()
    }).then(function (data) {
        let counter = document.getElementById("cartCounter")
        counter.innerText = data.counter

        let amount = document.getElementById("amountCart")
        amount.innerText = data.amount
    })
}

function deleteCart(foodId) {
    if (confirm("Ban co chac chan xoa khong?") == true) {
        fetch(`/SaleApp/api/cart/${foodId}`, {
            method: 'delete'
        }).then(function (res) {
            return res.json()
        }).then(function (data) {
            let counter = document.getElementById("cartCounter")
            counter.innerText = data.counter

            let amount = document.getElementById("amountCart")
            amount.innerText = data.amount
            location.reload()
        })
    }

}


function pay(){
    if(confirm("Ban chac chan thanh toan?")== true){
        fetch("/SaleApp/api/pay", {
            method: 'post'
        }).then(function(res){
            return res.json();
        }).then(function(code){
            console.info(code);
            location.reload();
        })
        
        
    }
}







