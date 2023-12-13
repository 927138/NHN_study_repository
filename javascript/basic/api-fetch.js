const SERVER_URL="http://133.186.241.167:8100";
window.addEventListener("DOMContentLoaded",function(){
    'use strict';

    const loginForm = document.getElementById("login-form");
    
    const validateForm=function(form){
        if(form['userId'].value.trim() == '' ){
            alert("userId empty!");
            form['userId'].focus();
            return false;
        }
        if(form['userPassword'].value.trim() == '' ){
            alert("userPassword empty!");
            form['userPassword'].focus();
            return false;
        }
    }

    loginForm.addEventListener("submit", async function(event){
        event.preventDefault();
        if( validateForm(event.target)==false ){
            return ;
        }

        const userId = event.target["userId"].value;
        const userPassword = event.target["userPassword"].value;

        let user;

        try {
            user = await doLogin(userId, userPassword);
            console.log(user);
        } catch (error) {
            console.log(error);
            return;
        }

        let items;
        try {
            items = await getCartItems(user.userId, user.cartId);
            console.log(items);
            
            const cartTable = document.getElementById("cart-table");
            const body = cartTable.getElementsByTagName("tbody")[0];

            for (const item of items) {
                const tr = document.createElement("tr");
                const td1 = document.createElement("td");
                const td2 = document.createElement("td");
                const td3 = document.createElement("td");
                const td4 = document.createElement("td");
                const td5 = document.createElement("td");
                console.log(tr);
                td1.innerText=item.productId;
                td2.innerText=item.name;
                td3.innerText=item.price;
                td4.innerText=item.amount;
                td5.innerText= item.totalPrice;
                tr.append(td1,td2,td3,td4,td5);
                body.append(tr);
            }

        } catch (error) {
            console.log(error);
            return;
        }

    });
});

async function doLogin(userId, userPassword){

    const url = SERVER_URL+"/api/users/login";
    const data = {
        userId : userId,
        userPassword : userPassword
    };
    const options = {
        method : 'POST',
        headers : {
            'Content-type' : 'application/json'
        },
        body : JSON.stringify(data)
    };
    
    const response = await fetch(url, options);
    if(!response.ok){
        throw new Error("login error");
    }

    return await response.json();
}

async function getCartItems(userId, cartId){

    console.log(userId + ", " + cartId)
    const url = SERVER_URL + "/api/nhnmart/shopping-cart/" + cartId;
    const options = {
        method : 'GET',
        headers : {
            'Content-type' : 'application/json',
            'X-USER-ID' : userId
        }
    };

    const fetchPromise = await fetch(url, options);
    if(!fetchPromise.ok){
        throw new Error("cart items error");
    }

    return await fetchPromise.json();
    
}